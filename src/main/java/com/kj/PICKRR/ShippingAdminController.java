package com.kj.PICKRR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShippingAdminController {
	
	
	@Autowired
	ShippingAdminRepository  shiprpo;
	
	@RequestMapping("/createPick")
	public String  createShippingInfo()
	{
		
		
		return "pickupInfo";
		
	}
	
	
	@PostMapping("/pickupInfo")
	public String  createShippingInfoPost(@ModelAttribute("shipAdmin")ShippingAdmin shipAdmin,Model model)
	{
		
		shiprpo.save(shipAdmin);
		
		List<ShippingAdmin> all=shiprpo.findAll();
		model.addAttribute("all", all);
		
		return "redirect:/viewPickup";
		
	}
	
	@RequestMapping("/viewPickup")
	public String  viewShippingInfoPost(Model model)
	{
		
		
		List<ShippingAdmin> all=shiprpo.findAll();
		model.addAttribute("all", all);
		
		return "viewPickupInfo";
		
	}
	
	

}
