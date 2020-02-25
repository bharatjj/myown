package com.kj.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kj.model.OrdersRazor;
import com.kj.model.RazorOrderPost;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class OrderRazorPayPost {
	
	 @PostMapping(path= "/postOrder", produces = "application/json")
	    public ResponseEntity<Object> addEmployee(
	                       
	                        @RequestBody RazorOrderPost ropost) throws RazorpayException 
	               
	    {       
	        
		 
		 RazorpayClient razorpayClient = new RazorpayClient("rzp_test_QAywiw5D3ScKCm", "hIsc08mWV3ul6jklxfVU5RdT");
		 Map<String, String> headers = new HashMap<String, String>();
		 razorpayClient.addHeaders(headers);
		 //RazorOrderPost ropost=new RazorOrderPost();
		 JSONObject options = new JSONObject();
		 options.put("amount", ropost.getAmount()); // Note: The amount should be in paise.
		 options.put("currency", ropost.getCurrency());
		 options.put("payment_capture", true);
		 options.put("receipt", ropost.getReceipt());
		
		 Order oooo1 = razorpayClient.Orders.create(options);
		
		 String orderDetails=oooo1.toString();
	        //Send location in response
		 return new ResponseEntity<Object>(orderDetails,HttpStatus.OK);
		 
		 
		 
	    }
	 
	 
	 @PostMapping("/availability")
	 public String getURLAvailability(@RequestBody RazorOrderPost  po) {
		 
		 RestTemplate restTemplate= new RestTemplate();
		 restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("rzp_live_KvG87uujyfmyVH", "lSpPv3iffJsj6eNZR1NU2JOT"));
	 return restTemplate.postForObject("https://api.razorpay.com/v1/orders", po, String.class);
	 }
		

}
