package com.example.iocdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.iocdemo.service.GreetingService;

// Thighly coupled - Not the best practice (using class/implementation)
// Loosely coupled - using Inteface

@Component 
//A generic annotation to indicate a "Spring Java Class  /Bean"
// In real project, this could be RestController
public class Greeter {
	
	// This class depend on GreetingService
	private final GreetingService greetingService;
	
	// Manage the Dependency Injection for me
	// Initialized GreetingService, ensure that everything is intialized there
	@Autowired
	public Greeter(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public void greet(String name) {
		String message = greetingService.getGreeting(name);
		System.out.println(message);
	}
}
