package com.meiit.webalk.semtask.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Floor
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer floorNumber;
	@ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
	private Hotel hotel;
	@OneToMany(mappedBy = "floor")
	private List<Wing> wings;
	
	public Floor() 
	{
		super();
	}
	
	public Floor(Integer floorNumber, Hotel hotel, List<Wing> wings)
	{
		super();
		this.floorNumber = floorNumber;
		this.hotel = hotel;
		this.wings = wings;
	}

	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getFloorNumber()
	{
		return floorNumber;
	}
	public void setFloorNumber(Integer floorNumber)
	{
		this.floorNumber = floorNumber;
	}
	public Hotel getHotel()
	{
		return hotel;
	}
	public void setHotel(Hotel hotel)
	{
		this.hotel = hotel;
	}
	public List<Wing> getWings()
	{
		return wings;
	}
	public void setWings(List<Wing> wings)
	{
		this.wings = wings;
	}
}
