package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;


/**
 * Controls the products that will be displayed on the webpage - most likely a connection to the Database for such a thing - however
 * data retrieval is not the duty of the controller because the controller is a presentation layer component.
 * @author mikieJ
 *
 */

//this controller is sought out and identified to match the @requestmapping

@Controller
@RequestMapping("/products") //defines this as the default page for products
//specify request mapping at the controller class level
//so any method used - will follow /products.. e.g /products/all
public class ProductController
{
	
	/**
	 * @Repository annotation on top of the InMemoryProductRepository class, 
	 * allows Spring to know that if any reference of the type productRepository 
	 * has an @Autowired annotation on top of it, then it should assign the 
	 * implementation object InMemoryProductRepository to that reference
	 */
	
	
	
	@Autowired
	//private ProductRepository productRepository;	
	//now interacts with service layer
	private ProductService productService; //automatically creates new productServiceImpl(); which has all the products
	/**
	 * As soon as Spring sees the @Autowired annotation on top of the ProductRepository reference,
	 *  it assigns the object of InMemoryProductRepository to this reference since 
	 *  Spring already created and holds the InMemoryProductRepository object in its object 
	 *  container (the web application context).
	 * 
	 */
	
	
	//this mapping refers to the page Products
	//@RequestMapping ("/products")  //now removed to make this the default method of this controller
	@RequestMapping
	public String list(Model model)
	{
		//add products to the model
		//model.addAttribute("products", productRepository.getAllProducts());
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	//If you specify more than one default mapping method inside a controller, 
	//you will get IllegalStateException with the message Ambiguous	mapping found.	
	
	@RequestMapping("/all")
	public String allProducts(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory)
	{
		//@PathVariable annotation will help us read that variable
		//Spring MVC will read whatever value is present in the category URI template variable 
		//and assign it to the method parameter productCategory
		//we now have the category value in a variable, 
		//and we just pass it to productService to get the list of products in that	category
		//Once we get that list of products, we simply add it to the model and return the
		//same view name that we have used to list all the products
		
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	
}


