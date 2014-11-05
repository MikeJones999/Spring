package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

//need this so it can work out the service layer
@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired  //this gets initialised automatically - no need to do new ProductRepository();
	private ProductRepository productRepository;  //automatically creates new InMemoryProductRepository(); 
	//this then creates new InMemoryProductRepository();
	
	public List<Product> getAllProducts()
	{
		List<Product> pros = productRepository.getAllProducts();
		
		return pros;
	}

	public Product getProductById(String productID) 
	{
		//return the product with correct ID
		return productRepository.getProductById(productID);
	}

	public List<Product> getProductsByCategory(String category) 
	{
		//goes to the productRepository to the product by category
		return productRepository.getProductsByCategory(category);
	}

}
