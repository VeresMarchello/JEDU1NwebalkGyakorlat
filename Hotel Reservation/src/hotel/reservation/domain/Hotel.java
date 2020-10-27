package hotel.reservation.domain;

import java.util.List;

public class Hotel
{
	//Private
	String name;
	String address;
	Integer stars;
	List<Floor> floors;

	
	public Hotel() 
	{
		super();
	}
	
	
	public Hotel(String name, String address, Integer stars, List<Floor> floors)
	{
		super();
		this.name = name;
		this.address = address;
		this.stars = stars;
		this.floors = floors;
	}


	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public Integer getStars()
	{
		return stars;
	}
	public void setStars(Integer stars)
	{
		this.stars = stars;
	}
	public List<Floor> getFloors()
	{
		return floors;
	}
	public void setFloors(List<Floor> floors)
	{
		this.floors = floors;
	}
}
