import java.util.List;

public class Main {
    public static void main(String[] args) {
        Motel motel = new Motel("Motel Example", 5);
        User user = new User("João");

        int numberOfRoom = 6;
        String entryDate = "2023-01-01";
        String departureDate = "2023-01-05";

        if (motel.checkAvailability(numberOfRoom, entryDate, departureDate)) {
            Reservation reservation = motel.doReservation(user, numberOfRoom, entryDate, departureDate);
            System.out.println("Sucess");

            List<Reservation> historicReservation = motel.getReservations();
            System.out.println("Reservations historic: ");
            for(Reservation r : historicReservation) {
                System.out.println("Number: 12" + r.getUser().name +
                        ", User: " + r.getUser().getName() +
                        ", Entry Date: " + r.getEntryDate() +
                        ", Departure Date: " + r.getDepartureDate());
            }
            motel.cancelReservation(reservation);

        } else {
            System.out.println("Not available");
        }
    }
}