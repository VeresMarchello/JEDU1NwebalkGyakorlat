package hotel.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation
{
	//Private
	BigDecimal amount;
	LocalDateTime from;
	LocalDateTime to;
	boolean active;
	boolean processed;
	Currency currency;
	Room room;
	BookingPerson bookingPerson;
	
	
	public Reservation() 
	{
		super();
	}
	
	public Reservation(BigDecimal amount, LocalDateTime from, LocalDateTime to, boolean active, boolean processed,
			Currency currency, Room room, BookingPerson bookingPerson)
	{
		super();
		this.amount = amount;
		this.from = from;
		this.to = to;
		this.active = active;
		this.processed = processed;
		this.currency = currency;
		this.room = room;
		this.bookingPerson = bookingPerson;
	}

	
	public BigDecimal getAmount()
	{
		return amount;
	}
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	public LocalDateTime getFrom()
	{
		return from;
	}
	public void setFrom(LocalDateTime from)
	{
		this.from = from;
	}
	public LocalDateTime getTo()
	{
		return to;
	}
	public void setTo(LocalDateTime to)
	{
		this.to = to;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	public boolean isProcessed()
	{
		return processed;
	}
	public void setProcessed(boolean processed)
	{
		this.processed = processed;
	}
	public Currency getCurrency()
	{
		return currency;
	}
	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}
	public Room getRoom()
	{
		return room;
	}
	public void setRoom(Room room)
	{
		this.room = room;
	}
	public BookingPerson getBookingPerson()
	{
		return bookingPerson;
	}
	public void setBookingPerson(BookingPerson bookingPerson)
	{
		this.bookingPerson = bookingPerson;
	}
}
