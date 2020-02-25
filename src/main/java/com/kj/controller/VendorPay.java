package com.kj.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Transfer;

@Controller
public class VendorPay {
	
	
	
	@RequestMapping("/pay")
	public String pay() throws RazorpayException {
	
	
	
	 RazorpayClient razorpayClient = new RazorpayClient("rzp_test_51xc4i0MhDappc", "rpX81QBnDX9zhijW6I0WVSpx");
	 
		Map<String, String> headers = new HashMap<String, String>();
		  razorpayClient.addHeaders(headers);
		 
		
		
		
		
				
		JSONObject requestPay = new JSONObject(); 
		 // The amount should be in paise.
		requestPay.put("currency", "INR");
		requestPay.put("amount", 1200000);
		requestPay.put("account","acc_EBSElCISoRzV4T");
				 
		Transfer transfer = razorpayClient.Transfers.create(requestPay);
		
		return "success";
	}

}
