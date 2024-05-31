import java.util.Scanner;

public class TrainTicketBooking {
    Scanner sc = new Scanner(System.in);
    private static TrainTicketBooking trainTicketBooking;
    private String appName = "Train Ticket Booking System";
    private String version = "0.0.1";

    public static TrainTicketBooking getInstance() {
        if (trainTicketBooking == null) {
            trainTicketBooking = new TrainTicketBooking();
        }
        return trainTicketBooking;
    }

    public void initApp() {
        while (true) {
            System.out.println("1. Admin Login.");
            System.out.println("2. User Login.");
            System.out.println("3. Exit the application.");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new AdminOperations().init();
                    break;
                case 2:
                    new UserOperations().init();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TrainTicketBooking.getInstance().initApp();
    }
}
