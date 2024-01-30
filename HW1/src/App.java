import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");

        // Get temperature value in celsius as input
        double celsius;
        while (true) {
            try {
                celsius = scanner.nextDouble();
                break;
            } catch (Exception e) {
                //Check for a valid input
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        // F to C conversion formula
        double fahrenheit = (celsius * 9 / 5) + 32;

        // Return the output to the console
        System.out.println(celsius + " Celsius is equal to " + fahrenheit + " Fahrenheit");
    }
}
