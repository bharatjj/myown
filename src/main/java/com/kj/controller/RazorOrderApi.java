package com.kj.controller;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kj.model.Orders;
import com.kj.model.OrdersRazor;
import com.kj.repository.OrdersRepository;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@RestController
public class RazorOrderApi {
	
@Autowired
	
	OrdersRepository ordrepo;

	  String   username=   "rzp_test_SDEHu2hLHKpFXf";
	   
	   String    password=  "bxsEDORayFxeEHUl1sW4JYZf";
	   
	
	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {{
			   
			 
			   
			   
		         String auth = "username" + ":" + "password";
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}
	
	
	
	 @PostMapping(value="/orderpost",produces= "application/json")
	 
	 public  ResponseEntity<Void> post(@RequestBody OrdersRazor orderrazor) throws RazorpayException {
	// request url
		// request url
		 String url = "https://api.razorpay.com/v1/orders";
		 //ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());

		 // create an instance of RestTemplate
		 RestTemplate restTemplate = new RestTemplate();
		 //jsonConverter.setSupportedMediaTypes(ImmutableList.of(new MediaType("*", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("*", "javascript", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));

		 // create headers
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
		 //RazorpayClient razorpayClient = new RazorpayClient("rzp_test_SDEHu2hLHKpFXf", "bxsEDORayFxeEHUl1sW4JYZf");
//			
//			Map<String, String> headerss = new HashMap<String, String>();
//			razorpayClient.addHeaders(headerss);
//			
		 
		 // add basic authentication
		 headers.setBasicAuth("rzp_live_KvG87uujyfmyVH", "lSpPv3iffJsj6eNZR1NU2JOT");
		 
		// Order orderss = razorpayClient.Orders.create(options);
//		 JSONObject jsonObject = new JSONObject();
//		 jsonObject .put("names", names);
		 // build the request
		 HttpEntity<OrdersRazor> request = new HttpEntity<>(orderrazor , headers);

		 // send POST request
		 ResponseEntity<OrdersRazor> response = restTemplate.postForEntity(url, request, OrdersRazor.class);

		 // check response
		 if (response.getStatusCode() == HttpStatus.OK) {
		     System.out.println("Login Successful");
		 } else {
		     System.out.println("Login Failed");
		 }
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
		
		
		
		
		
	 }
		
		
		
		
		
		
		 @SuppressWarnings("unused")
		@PostMapping(value="/orderpost1")
		 public  String postorder(@RequestBody OrdersRazor oooo,ModelMap model) throws RazorpayException, JsonMappingException, JsonProcessingException {
			 
			 
		 RazorpayClient razorpayClient = new RazorpayClient("rzp_live_KvG87uujyfmyVH", "lSpPv3iffJsj6eNZR1NU2JOT");
		 Map<String, String> headers = new HashMap<String, String>();
		 razorpayClient.addHeaders(headers);
		 JSONObject options = new JSONObject();
		 options.put("amount", oooo.getAmount()); // Note: The amount should be in paise.
		 options.put("currency", oooo.getCurrency());
		 options.put("payment_capture", 1);
		 options.put("receipt", oooo.getReceipt());
		
		 Order oooo1 = razorpayClient.Orders.create(options);
		 
		 System.out.println(oooo1);
		 String orderDetails=oooo1.toString();
			
			System.out.println(orderDetails);
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			String json = orderDetails;
			JsonNode jsonNode = objectMapper.readTree(json);
			String razorpay_order_id = jsonNode.get("id").asText();
			String currency = jsonNode.get("currency").asText();
			//String attempt = jsonNode.get("attempt").asText();
			String amountString = jsonNode.get("amount").asText();
		    System.out.println(razorpay_order_id);
		    System.out.println(currency);
		    System.out.println(amountString);
		    
		    
		    int amount=Integer.parseInt(amountString);
		    Orders  op= new Orders();
		    
		    op.setAmount(amount);
		    op.setCurrency(currency);
		    op.setRazorpayOrderId(razorpay_order_id);
		    Orders savedOrder= ordrepo.save(op);
		    
		    String orderIds=savedOrder.getRazorpayOrderId();
		    System.out.println();
		    
		  
		    Order order = razorpayClient.Orders.fetch(razorpay_order_id);
		    List<Payment> payments = razorpayClient.Orders.fetchPayments(razorpay_order_id);
		    System.out.println(payments);
		    
		    model.addAttribute("razorpay_order_id", razorpay_order_id);
		    
		return    		 orderDetails;
		
		  
				 
		

		
		
		
		
		
		
		
		
		
}
	
	
	
	
	
	

}
