package com.kj.PICKRR;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ConsumeController {
	
	
	@RequestMapping("/view")
	public String view()
	
	{
		return "view";
		
		
	}
	
	
	
	@RequestMapping("/postOrder")
	public String  postOrder(@ModelAttribute("ship")Shipping ship,Model model) throws JsonMappingException, JsonProcessingException
	
	
	{
		
		
		
         String url="http://localhost:8080/postOr";
		
		 RestTemplate  rest= new RestTemplate();
		
		  
		
		String   response= rest.postForObject(url, ship, String.class);
		
		System.out.println(response);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = response;
		JsonNode jsonNode = objectMapper.readTree(json);
		String tracking_id = jsonNode.get("tracking_id").asText();
		String manifest_img_link = jsonNode.get("manifest_img_link").asText();
		//String attempt = jsonNode.get("attempt").asText();
		model.addAttribute("tracking_id", tracking_id);
		model.addAttribute("manifest_img_link", manifest_img_link);
		return "successpage";
		
	}

}
