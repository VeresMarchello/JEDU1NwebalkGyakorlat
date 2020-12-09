package com.meiit.webalk.semtask.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private int id;
    
	@Column(name = "username")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "active")
    private Boolean active;
    
    @Column(name = "birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    
    private BigDecimal balance;

	@Enumerated(EnumType.STRING)
    private Currency currency;
    
    public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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

	public Boolean getActive()
	{
		return active;
	}
	public void setActive(Boolean active)
	{
		this.active = active;
	}
	
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
	
	public Currency getCurrency()
	{
		return currency;
	}
	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}


	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
