package com.meiit.webalk.semtask.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Person
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private int id;
    
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    
    private BigDecimal balance;

	@Enumerated(EnumType.STRING)
    private Currency currency;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	
    public Person()
	{
		super();
	}

	public Person(String firstName, String lastName, LocalDate birth, BigDecimal balance,
			Currency currency, User user)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.balance = balance;
		this.currency = currency;
		this.user = user;
	}

    public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getBirth()
	{
		return birth;
	}
	public void setBirth(LocalDate birth)
	{
		this.birth = birth;
	}
	
	public BigDecimal getBalance()
	{
		return balance;
	}
	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}
	
	@Enumerated(EnumType.STRING)
	public Currency getCurrency()
	{
		return currency;
	}
	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
}
