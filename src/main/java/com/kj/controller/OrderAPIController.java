package com.kj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kj.model.Orders;
import com.kj.repository.OrdersRepository;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;



@Controller
public class OrderAPIController {

	
	
	@Autowired
	
	OrdersRepository ordrepo;
	
	
	@RequestMapping("/createOrder")
	public String  createOrder(Model  model) throws RazorpayException, JsonMappingException, JsonProcessingException {
	
	RazorpayClient razorpayClient = new RazorpayClient("rzp_test_SDEHu2hLHKpFXf", "bxsEDORayFxeEHUl1sW4JYZf");
	
	Map<String, String> headers = new HashMap<String, String>();
	razorpayClient.addHeaders(headers);
	
	
	
	JSONObject options = new JSONObject();
	options.put("amount", 99900); // Note: The amount should be in paise.
	options.put("currency", "INR");
	options.put("receipt", "txn_123456");
	options.put("payment_capture", true);
	Order order = razorpayClient.Orders.create(options);
	
	
	
	System.out.println("success");
	
	String orderDetails=order.toString();
	
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
    
	// Output: color -> Black
    
    model.addAttribute("razorpay_order_id", razorpay_order_id);
    
    List<Payment> payments = razorpayClient.Orders.fetchPayments(orderIds);
    
    System.out.println(payments);
    
    
	return  "customrazor";
	
}}

