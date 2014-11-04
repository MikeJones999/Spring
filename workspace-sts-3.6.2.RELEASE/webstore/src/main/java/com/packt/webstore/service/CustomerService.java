package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Customer;
/**
 * This acts as a service layer between the customer repository and the CustomerController.
 * 
 * Now the ProductController accesses the ProductService - which in turn ProductRepository has a ProductService. 
 * Thus it can now access it through this service layer 
 * @author MikieJ Study
 *
 */
public interface CustomerService 
{

	List<Customer> getAllCustomers();
	
}
