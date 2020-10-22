package hotel.reservation.service;

import java.util.List;

import hotel.reservation.domain.BookingPerson;
import hotel.reservation.domain.Hotel;
import hotel.reservation.domain.Reservation;

public interface ReservationService
{
	public void saveBookingPerson(BookingPerson bookingPerson);

	public BookingPerson findBookingPerson();

	public List<Hotel> findAllHotels();

	public void saveReservation(Reservation reservation); 

	public List<Reservation> findAllReservations();

	public void checkIn(); 

	public void checkOut(); 
}
