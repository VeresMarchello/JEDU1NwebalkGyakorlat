package hotel.reservation.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hotel.reservation.domain.BookingPerson;
import hotel.reservation.domain.Currency;
import hotel.reservation.domain.Floor;
import hotel.reservation.domain.Hotel;
import hotel.reservation.domain.Reservation;
import hotel.reservation.domain.Room;
import hotel.reservation.domain.User;
import hotel.reservation.domain.Wing;
import hotel.reservation.domain.WingType;

public class ReservationServiceClass implements ReservationService
{

	BookingPerson bookingPerson = new BookingPerson();
	List<Reservation> reservations = new ArrayList<Reservation>();
	
	@Override
	public void saveBookingPerson(BookingPerson bookingPerson)
	{
		this.bookingPerson = bookingPerson;
	}

	@Override
	public BookingPerson findBookingPerson()
	{
		return bookingPerson;
	}

	@Override
	public List<Hotel> findAllHotels()
	{
		List<Room> rooms = new ArrayList<Room>();
		List<Wing> wings = new ArrayList<Wing>();
		List<Floor> floors = new ArrayList<Floor>();
		List<Hotel> hotels = new ArrayList<Hotel>();

		Room r1 = new Room(1, 2, false, BigDecimal.valueOf(500), null);
		Room r2 = new Room(2, 4, false, BigDecimal.valueOf(1500), null);
		Room r3 = new Room(3, 1, false, BigDecimal.valueOf(200), null);
		Room r4 = new Room(4, 2, false, BigDecimal.valueOf(500), null);
		Wing w1 = new Wing("", null, rooms, WingType.NORTH);
		Floor f1 = new Floor(1, null, wings);
		Hotel h1 = new Hotel("Hilton", "0000,Kukutyin Ó utca 4", 4, floors);

		f1.setHotel(h1);
		w1.setFloor(f1);
		r1.setWing(w1);
		r2.setWing(w1);
		r3.setWing(w1);
		r4.setWing(w1);

		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		wings.add(w1);
		floors.add(f1);
		hotels.add(h1);

		return hotels;
	}

	@Override
	public void saveReservation(Reservation reservation)
	{
		reservations.add(reservation);
	}

	@Override
	public List<Reservation> findAllReservations()
	{
		return reservations;
	}

	@Override
	public void checkIn()
	{
		//Implementation?
	}

	@Override
	public void checkOut()
	{
	//Implementation?	
	}

}
