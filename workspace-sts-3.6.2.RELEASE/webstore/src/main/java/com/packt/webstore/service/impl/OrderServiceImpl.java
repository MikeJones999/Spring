package com.packt.webstore.service.impl;

import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;


@Service
public class OrderServiceImpl implements OrderService 
{
	@Autowired  //this gets initialised automatically - no need to do new ProductRepository();
	private ProductRepository productRepository;
	
	
	public void processOrder(String productId, int count) 
	{
		Product productById = productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock() < count)
		{
			throw new IllegalArgumentException("Out of Stock. Available Units in Stock:- " + productById.getUnitsInStock());
		}

		//remove the sum of the order from the stock quantity
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

}
