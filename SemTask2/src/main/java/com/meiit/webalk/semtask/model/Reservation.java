package com.meiit.webalk.semtask.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "reservation")
public class Reservation
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private BigDecimal amount;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean processed;
	@Enumerated(EnumType.STRING)
	private Currency currency;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	
	public Reservation() 
	{
		super();
	}
	
	public Reservation(BigDecimal amount, LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean active, boolean processed,
			Currency currency, Room room, Person person)
	{
		super();
		this.amount = amount;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.active = active;
		this.processed = processed;
		this.currency = currency;
		this.room = room;
		this.person = person;
	}

	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public BigDecimal getAmount()
	{
		return amount;
	}
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	public LocalDateTime getFromDateTime()
	{
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime)
	{
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime()
	{
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime)
	{
		this.toDateTime = toDateTime;
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
	public Person getBookingPerson()
	{
		return person;
	}
	public void setBookingPerson(Person person)
	{
		this.person = person;
	}
}
