package com.example.restsimapp;

public class Product {
	
	private int id;
	private String name;
	private double price;
	
	
	// Constructor without arguments
	
	public Product() {
		super();
	}

	
	// Constructor with arguments
	
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
	// getters and setters
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	// display method
	public void display() {
		System.out.println("ID: "+id+", Name: "+name+", Price: RM "+price);
	}

}
