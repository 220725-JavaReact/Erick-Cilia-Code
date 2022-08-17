package com.revature.models;

import java.util.Objects;

public class Customer
{
	private String name;
	private String address;
	private String email;
	
	//add list after
	
	public static int customerCount;
	
	public Customer()
	{
		customerCount++;
	}

	
	
	public Customer(String name, String address, String email)
	{
		super();
		this.name = name;
		this.address = address;
		this.email = email;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}



	@Override
	public String toString()
	{
		return "Customer Name: " + name + "\nCustomer Address " + address + "\nCustomer email: " + email;
	}



	@Override
	public int hashCode()
	{
		return Objects.hash(address, email, name);
	}



	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}
	
	
}
