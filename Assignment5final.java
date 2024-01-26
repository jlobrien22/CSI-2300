import java.io.*;
import java.util.*;

public class Assignment5 {

    public static void main(String[] args) {
        if (args.length == 2) {
            // Case 1: User provided file names as command-line arguments
            readAndMultiplyFromFiles(args[0], args[1]);
        } else if (args.length == 1) {
            // Case 2: User provided an integer as a command-line argument
            int size = Integer.parseInt(args[0]);
            generateAndMultiplyRandomMatrices(size);
        } else {
            // Case 3: No command-line arguments, use user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter two file names or an integer: ");
            String input = scanner.nextLine();
            try {
                int size = Integer.parseInt(input);
                generateAndMultiplyRandomMatrices(size);
            } catch (NumberFormatException e) {
                // Assume input is file names
                String[] files = input.split(" ");
                readAndMultiplyFromFiles(files[0], files[1]);
            }
            scanner.close(); // Close the scanner after use
        }
    }

    private static void readAndMultiplyFromFiles(String file1, String file2) {
        // Read matrices from files
        int[][] matrix1 = readMatrixFromFile(file1);
        int[][] matrix2 = readMatrixFromFile(file2);

        // Perform matrix multiplication
        if (matrix1 != null && matrix2 != null && matrix1[0].length == matrix2.length) {
            int[][] result = multiplyMatrices(matrix1, matrix2);
            if (result != null) {
                // Save matrices and result to files
                saveMatrixToFile(matrix1, "matrix1.txt");
                saveMatrixToFile(matrix2, "matrix2.txt");
                saveMatrixToFile(result, "result.txt");
            }
        } else {
            System.out.println("Matrix multiplication not possible: incompatible dimensions.");
        }
    }

    private static int[][] generateRandomMatrix(int size) {
        int rows;
        int cols;
        rows = cols = size;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(101); // Generate random integers from 0 to 100
            }
        }
        return matrix;
    }
//Call function
private static void generateAndMultiplyRandomMatrices(int size) {
        // Generate random matrices
        // int[][] matrix1 = generateRandomMatrix(3, 2); // 3x2 matrix
        // int[][] matrix2 = generateRandomMatrix(2, 3); // 2x3 matrix
        int[][] matrix1 = generateRandomMatrix(size);
        int[][] matrix2 = generateRandomMatrix(size);

    private static void saveMatrixToFile(int[][] matrix, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int num : row) {
                    writer.print(num + " ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error: Could not write to file: " + filename);
        }
    }
    
    private static int[][] readMatrixFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filename);
            return null;
        }
    }
    
    // Helper method for generating random matrix
    private static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(101); // Generate random integers from 0 to 100
            }
        }
        return matrix;
    }
}
