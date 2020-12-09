package com.meiit.webalk.semtask.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private Integer stars;
	@OneToMany(mappedBy = "hotel")
	private List<Floor> floors;

	
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

	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
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
