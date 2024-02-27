import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set the proper date format for input
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        boolean continueConversion = true;

        // Initiate program interaction
        System.out.println("Welcome to the Gregorian Date Conversion Program!");

        while (continueConversion) {
            try {
                // Get user input to get the date.
                System.out.print("Enter a date in the format (YYYY MM DD): ");
                String input = scanner.nextLine();
                LocalDate date = LocalDate.parse(input, formatter);

                // Call custom conversion function to convert date.
                int julianDate = convertToSerialJulianDate(date);

                // Output the converted date.
                System.out.println("Serial Julian Date: " + julianDate);
            } catch (DateTimeParseException e) { // Check for input error
                System.out.println("Invalid date format. Please try again using the format (YYYY MM DD).");
                continue;
            }

            // Allow for another input. If NO then set continueConversion flag to false using equalsIgnoreCase function.
            System.out.print("Enter another date? (Y/N): ");
            String decision = scanner.nextLine();
            continueConversion = decision.equalsIgnoreCase("Y");
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    /**
     * Converts a Gregorian date to a serial Julian date using the source provided.
     * Source: http://www.c-jump.com/bcc/c155c/Homework/a4_Serial_Julian_Date/a4_Serial_Julian_Date.html#H04_0030_getting_started
     *
     * @param date the LocalDate object
     * @return the serial Julian date as an integer
     */
    public static int convertToSerialJulianDate(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int year = date.getYear();

        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;

        int nDate = day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045;
        return nDate;
    }
}