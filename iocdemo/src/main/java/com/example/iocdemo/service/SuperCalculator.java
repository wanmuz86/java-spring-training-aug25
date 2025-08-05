package com.example.iocdemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class SuperCalculator implements CalculatorService{

	@Override
	public int add(int a, int b) {
	
		return (a + b ) * 1000;
	}

	@Override
	public int substract(int a, int b) {
		// TODO Auto-generated method stub
		return (a-b) * 1000;
	}

}
