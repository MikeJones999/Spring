package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;




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
		
		
		//add all three to the model
		listOfProducts.add(iPhone);
		listOfProducts.add(galaxy);
		listOfProducts.add(tablet_Nexus);
		
	}
	
	
	
	
	
	//implemented method - returns the items listed on this list
	public List<Product> getAllProducts()
	{		
		return listOfProducts;
	}
	
	
	
	
}
