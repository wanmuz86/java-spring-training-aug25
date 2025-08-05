package com.example.iocdemo.service;

import org.springframework.stereotype.Service;

// The implementation class of Calculator Service
// Needs to implement all the methods defined in the 
// interface/contract/
@Service
public class SimpleCalculator implements CalculatorService {

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}

	@Override
	public int substract(int a, int b) {
	
		return a-b;
	}

}
