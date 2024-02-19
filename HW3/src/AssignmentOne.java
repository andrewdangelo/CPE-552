import java.util.Scanner;

public class AssignmentOne {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Get value of n
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Check for invalid input
        if (n <= 0) {
            System.out.println("Error: Please enter a positive integer.");
        } else {
            double sum = 0.0;

            // Calculate the sum of the first n terms of the series. Note, that the series reflects sum of 1/2^n
            for (int i = 1; i <= n; i++) {
                sum += 1.0 / Math.pow(2, i-1);
            }

            // Print out the sum of the series of the first n terms.
            System.out.println("The sum of the first " + n + " terms of the series is: " + sum);
        }

        scanner.close();
    }
}
