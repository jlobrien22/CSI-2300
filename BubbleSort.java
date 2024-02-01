import java.io.*;
import java.util.*;

public class BubbleSort {

    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // Generates random integers between 0 and 100
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        System.out.println("1. Generate an array of random integers and store it in a file");
        System.out.println("2. Read an existing file containing a list of integers, sort it, and store the sorted array in another file");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the length of the random array: ");
                int length = scanner.nextInt();
                int[] randomArray = createRandomArray(length);
                writeArrayToFile(randomArray, "random_array.txt");
                System.out.println("Random array generated and stored in 'random_array.txt'");
                break;
            case 2:
                System.out.println("Enter the filename containing the unsorted integers: ");
                scanner.nextLine(); // Consume newline character
                String inputFile = scanner.nextLine();
                int[] unsortedArray = readFileToArray(inputFile);
                bubbleSort(unsortedArray);
                System.out.println("Enter the filename to store the sorted array: ");
                String outputFile = scanner.nextLine();
                writeArrayToFile(unsortedArray, outputFile);
                System.out.println("Sorted array stored in '" + outputFile + "'");
                break;
            default:
                System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
