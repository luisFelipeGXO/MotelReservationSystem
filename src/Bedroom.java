import java.util.ArrayList;
import java.util.List;

public class Bedroom {

    private int number;
    private boolean occupied;
    private List<Reservation> reservations;

    public Bedroom(int number) {
        this.number = number;
        this.occupied = false;
        this.reservations = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDisponibleToReservation(String entryDate, String departureDate) {
        if (!occupied) {
            for (Reservation reservation : reservations ) {
                if (reservation.overlayPeriod(entryDate, departureDate)) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        occupied = true;
    }

    public void releaseRoom() {
        occupied = false;
        reservations.clear();
    }
}
