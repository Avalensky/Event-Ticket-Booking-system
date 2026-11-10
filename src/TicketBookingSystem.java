/**
 *
 * @author Ashwin Valensky
 */
import java.util.Scanner;

public class TicketBookingSystem {

    //Declaring constants
    public static final double REGULAR_PRICE = 80.00;
    public static final double STUDENT_DISCOUNT = 0.20;
    public static final double VIP_SURCHARGE = 30.00;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" Ticket Booking");
        System.out.print("Enter ticket type (Regular or VIP): ");
        String type = input.nextLine();

        System.out.print("Are you a student? (yes or no): ");
        String studentResponse = input.nextLine();

        boolean isStudent = studentResponse.equalsIgnoreCase("yes");

        double totalPrice;

        //Using method overloading
        if (isStudent) {
            totalPrice = calculateTicketPrice(type, true);
        } else {
            totalPrice = calculateTicketPrice(type);
        }

        //Display output summary
        System.out.println("\n=== Ticket Summary ===");
        System.out.println("Ticket Type: " + type);
        System.out.println("Student Discount Applied: " + (isStudent ? "Yes" : "No"));
        System.out.printf("Total Amount Payable: R%.2f%n", totalPrice);

        input.close();
    }

    //Method 1 - Non-student ticket price
    public static double calculateTicketPrice(String type) {
        if (type.equalsIgnoreCase("VIP")) {
            return REGULAR_PRICE + VIP_SURCHARGE;
        } else {
            return REGULAR_PRICE;
        }
    }

    //Method 2 - Student ticket price (method overloading)
    public static double calculateTicketPrice(String type, boolean isStudent) {
        double basePrice = calculateTicketPrice(type);

        if (isStudent) {
            double discount = basePrice * STUDENT_DISCOUNT;
            return basePrice - discount;
        } else {
            return basePrice;
        }
    }
}
