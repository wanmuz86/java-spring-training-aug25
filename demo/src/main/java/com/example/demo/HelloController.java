package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// This Annotation tell Spring that in this file there is a URL definition
// For API

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello From Spring Boot";
	}
	
	@GetMapping("/goodbye")
	public String goodbye() {
		return "Goodbye From Spring boot";
	}

}

