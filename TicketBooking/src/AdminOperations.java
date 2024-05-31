import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Booking;
import model.Train;
public class AdminOperations {
    Scanner sc = new Scanner(System.in);

    public void init() {
        while (true) {
            System.out.println("1. Add Trains.");
            System.out.println("2. See all the tickets.");
            System.out.println("3. Log out");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    getDetails();
                    break;
                case 2:
                    getAllTickets();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void getDetails() {
        System.out.print("Enter train name: ");
        String trainName = sc.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter arrival time: ");
        String arrTime = sc.nextLine();
        System.out.print("Enter departure time: ");
        String depTime = sc.nextLine();
        System.out.print("Enter number of seats: ");
        int noOfSeats = sc.nextInt();
        System.out.print("Enter the fare: ");
        int fare = sc.nextInt();
        System.out.print("Enter number of stops: ");
        int noOfRoutes = sc.nextInt();
        sc.nextLine();

        List<String> stops = new ArrayList<>();


        for (int i = 0; i < noOfRoutes; i++) {
            System.out.print("Enter stop number " + (i + 1));
            String stop = sc.nextLine();
            stops.add(stop);
        }

        Train train = new Train(trainName, trainNumber, arrTime, depTime, stops, noOfSeats, fare);
        addTrain(train);
        System.out.println("Train successfully added.");
    }

    private void addTrain(Train train) {
        DataLayer.getInstance().addTrain(train);
    }

    public void getAllTickets() {
        List<Booking> allBookings = DataLayer.getInstance().getAllBookings();
        System.out.println("There are " + allBookings.size() + " tickets have been bookes so far.");
        System.out.println("Here are all the bookings :- ");
        for (Booking booking : allBookings) {
            System.out.println("-----------------------------------------");
            System.out.println(booking.toString());
            System.out.println("-----------------------------------------");
        }
    }

}
