package com.kj.controller.normal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kj.model.RazorOrderPost;


@Controller
public class RazorPay {
	
	
	@RequestMapping("/order")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("razorOrderPost", new RazorOrderPost());
		
		return "addOrder";
	}

}
