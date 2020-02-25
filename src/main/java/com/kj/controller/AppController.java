package com.kj.controller;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kj.model.Customer;

@RestController
public class AppController {
	
	
	
	private HttpHeaders getHeaders() {
    	String credential="sean:s@123";
    	//String credential="martin:m@123";
    	String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
     	headers.add("Authorization", "Basic " + encodedCredential);
    	return headers;
    }
	 public void addTopicDemo() {
	    	HttpHeaders headers = getHeaders();  
	        RestTemplate restTemplate = new RestTemplate();
		    String url = "http://localhost:8080/customer/customer";
		    Customer customer = new Customer();
		    customer.setContact("9878677656");
		    customer.setName("kkkdjjdjd");
		    customer.setEmail("kkkdj@gmail.com");
	        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, headers);
	        URI uri = restTemplate.postForLocation(url, requestEntity);
	        System.out.println(uri.getPath());    	
	    }
	 
	 
	 @RequestMapping("/add")
	 
	 public void addCustomer()
	 
	 {
		 addTopicDemo();
	 }

}
