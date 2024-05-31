package model;

import java.util.List;

public class Train {
    private String trainName;
    private int trainId;
    private String arrTime;
    private String depTime;
    private List<String> stops;
    private int noOfSeats;
    private int fare;

    public Train(String trainName, int trainId, String arrTime, String depTime,
                 List<String> stops, int noOfSeats, int fare)
    {
        this.trainName = trainName;
        this.trainId = trainId;
        this.arrTime = arrTime;
        this.depTime = depTime;
        this.stops = stops;
        this.noOfSeats = noOfSeats;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return  "Train Name: " + getTrainName() + "\n" +
                "Train number: " + getTrainId() + "\n" +
                "Arrival and Departure: " + getArrTime() + " - " + getDepTime() +
                "Via: " + getStops() + "\n" +
                "Number of seats: " + getNoOfSeats() + "\n" +
                "Fare: " + getFare();
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
