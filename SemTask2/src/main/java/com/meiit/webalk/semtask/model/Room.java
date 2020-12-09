package com.meiit.webalk.semtask.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private Integer number;
	private Integer beds;
	private Boolean balcon;
	private BigDecimal price;
	@ManyToOne
    @JoinColumn(name="wing_id", nullable=false)
	private Wing wing;
	
	
	public Room()
	{
		super();
	}
	
	public Room(Integer number, Integer beds, Boolean balcon, BigDecimal price, Wing wing)
	{
		super();
		this.number = number;
		this.beds = beds;
		this.balcon = balcon;
		this.price = price;
		this.wing = wing;
	}
	
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Integer getNumber()
	{
		return number;
	}
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	public Integer getBeds()
	{
		return beds;
	}
	public void setBeds(Integer beds)
	{
		this.beds = beds;
	}
	public Boolean getBalcon()
	{
		return balcon;
	}
	public void setBalcon(Boolean balcon)
	{
		this.balcon = balcon;
	}
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	public Wing getWing()
	{
		return wing;
	}
	public void setWing(Wing wing)
	{
		this.wing = wing;
	}
}
