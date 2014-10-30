package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	
		@RequestMapping("/")
		public String welcome(Model model)
		{
			model.addAttribute("greeting", "Welcome to Web Store!");   //refers to the <h1> ${greeting} </h1> tag in welcome.jsp
			model.addAttribute("tagline", "The One and Only amazing Web Store"); //refers to the <p> ${tagline} </p> tag in welcome.jsp
			
			//therefore ${greeting} is a kind of variable in the jsp. Valued stroe here will be shown in teh header 1 style
			
			// model = kind of map -  strings into the model
			//whatever value we put into the model can be retrieved from the view (jsp) using the
			//corresponding key with the help of the ${} placeholder expression notation
			
			return "welcome";
		}
		
}


