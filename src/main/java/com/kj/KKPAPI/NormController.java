package com.kj.KKPAPI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



@Controller
public class NormController {
	
	
	
	@RequestMapping("/ordpost")
	public String ordpost()
	
	
	{
		
		return "ordpost";
		
		
	}
	
	
	@GetMapping(value="/successpost,consumes =  application/json")
	public String successpost( ApiEnt apient,Model model)
	
	
	
	{
		
		
		System.out.println("  SUCESS");
		 RestTemplate rest = new RestTemplate();
		    String url = "http://localhost:8080/postOrderEnt";
		    
		  String  page=rest.postForObject(url, apient,String.class);
		  
		  
		  System.out.println("order posted");
 model.addAttribute(url, url);
		    
		return "success";
		
		
	}

}
