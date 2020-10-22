package hotel.reservation.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import hotel.reservation.domain.BookingPerson;
import hotel.reservation.domain.Currency;
import hotel.reservation.domain.Floor;
import hotel.reservation.domain.Hotel;
import hotel.reservation.domain.Reservation;
import hotel.reservation.domain.Room;
import hotel.reservation.domain.Wing;
import hotel.reservation.domain.WingType;

public class ViewClass implements View
{
	Scanner scanner = new Scanner(System.in);

	@Override
	public BookingPerson readBookingPerson()
	{
		System.out.println("What's your name?");
		String name = scanner.nextLine();

		System.out.println("How much money do you have (more than 0)?");
		BigDecimal balance = scanner.nextBigDecimal();
		scanner.nextLine();

		System.out.println("What is your currency?(HUF,EUR or USD)");
		Currency currency = Currency.valueOf(scanner.nextLine().toUpperCase());

		BookingPerson bookingPerson = new BookingPerson();
		bookingPerson.setName(name);
		bookingPerson.setBalance(balance);
		bookingPerson.setCurrency(currency);

		return bookingPerson;
	}

	@Override
	public void printWelcomeMessage(BookingPerson bookingPerson)
	{
		System.out.println(String.format("Welcome %s", bookingPerson.getName()));
	}

	@Override
	public void printBalance(BookingPerson bookingPerson)
	{
		DecimalFormat decimalFormat = new DecimalFormat("#,###.##");	
		System.out.println("Your balance is " + decimalFormat.format(bookingPerson.getBalance()) + " "
				+ bookingPerson.getCurrency());
	}

	@Override
	public void printRooms(List<Hotel> hotels)
	{
		if (hotels == null)
		{
			System.out.println("There are no rooms!");
			return;
		}

		int index = 0;

		for (int i = 0; i < hotels.size(); i++)
		{
			String hotelName = hotels.get(i).getName();
			List<Floor> floors = hotels.get(i).getFloors();

			for (int j = 0; j < floors.size(); j++)
			{
				int floorNumber = floors.get(j).getFloorNumber();
				List<Wing> wings = floors.get(j).getWings();

				for (int k = 0; k < wings.size(); k++)
				{
					WingType wingType = wings.get(k).getWingType();
					List<Room> rooms = wings.get(k).getRooms();

					for (int l = 0; l < rooms.size(); l++, index++)
					{
						int roomNumber = rooms.get(l).getNumber();
						int beds = rooms.get(l).getBeds().intValue();
						String price = rooms.get(l).getPrice().toString();
						System.out.println(String.format(
								"%d: Hotel name: %s, Floor: %d, Wing: %s, Room number: %d, Beds: %d, Price: %s ",
								index + 1, hotelName, floorNumber, wingType, roomNumber, beds, price));
					}
				}
			}
		}
	}

	@Override
	public Room selectRoom(List<Hotel> hotels)
	{
		if (hotels == null)
		{
			System.out.println("There are no rooms!");
			return null;
		}

		System.out.println("Where do you want to book?(choose a number or press q for quit)");

		printRooms(hotels);

		String value = scanner.nextLine();

		if (value.equalsIgnoreCase("q"))
		{
			return null;
		}

		int selectedIndex = Integer.parseInt(value) - 1;

		for (int i = 0; i < hotels.size(); i++)
		{
			List<Floor> floors = hotels.get(i).getFloors();

			for (int j = 0; j < floors.size(); j++)
			{
				List<Wing> wings = floors.get(j).getWings();

				for (int k = 0; k < wings.size(); k++)
				{
					List<Room> rooms = wings.get(k).getRooms();

					for (int l = 0; l < rooms.size(); l++)
					{

						if (l != selectedIndex)
						{
							continue;
						}
						else
						{
							return rooms.get(l);
						}
					}
				}
			}
		}

		return null;
	}

	@Override
	public void printReservationSaved(Reservation reservation)
	{
		System.out.println("Reservation successfully saved!");
		
		Room room = reservation.getRoom();
		Number beds = room.getBeds();
		Integer number = room.getNumber();
		
		Wing wing = room.getWing();
		WingType wingType = wing.getWingType();
		
		Floor floor = wing.getFloor();
		Integer floorNumber = floor.getFloorNumber();
		
		Hotel hotel = floor.getHotel();
		String hotelName = hotel.getName();
		
		
		System.out.println(String.format("Reservation details: " + "Hotel name: " + hotelName + ", Floor: " + floorNumber + ", Wing: " + wingType 
				+ ", Room number: " + number + ", Beds: " + beds));
	}

	@Override
	public void printReservations(List<Reservation> reservations)
	{
		System.out.println("Your reservations:");
		
		for (Reservation reservation : reservations)
		{
			Room room = reservation.getRoom();
			Number beds = room.getBeds();
			Integer number = room.getNumber();
			
			Wing wing = room.getWing();
			WingType wingType = wing.getWingType();
			
			Floor floor = wing.getFloor();
			Integer floorNumber = floor.getFloorNumber();
			
			Hotel hotel = floor.getHotel();
			String hotelName = hotel.getName();
			
			System.out.println(String.format("Hotel name: " + hotelName + ", Floor: " + floorNumber + ", Wing: " + wingType 
					+ ", Room number: " + number + ", Beds: " + beds));
		}
		
	}
	
	@Override
	public void printNotEnoughBalance(BookingPerson bookingPerson)
	{
		System.out.println("Sorry you don't have enough balance, please choose another room!");
	}

	@Override
	public void printCheckIn(List<Reservation> reservations)
	{
		System.out.println("Check in");
		System.out.println("Few days later");
	}

	@Override
	public void printCheckOut(BookingPerson bookingPerson, List<Reservation> reservations)
	{
		System.out.println("Check out. You are the 100th guest, you got 10% refund");
		
		BigDecimal refund = reservations.get(0).getAmount().divide(new BigDecimal(10));
		BigDecimal balance = bookingPerson.getBalance();
		bookingPerson.setBalance(balance.add(refund));
		printBalance(bookingPerson);
	}


}
