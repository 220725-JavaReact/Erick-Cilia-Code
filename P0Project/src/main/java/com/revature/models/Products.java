package com.revature.models;

import java.util.Objects;

public class Products//our products are video games
{
	private String name;
	private double cost;
	private String category;
	
	public static int productCount;
	
	public Products()
	{
		productCount++;
	}

	public Products(String name, double cost, String category)
	{
		super();
		this.name = name;
		this.cost = cost;
		this.category = category;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getCost()
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		return "Game: " + name + "\nCost: $" + cost + "\nGenre: " + category;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(category, cost, name);
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
		Products other = (Products) obj;
		return Objects.equals(category, other.category)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(name, other.name);
	}
	
}
