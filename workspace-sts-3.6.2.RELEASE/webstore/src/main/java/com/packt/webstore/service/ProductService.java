package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Product;



/**
 * This acts as a service layer between the Product repository and the Productcontroller.
 * 
 * Now the ProductController accesses the ProductService - which in turn ProductRepository has a ProductService. 
 * Thus it can now access it through this service layer 
 * @author MikieJ Study
 *
 */
public interface ProductService 
{
	
	List<Product> getAllProducts();
	
	Product getProductById(String productID);	
	
	List<Product> getProductsByCategory(String category);
	
}
