public class Reservation {

    private static int reservationCounter = 1;

    private int number;
    private User user;
    private Bedroom bedroom;
    private String entryDate;
    private String departureDate;

    public Reservation(User user, Bedroom bedroom, String entryDate, String departureDate){
        this.number = reservationCounter++;
        this.user = user;
        this.bedroom = bedroom;
        this.entryDate = entryDate;
        this.departureDate = departureDate;

        bedroom.addReservation(this);
    }

    public User getUser() {
        return user;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public boolean overlayPeriod(String newEntryDate, String newDepartureDate) {
        return (entryDate.compareTo(newEntryDate) < 0 && newEntryDate.compareTo(departureDate) < 0);
    }

    public void cancelReservation() {
        bedroom.releaseRoom();
    }

}
