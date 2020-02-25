package com.kj.controller;

import java.net.URI;
import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kj.model.RazorOrderPost;

@RestController
public class ThirtyFirstJanOrderController {
	
	
	
	String username="rzp_test_QAywiw5D3ScKCm";
	String password="hIsc08mWV3ul6jklxfVU5RdT";
	
	
	
	private HttpHeaders getHeaders() {
		String credentials="username:password";
		
		String encodeCredentials= new String(Base64.encodeBase64(credentials.getBytes()));
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.add("content-type", "application/x-www-form-urlencoded");
		
		headers.add("Authorization","Basic"+ encodeCredentials);
		
		return headers;
		
	}
	
	
	@PostMapping(value="/postnewOrder")
	public  ResponseEntity<RazorOrderPost> AddOrder( RazorOrderPost ty ) {
	{
		
		HttpHeaders headers= getHeaders();
		
		RestTemplate    restTemplate= new RestTemplate();
		
		String url= "http://razorpay.com/v1/orders";
		
		HttpEntity<RazorOrderPost> requestEntity=new HttpEntity<RazorOrderPost>(headers);
		
		URI uri=restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
		
		 return new ResponseEntity<RazorOrderPost>( HttpStatus.CREATED);
		
	}

}}
