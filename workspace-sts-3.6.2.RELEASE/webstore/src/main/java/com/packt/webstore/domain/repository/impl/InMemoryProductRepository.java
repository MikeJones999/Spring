package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

/**
 * This class is just a dummy, in-memory product repository.
 *  It does not retrieve any real product domain object information from any database as such;
 *  it just instantiates a list of product domain objects in its constructor
 * @author MikieJ Study
 *
 * behaviour of a ProductRepository interface is to return a list of 
 * product domain objects (getAllProducts), InMemoryProductRepository class 
 * is just an implementation of this interface.
 * 
 * THIS CLASS SHOULD BE REPLACED WITH A CLASS THE RETRIEVES REAL DATA FROM A DATABASE
 * 
 */


@Repository
public class InMemoryProductRepository implements ProductRepository
{

	//create a list of products
	private List<Product> listOfProducts = new ArrayList<Product>();
		
	public InMemoryProductRepository()
	{
	
		
		//product one
		Product iPhone = new Product("P1234", "IPhone 5s", new BigDecimal(500));
		iPhone.setDescription("Apple IPhone 5s SmartPhone with 4.00 inch 640x1136 display and 8-megapixel rear camera");
		iPhone.setCategory("Smart Phone");
		iPhone.setManufacturer("Apple");
		iPhone.setUnitsInStock(1000);
		
		//product two
		Product galaxy = new Product ("P2555", "Samsung Galaxy 5", new BigDecimal(500));
		galaxy.setDescription("Samsung Galaxy 5 with 5.1 FHD Super AMOLED (1920 x 1080) Dispay and 16-megapixel rear camera");
		galaxy.setCategory("Smart Phone");
		galaxy.setManufacturer("Samsung");
		galaxy.setUnitsInStock(500);
		
		//product three
		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		//product four
		Product lapTop_Dell = new Product("P5555","Alienware ", new BigDecimal(650));
		lapTop_Dell.setDescription("Dell i5 4970k processor, 16GB Ram, Nividia 780GTX, 120GB Crucial SSD and 1TB Samsung Spin F3 HD");
		lapTop_Dell.setCategory("Laptop");
		lapTop_Dell.setManufacturer("Dell");
		lapTop_Dell.setUnitsInStock(750);
		
		//add all three to the model
		listOfProducts.add(iPhone);
		listOfProducts.add(galaxy);
		listOfProducts.add(tablet_Nexus);
		listOfProducts.add(lapTop_Dell);
		
	}
	
	
	
	
	
	//implemented method - returns the items listed on this list
	public List<Product> getAllProducts()
	{		
		return listOfProducts;
	}





	public Product getProductById(String productId) 
	{
		Product productById = null;
		
		for(Product product : listOfProducts) 
		{
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId))
			{
				productById = product;
				break;
			}
		}
	
			if(productById == null){
			throw new IllegalArgumentException("No products found with the product id: "+ productId);
		}
		return productById;
	}




	/**
	 * Returns list of products by category
	 * @param String category
	 */
	public List<Product> getProductsByCategory(String category) 
	{
		List<Product> productsByCategory = new ArrayList<Product>();
		
		for(Product product: listOfProducts)
		{
			if(category.equalsIgnoreCase(product.getCategory()))
			   {
				productsByCategory.add(product);
			   }
		}
		return productsByCategory;
	}





	public Set<Product> getProductByFilter(	Map<String, List<String>> filterParams) 
	{
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		
		Set<String> criterias = filterParams.keySet();
		
		//if the keyste of criterias contains brand
		if(criterias.contains("brand"))
		{
			//for each string object returned in brand 
			for (String brandName: filterParams.get("brand"))
			{
				//foreach iobject/product in our list
				for (Product product: listOfProducts)
				{
					
					//if that brandname equals the products manufacturer
					if (brandName.equalsIgnoreCase(product.getManufacturer()))
					{
						
						//add it to out products by brand set - therefore a match
						productsByBrand.add(product);
					}
				}
			}
		}
		
		
		
		if(criterias.contains("category"))
		{
			
			for(String category: filterParams.get("category"))
			{
				productsByCategory.addAll(this.getProductsByCategory(category));
				
			}
			
		}
		
		productsByCategory.retainAll(productsByBrand);
		
		return productsByCategory;
	}




	/**
	 * Returns a list of products by Manufacturer
	 */
	public List<Product> getProductByManufacturer(String manufacturer) 
	{
		List<Product> productByManufacturer = new ArrayList<Product>();
		
		for (Product product: listOfProducts)
		{
			if (manufacturer.equalsIgnoreCase(product.getManufacturer()))
			{
				productByManufacturer.add(product);
			}		
		}			
		return productByManufacturer;
	}





	public void addProduct(Product product) 
	{
		//adds a product to our list of products
	  listOfProducts.add(product);		
	}
	


	
	
}
