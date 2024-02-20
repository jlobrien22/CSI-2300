import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password to validate:");
        String password = scanner.nextLine();
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        // Check length requirement
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check for at least 3 out of 4 categories
        int categoriesCount = 0;
        if (containsLowerCase(password)) categoriesCount++;
        if (containsUpperCase(password)) categoriesCount++;
        if (containsDigit(password)) categoriesCount++;
        if (containsSpecialCharacter(password)) categoriesCount++;

        return categoriesCount >= 3;
    }

    private static boolean containsLowerCase(String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsUpperCase(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsDigit(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[~!@#$%^&*()-=+_]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
