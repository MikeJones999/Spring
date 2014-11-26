package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	/*
	@RequestMapping("/{manufacturer}")
	public String getProductsByManufacturer(Model model, @PathVariable("manufacturer") String productManufacturer)
	//filterProducts
	{
		//@PathVariable annotation will help us read that variable
		//Spring MVC will read whatever value is present in the category URI template variable 
		//and assign it to the method parameter productCategory
		//we now have the category value in a variable, 
		//and we just pass it to productService to get the list of products in that	category
		//Once we get that list of products, we simply add it to the model and return the
		//same view name that we have used to list all the products
		
		model.addAttribute("products", productService.getProductByManufacturer(productManufacturer));
		return "products";
	}
	*/
	
	
	//can search using this 
	//http://localhost:8080/webstore/products/filter/ByCategory;brand=google;brand=dell;category=tablet;category=laptop
	
	//returns all those brands matching...which are of category....
	
	/*
	 * Spring MVC will read all the matrix variables found in the URL after the {ByCriteria}
		URI template and place those matrix variables into the map of the method parameter
		filterParams. The filterParams map will have each matrix variable name as key and
		the corresponding list will contain the multiple values assigned for the matrix variable. The
		pathVar attribute from the @MatrixVariable annotation is used to identify the matrix
		variable segment in the URL; that's why it has the value ByCriteria, which is nothing but
		the URI template value that we used in our request mapping URL.
	 */
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar= "ByCriteria") Map<String, List<String>> filterParams, Model model)
	{
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	/*
	 we annotated the parameter	productId with the @RequestParam("id") annotation (org.springframework.web.bind.annotation.RequestParam),
	 Spring MVC will try to read a GET request parameter
	 with the name id from the URL and assign it to the getProductById method parameter, productId.
	 */
	
	// product singular - not productS - dipslays one product by its productid - whole new page
	//utilises the product.jsp to display the page using the specified id
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model)
	{
		model.addAttribute("product", productService.getProductById(productId));
		return "product";		
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getNewProductForm(Model model)
	{
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	
	/*
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct)
	{
		productService.addProduct(newProduct);		
		
		// instruct Spring to issue a redirect request to the request path, /products, which is the request path
		// for the list method of our ProductController class. So, after submitting the form, we
		// list the products using the list method of ProductController.
		
		return "redirect:/products";
	}
	*/	

	//changed to this with whitelising
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result)
	{
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0)
		{
			throw new RuntimeException("Attempting to bind dissallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		productService.addProduct(productToBeAdded);	
	
		return "redirect:/products";
	}
	
	/**
	 * Whitelisting form fields that are not required
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	
	
	
}


