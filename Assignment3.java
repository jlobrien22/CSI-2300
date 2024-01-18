import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Metric Converter!");

        System.out.println("\nChoose a conversion type:");
        System.out.println("1. Length");
        System.out.println("2. Mass");
        System.out.println("3. Volume");
        System.out.println("4. Temperature");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                convertLength(scanner);
                break;
            case 2:
                convertMass(scanner);
                break;
            case 3:
                convertVolume(scanner);
                break;
            case 4:
                convertTemperature(scanner);
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void convertLength(Scanner scanner) {
        // Implement length conversion logic here
        public static double feetToMeters(double feet) {
            return feet * 0.3048;
        }
    
        public static double inchesToCentimeters(double inches) {
            return inches * 2.54;
        }
    
        public static double yardsToMeters(double yards) {
            return yards * 0.9144;
        }
    
        public static double milesToKilometers(double miles) {
            return miles * 1.60934;
        }
    }


    private static void convertMass(Scanner scanner) {
        // Implement weight conversion logic here
    }

    private static void convertVolume(Scanner scanner) {
        // Implement temperature conversion logic here
    }
    private static void convertTemperature(Scanner scanner) {
        // Implement temperature conversion logic here
        
        fahrenheitToCelsius(double fahrenheit) {
         
        
                return (fahrenheit - 32) * 5 / 9;
            }
        
            public
        
         
        void;
}
    }