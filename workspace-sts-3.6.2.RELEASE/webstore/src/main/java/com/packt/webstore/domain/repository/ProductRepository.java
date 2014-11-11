package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	
	
	/**
	 * Returns Set of products filtered 
	 * Duplicates removed
	 */
	Set<Product> getProductByFilter(Map<String, List<String>> filterParams);
}
