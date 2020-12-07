package com.meiit.webalk.semtask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeldPoint
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String robotName;
	private Integer schedule;
	private Integer errorCode;
	private Double tl;
	private Double bl;
	private Double wl;
	
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getRobotName()
	{
		return robotName;
	}
	public void setRobotName(String robotName)
	{
		this.robotName = robotName;
	}
	
	public Integer getSchedule()
	{
		return schedule;
	}
	public void setSchedule(Integer schedule)
	{
		this.schedule = schedule;
	}
	
	public Integer getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(Integer errorCode)
	{
		this.errorCode = errorCode;
	}
	
	public Double getTl()
	{
		return tl;
	}
	public void setTl(Double tl)
	{
		this.tl = tl;
	}
	
	public Double getBl()
	{
		return bl;
	}
	public void setBl(Double bl)
	{
		this.bl = bl;
	}
	
	public Double getWl()
	{
		return wl;
	}
	public void setWl(Double wl)
	{
		this.wl = wl;
	}
	
	@Override
	public String toString()
	{
		return this.getRobotName() + " " + 
			   this.getSchedule() + " " + 
				this.getErrorCode() + " " + 
				this.getTl() + " " +
				this.getBl() + " " +
				this.getWl();
	}	
	
}
