package com.packt.webstore.domain.repository;

import java.util.List;
import com.packt.webstore.domain.Product;

public interface ProductRepository 
{

	/**
	 * returns a list of all products
	 * @return Product
	 */
	List <Product> getAllProducts();
	
	
	/** 
	 * returns product y its ID
	 * @param productID
	 * @return
	 */
	Product getProductById(String productId);
	
	
	/**
	 * Returns Products by Category
	 * Using URI template patterns - can return certain category of product
	 * @param category
	 * @return
	 */
	List<Product> getProductsByCategory(String category);
	
}
