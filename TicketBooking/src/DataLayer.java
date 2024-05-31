import java.util.ArrayList;
import java.util.List;

import model.Train;
import model.Booking;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Train> trainList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();

    public static DataLayer getInstance() {
        if (dataLayer == null) {
            dataLayer = new DataLayer();
        }
        return dataLayer;
    }

    public void addTrain(Train train) {
        trainList.add(train);
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void addBooking(Booking newBooking) {
        bookingList.add(newBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }

    public boolean removeByPnr(String pnr) {
        Booking objToRemove = null;
        boolean bookingFound = false;

        for (Booking booking : bookingList) {
            if (booking.getPnr().equals(pnr)) {
                objToRemove = booking;
                bookingFound = true;
            }
        }

        bookingList.remove(objToRemove);
        return bookingFound;
    }
}
