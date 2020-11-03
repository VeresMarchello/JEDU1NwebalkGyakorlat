package hotel.reservation.domain;

import java.util.List;

public class Floor
{
	private Integer floorNumber;
	private Hotel hotel;
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
