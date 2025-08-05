package com.example.iocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.iocdemo.component.CalculatorClient;
import com.example.iocdemo.component.Greeter;

@SpringBootApplication
public class IocdemoApplication implements CommandLineRunner{

	@Autowired
	private Greeter greeter;
	
	@Autowired
	private CalculatorClient client;
	
	public static void main(String[] args) {
		SpringApplication.run(IocdemoApplication.class, args);
	}

	// WHen the app run -> execute this right away
	@Override
	public void run(String... args) throws Exception {
		
		greeter.greet("Alice");
		
		client.performCalculations();
		}

}
