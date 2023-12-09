import java.util.ArrayList;
import java.util.List;

public class Motel {

    private String name;
    private List<Bedroom> bedrooms;
    private List<Reservation> reservations;

    public Motel(String name, int numberOfRooms) {
        this.name = name;
        this.bedrooms = new ArrayList<>();
        this.reservations = new ArrayList<>();

        for(int i=1;i<= numberOfRooms; i++) {
            bedrooms.add(new Bedroom(i));
        }
    }

    public String getName() {
        return name;
    }

    public List<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public boolean checkAvailability(int numberOfRoom, String entryDate, String depatureDate) {
        Bedroom bedroom = getBedroom(numberOfRoom);
        return bedroom != null && bedroom.isDisponibleToReservation(entryDate, depatureDate);
    }

    public Reservation doReservation(User user, int numberOfRoom, String entryDate, String depatureDate) {
        if (checkAvailability(numberOfRoom, entryDate, depatureDate)) {
            Bedroom bedroom = getBedroom(numberOfRoom);
            Reservation reservation = new Reservation(user, bedroom, entryDate, depatureDate);
            reservations.add(reservation);
            return reservation;
        } else {
            System.out.println("Room is not disponible for the period mencioned.");
            return null;
        }
    }

    public void cancelReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            reservation.cancelReservation();
            System.out.println("Reservation canceled with sucess.");
        } else {
            System.out.println("Can't cancel reservation.");
        }
    }

    private Bedroom getBedroom(int numberOfRoom) {
        for (Bedroom bedroom : bedrooms) {
            if (bedroom.getNumber() == numberOfRoom) {
                return bedroom;
            }
        }
        return null;
    }
}
