package hotel.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import hotel.reservation.domain.BookingPerson;
import hotel.reservation.domain.Currency;
import hotel.reservation.domain.Hotel;
import hotel.reservation.domain.Reservation;
import hotel.reservation.domain.Room;
import hotel.reservation.service.ReservationService;
import hotel.reservation.service.ReservationServiceClass;
import hotel.reservation.view.View;
import hotel.reservation.view.ViewClass;

public class App
{

	static ViewClass viewClass = new ViewClass();
	static ReservationServiceClass reservationClass = new ReservationServiceClass();
	
	public static void main(String[] args)
	{
		createBookingPerson();
		book();
		checkIn();
		checkOut();
	}

	public static void createBookingPerson()
	{
		BookingPerson bookingPerson = viewClass.readBookingPerson();
		
		reservationClass.saveBookingPerson(bookingPerson);
		viewClass.printWelcomeMessage(bookingPerson);
		viewClass.printBalance(bookingPerson);
	}

	public static void book()
	{
		List<Hotel> hotels = reservationClass.findAllHotels();
		Room selectedRoom = viewClass.selectRoom(hotels);
		BookingPerson bookingPerson = reservationClass.findBookingPerson();

		do
		{
			BigDecimal amount = selectedRoom.getPrice();
			LocalDateTime from = LocalDateTime.now();
			LocalDateTime to = from.plusDays(5);

			Currency currency = bookingPerson.getCurrency();

			BigDecimal balance = bookingPerson.getBalance();
			BigDecimal price = selectedRoom.getPrice();

			if (balance.compareTo(price) >= 0)
			{
				Reservation reservation = new Reservation(amount, from, to, true, true, currency, selectedRoom,
						bookingPerson);
				reservationClass.saveReservation(reservation);
				viewClass.printReservationSaved(reservation);

				BigDecimal newBalance = bookingPerson.getBalance().subtract(selectedRoom.getPrice());
				bookingPerson.setBalance(newBalance);
			}
			else
			{
				viewClass.printNotEnoughBalance(bookingPerson);
			}
			viewClass.printBalance(bookingPerson);
			System.out.println();
			
			selectedRoom = viewClass.selectRoom(hotels);
		}
		while (selectedRoom != null);
		
		viewClass.printReservations(reservationClass.findAllReservations());
		
	}

	public static void checkIn()
	{
		List<Reservation> reservations = reservationClass.findAllReservations();
		viewClass.printCheckIn(reservations);
	}

	public static void checkOut()
	{
		viewClass.printCheckOut(reservationClass.findBookingPerson(), reservationClass.findAllReservations());
	}
}
