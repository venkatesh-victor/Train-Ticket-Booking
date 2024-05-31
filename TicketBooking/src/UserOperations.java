import model.Booking;
import model.Passenger;
import model.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserOperations {
    Scanner sc = new Scanner(System.in);
    public void init() {
        while (true) {
            System.out.println("1. Train details.");
            System.out.println("2. Book ticket.");
            System.out.println("3. View your tickets.");
            System.out.println("4. Get ticket status.");
            System.out.println("5. Cancel ticket");
            System.out.println("6. Logout");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAllTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewAllTickets();
                    break;
                case 4:
                    getTicketStatus();
                    break;
                case 5:
                    cancelTicket();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

        }
    }

    public void showAllTrains() {
        List<Train> allTrains = DataLayer.getInstance().getTrainList();
        for (Train train : allTrains) {
            System.out.println("-----------------------------------------");
            System.out.println(train.toString());
            System.out.println("-----------------------------------------");
        }
    }

    public void bookTicket() {
        System.out.print("Enter departing station: ");
        String from = sc.nextLine();
        System.out.print("Enter destination station: ");
        String to = sc.nextLine();

        List<Train> availableTrain = searchTrains(from, to);

        System.out.println("Here are all the available trains to your destinations: ");
        for (Train train : availableTrain) {
            System.out.println("-----------------------------------------");
            System.out.println(train.toString());
            System.out.println("-----------------------------------------");
        }

        if (!availableTrain.isEmpty()) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter your id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the train number of one of the available trains in the above list: ");
            int trainNumber = sc.nextInt();

            for (Train bookingTrain : availableTrain) {
                if (bookingTrain.getTrainId() == trainNumber) {
                    Passenger passenger = new Passenger(name, age, gender, id);
                    Booking newBooking = new Booking(passenger, from, to, bookingTrain);
                    if(makePayment(newBooking)) {
                        DataLayer.getInstance().addBooking(newBooking);
                        System.out.println("Train ticket booked successfully.");
                        System.out.println("----------------------------------------");
                        System.out.println("Here is your ticket:-");
                        System.out.println(newBooking);
                        System.out.println("----------------------------------------");
                    }
                    break;
                }
            }
        }
    }

    private boolean makePayment(Booking newBooking) {
        int fare = newBooking.getTrain().getFare();
        System.out.print("Do you want to pay Rs." + fare + "? (y/n): ");
        char choice = sc.next().charAt(0);
        sc.nextLine();

        switch (choice) {
            case 'y':
                System.out.println(fare + " paid successfully.");
                return true;
            case 'n':
                System.out.println("Booking aborted.");
                return false;
            default:
                System.out.println("Invalid choice. Booking aborted.");
                break;
        }

        return false;
    }

    private List<Train> searchTrains(String from, String to) {
        List<Train> trainList = DataLayer.getInstance().getTrainList();
        List<Train> filteredTrainList = new ArrayList<>();

        for (Train train : trainList) {
            List<String> stops = train.getStops();
            if (stops.contains(from) && stops.contains(to)) {
                filteredTrainList.add(train);
            }
        }

        return filteredTrainList;
    }

    public void viewAllTickets() {
        System.out.println("Enter you id: ");
        int id = sc.nextInt();
        sc.nextLine();

        List<Booking> allBookings = DataLayer.getInstance().getAllBookings();
        List<Booking> yourBooking = new ArrayList<>();
        for (Booking booking : allBookings) {
            if (booking.getPassenger().getId() == id) {
                yourBooking.add(booking);
            }
        }

        if(yourBooking.isEmpty()) {
            System.out.println("You have not booked any tickets so far.");
            return;
        }

        for (Booking booking : yourBooking) {
            System.out.println("--------------------------------------");
            System.out.println(booking.toString());
            System.out.println("--------------------------------------");
        }
    }

    public void getTicketStatus() {
        System.out.print("Enter you PNR: ");
        String pnr = sc.nextLine();

        List<Booking> allBookings = DataLayer.getInstance().getAllBookings();

        for (Booking booking : allBookings) {
            if (booking.getPnr().equals(pnr)) {
                System.out.println("-----------------------------------");
                System.out.println(booking.toString());
                System.out.println("-----------------------------------");
                return;
            }
        }

        System.out.println("There is not booking with this PNR.");
    }

    public void cancelTicket() {
        System.out.print("Enter you PNR: ");
        String pnr = sc.nextLine();

        if (DataLayer.getInstance().removeByPnr(pnr)) {
            System.out.println("Ticket Canceled successfully.");
        }
    }
}
