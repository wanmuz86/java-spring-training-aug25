package com.example.iocdemo.service;

import org.springframework.stereotype.Service;

// @Service is the class that will have the Business Logic / Operation
@Service
public class GreetingService {
	
	public String getGreeting(String name) {
		return "Hello, " + name + "!";
	}
	
}
