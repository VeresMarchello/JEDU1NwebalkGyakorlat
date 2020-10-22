package hotel.reservation.view;

import java.util.List;

import hotel.reservation.domain.BookingPerson;
import hotel.reservation.domain.Hotel;
import hotel.reservation.domain.Reservation;
import hotel.reservation.domain.Room;

public interface View
{
	public BookingPerson readBookingPerson();

	public void printWelcomeMessage(BookingPerson bookingPerson);

	public void printBalance(BookingPerson bookingPerson);

	public void printRooms(List<Hotel> hotels);

	public Room selectRoom(List<Hotel> hotels);

	public void printReservationSaved(Reservation reservation); 
	
	public void printReservations(List<Reservation> reservations);

	public void printNotEnoughBalance(BookingPerson bookingPerson);

	public void printCheckIn(List<Reservation> reservations); 

	public void printCheckOut(BookingPerson bookingPerson, List<Reservation> reservations); 
}
