import java.util.Scanner;

public class AssignmentTwo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        // Get the value of x
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();
        
        // Get the value of n
        System.out.print("Enter the number of terms (n): ");
        int n = scanner.nextInt();
        
        // Check for invalid input
        if (n <= 0) {
            System.out.println("Error: The number of terms must be a positive integer.");
        } else {
            // Calculate the approximation of e^x using the first n terms of the series
            // Start with the first term of the series (a.k.a, 1)
            double approximation = 1;
            
            // Keep track of the factorial in the denominator 
            double factorial = 1;
            
            for (int i = 1; i < n; i++) {
                // Calculate factorial
                factorial *= i; 
                approximation += Math.pow(x, i) / factorial;
            }
            
            //Output the result
            System.out.println("The approximation of e^" + x + " using " + n + " terms is: " + approximation);
        }
        
        scanner.close();
    }
}
