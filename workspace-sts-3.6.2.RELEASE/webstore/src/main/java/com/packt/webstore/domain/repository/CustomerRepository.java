package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Customer;

public interface CustomerRepository
{
	//get all customers
	List<Customer> getAllCustomers();
	
}
