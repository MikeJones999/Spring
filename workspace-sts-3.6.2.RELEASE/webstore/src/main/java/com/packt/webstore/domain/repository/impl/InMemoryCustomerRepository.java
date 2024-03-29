package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository
{
	private List<Customer> listOfCustomers = new ArrayList<Customer>(); 
	
	public InMemoryCustomerRepository()
	{
		Customer cust1 = new Customer(1234, "Mike", 0);
		Customer cust2 = new Customer(1222, "Dave", 10);
		
		listOfCustomers.add(cust1);
		listOfCustomers.add(cust2);
	}
	
	
	
	public List<Customer> getAllCustomers() 
	{
		
		return listOfCustomers;
	}

}
