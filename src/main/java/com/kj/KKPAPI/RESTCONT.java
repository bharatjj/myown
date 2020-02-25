package com.kj.KKPAPI;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kj.model.Customers;

@RestController
public class RESTCONT {
	
	
	
	
	@PostMapping(value="/postOrderEnt", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String  postod(ApiEnt  apient)
	
	{
		
		
		
		String url = "http://pickrr.com/api/place-order/";

		 // create an instance of RestTemplate
		 RestTemplate restTemplate = new RestTemplate();

		 // create headers
		
		 // add basic authentication
		
		 // build the request
		

		 // send POST request
		 ResponseEntity<ApiEnt> response = restTemplate.postForEntity(url,apient, ApiEnt.class);

		 // check response
		 if (response.getStatusCode() == HttpStatus.OK) {
		     System.out.println("Login Successful");
		 } else {
		     System.out.println("Login Failed");
		 }
		return apient.toString();
		
		
		
		
	}
	}
	
	
	


