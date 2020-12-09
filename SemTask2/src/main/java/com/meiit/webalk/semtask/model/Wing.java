package com.meiit.webalk.semtask.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Wing
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String description;
	@ManyToOne
    @JoinColumn(name="floor_id", nullable=false)
	private Floor floor;
	@OneToMany(mappedBy = "wing")
	private List<Room> rooms;
	@Enumerated(EnumType.STRING)
	private WingType wingType;
	

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
	
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
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
