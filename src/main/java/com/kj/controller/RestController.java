package com.kj.controller;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kj.CustomerDao;
import com.kj.model.Customer;
import com.kj.model.Customers;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@org.springframework.web.bind.annotation.RestController

public class RestController {
	
	
	@Value("${operations.restURL}")
	 String serviceURL;
	 
	
	
	
	 
	 
	
	
	@Autowired
	private CustomerDao customerService;
	
	
	
	@PostMapping("/customer")
	public ResponseEntity<String> addTopic(@RequestBody Customer customer, UriComponentsBuilder builder) {
		 //boolean flag=false;
	
        Customer addCustomer = customerService.addCustomer(customer);
       
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	 //Consuming a service by GET method
	 @GetMapping("/availableOperations")
	 public String getAvailableOperations() throws RazorpayException {
	 
		 RazorpayClient razorpayClient = new RazorpayClient("rzp_test_SDEHu2hLHKpFXf", "bxsEDORayFxeEHUl1sW4JYZf");
			
			Map<String, String> headers = new HashMap<String, String>();
			razorpayClient.addHeaders(headers);
			
			 RestTemplate restTemplate=new RestTemplate();
		 
		 return restTemplate.getForObject(serviceURL, String.class);
	 }
	
	 @GetMapping("/availableOperationsll")
	 public String getAvailableOperationsh() throws RazorpayException {
	// request url
		 String url = "https://api.razorpay.com/v1/customers";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();

		// add basic authentication header
		headers.setBasicAuth("rzp_test_SDEHu2hLHKpFXf", "bxsEDORayFxeEHUl1sW4JYZf");

		// build the request
		HttpEntity request = new HttpEntity(headers);

		// make an HTTP GET request with headers
		ResponseEntity<String> response = restTemplate.exchange(
		        url,
		        HttpMethod.GET,
		        request,
		        String.class
		);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
		    System.out.println("Request Successful.");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}
		return response.getBody();
}
	 
	 
	 @PostMapping("/availableOperationsllpost")
	 public  HttpEntity<Customers> posr(@RequestBody Customers customer) throws RazorpayException {
	// request url
		// request url
		 String url = "https://api.razorpay.com/v1/customers";

		 // create an instance of RestTemplate
		 RestTemplate restTemplate = new RestTemplate();

		 // create headers
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		 // add basic authentication
		 headers.setBasicAuth("rzp_test_SDEHu2hLHKpFXf", "bxsEDORayFxeEHUl1sW4JYZf");

		 // build the request
		 HttpEntity<Customers> request = new HttpEntity(customer,headers);

		 // send POST request
		 ResponseEntity<Customers> response = restTemplate.postForEntity(url, request, Customers.class);

		 // check response
		 if (response.getStatusCode() == HttpStatus.OK) {
		     System.out.println("Login Successful");
		 } else {
		     System.out.println("Login Failed");
		 }
		return request;
}
}
