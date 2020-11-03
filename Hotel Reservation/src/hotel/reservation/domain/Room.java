package hotel.reservation.domain;

import java.math.BigDecimal;

public class Room
{
	private Integer number;
	private Number beds;
	private Boolean balcon;
	private BigDecimal price;
	private Wing wing;
	
	
	public Room()
	{
		super();
	}
	
	public Room(Integer number, Number beds, Boolean balcon, BigDecimal price, Wing wing)
	{
		super();
		this.number = number;
		this.beds = beds;
		this.balcon = balcon;
		this.price = price;
		this.wing = wing;
	}
	
	
	public Integer getNumber()
	{
		return number;
	}
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	public Number getBeds()
	{
		return beds;
	}
	public void setBeds(Number beds)
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
