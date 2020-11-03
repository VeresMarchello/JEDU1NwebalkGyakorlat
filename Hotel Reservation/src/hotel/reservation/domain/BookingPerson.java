package hotel.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingPerson extends User
{	
	private String name;
	private Integer accountNumber;
	private BigDecimal balance;
	private LocalDate birth;
	private Currency currency;
	private User user;
	
	
	public BookingPerson() 
	{
		super();
	}
	
	public BookingPerson(String name, Integer accountNumber, BigDecimal balance, LocalDate birth, Currency currency,
			User user)
	{
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.birth = birth;
		this.currency = currency;
		this.setUser(user);
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance()
	{
		return balance;
	}
	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}
	public LocalDate getBirth()
	{
		return birth;
	}
	public void setBirth(LocalDate birth)
	{
		this.birth = birth;
	}
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


