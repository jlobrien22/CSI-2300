import java.util.Scanner;

public class test
 
{

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to metric converter!");
        System.out.println("Please input your query (e.g., 1 km = mile, 1 g = oz, 1 kg = lb, 1 mm = inch).");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            System.out.print("Enter your query: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit") || userInput.equals("-1")) {
                break;
            }

            try {
                String[] parts = userInput.split(" ");
                double value = Double.parseDouble(parts[0]);
                String fromUnit = parts[1];
                String toUnit = parts[3];

                double result = 0;

                if (fromUnit.equalsIgnoreCase("kg") && toUnit.equalsIgnoreCase("lb")) {
                    result = kgToLb(value);
                } else if (fromUnit.equalsIgnoreCase("g") && toUnit.equalsIgnoreCase("oz")) {
                    result = gToOz(value);
                } else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("mile")) {
                    result = kmToMile(value);
                } else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("inch")) {
                    result = mmToInch(value);
                } else {
                    System.out.println("Conversion not supported. Please check supported units.");
                    continue;
                }

                System.out.println(value + " " + fromUnit + " = " + result + " " + toUnit);
            } catch (Exception e) {
                System.out.println("Invalid input format. Please try again.");
            }
        }

        System.out.println("Thank you for using the metric converter!");
        scanner.close();
    }

    // Conversion methods
    public static double kgToLb(double kg) {
        return kg * 2.20462;
    }

    public static double gToOz(double g) {
        return g * 0.035274;
    }

    public static double kmToMile(double km) {
        return km * 0.621371;
    }

    public static double mmToInch(double mm) {
        return mm * 0.0393701;
    }
}