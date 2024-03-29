package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired  //this gets initialised automatically - no need to do new ProductRepository();
	private CustomerRepository customerRepository;  //automatically creates new InMemoryCustomerRepository(); 	
	
	
	public List<Customer> getAllCustomers()
	{
		
		return customerRepository.getAllCustomers();
	}

}
