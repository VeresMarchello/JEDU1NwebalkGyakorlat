package hotel.reservation.domain;

import java.util.List;

public class Wing
{
	String description;
	Floor floor;
	List<Room> rooms;
	WingType wingType;
	

	public Wing()
	{
		super();
	}
	
	public Wing(String description, Floor floor, List<Room> rooms, WingType wingType)
	{
		super();
		this.description = description;
		this.floor = floor;
		this.rooms = rooms;
		this.wingType = wingType;
	}
	
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Floor getFloor()
	{
		return floor;
	}
	public void setFloor(Floor floor)
	{
		this.floor = floor;
	}
	public List<Room> getRooms()
	{
		return rooms;
	}
	public void setRooms(List<Room> rooms)
	{
		this.rooms = rooms;
	}
	public WingType getWingType()
	{
		return wingType;
	}
	public void setWingType(WingType wingType)
	{
		this.wingType = wingType;
	}
}
