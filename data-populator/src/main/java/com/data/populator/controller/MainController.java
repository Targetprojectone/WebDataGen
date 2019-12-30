package com.data.populator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/hello")
	public String welcomeAPI() {

		return "HI Welcome to Spring Data Populator";
		
	}

}
