package com.packt.webstore.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;


/**
 * Controls the products that will be displayed on the webpage - most likely a connection to the Database for such a thing - however
 * data retrieval is not the duty of the controller because the controller is a presentation layer component.
 * @author mikieJ
 *
 */

//this controller is sought out and identified to match the @requestmapping

@Controller
public class ProductController
{
	@Autowired
	private ProductRepository productRepository;
	
	
					//this mapping refers to the page Products
	@RequestMapping ("/products")
	public String list(Model model)
	{
		
		model.addAttribute("products", productRepository.getAllProducts());
		
		return "products";
	}
	
	
	
}


