package com.example.iocdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.iocdemo.service.CalculatorService;

@Component
public class CalculatorClient {
	
	// We use the interface instead of a class
	// For loosely coupled 
	// Have more flexibility to change from one class to another
	// if needed
	private final CalculatorService calculator;
	
	@Autowired
	public CalculatorClient(CalculatorService calculator) {
		this.calculator = calculator;
	}
	
	public void performCalculations() {
		int a = 10, b = 5;
		System.out.println("Add: "+calculator.add(a, b));
		System.out.println("Substract "+calculator.substract(a, b));
	}

}
