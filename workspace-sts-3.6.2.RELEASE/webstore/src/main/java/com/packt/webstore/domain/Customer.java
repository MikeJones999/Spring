package com.packt.webstore.domain;

public class Customer 
{
	private int customerId;
	private String name;
	private int noOfOrdersMade;
	
	//constructor
	public Customer(int customerId, String name, int ordersMade)
	{
		this.name = name;
		this.customerId = customerId;
		this.noOfOrdersMade = ordersMade;
	}
	
	//constructor - no orders predefined
	public Customer(int customerId, String name)
	{
		this.name = name;
		this.customerId = customerId;		
	}

	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
	public int getNoOfOrdersMade() 
	{
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(int noOfOrdersMade) 
	{
		this.noOfOrdersMade = noOfOrdersMade;
	}

	@Override
	public String toString() 
	{
		return "Customer [Customer Id=" + customerId + ", name=" + name + "]";
	}
	
	
	
	
}
