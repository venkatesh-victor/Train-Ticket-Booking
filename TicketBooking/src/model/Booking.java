package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Booking {
    private Passenger passenger;
    private String departingStation;
    private String destinationStation;
    private Train train;
    private String pnr;

    public Booking(Passenger passenger, String departingStation, String destinationStation, Train train) {
        this.passenger = passenger;
        this.departingStation = departingStation;
        this.destinationStation = destinationStation;
        this.train = train;
        this.pnr = generatePNR();
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getDepartingStation() {
        return departingStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public String getPnr() {
        return pnr;
    }

    public static String generatePNR() {
        final int RANDOM_NUMBER_LENGTH = 5;
        final Random random = new Random();
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        StringBuilder randomNumber = new StringBuilder(RANDOM_NUMBER_LENGTH);
        for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            randomNumber.append(random.nextInt(10));
        }

        return timestamp + randomNumber;
    }

    @Override
    public String toString() {
        return  "From: " + getDepartingStation() + "\n" +
                "To: " + getDestinationStation() + "\n" +
                "PNR: " + getPnr() + "\n" +
                "Train name: " + getTrain().getTrainName() + "\n" +
                "Train number: " + getTrain().getTrainId() + "\n" +
                "Departure Time: " + getTrain().getDepTime() + "\n" +
                "Arrival Time: " + getTrain().getArrTime();
    }
}
