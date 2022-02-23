package com.sb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {

	@GetMapping("/")
	public String home() { 
		return ("<h1>Welcome JDBC</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User JDBC</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin JDBC</h1>";
	}
}
