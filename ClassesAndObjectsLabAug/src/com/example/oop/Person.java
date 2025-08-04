package com.example.oop;

// A class is the representation of the real world object [ A person, A human]
// in Object Oriented Programming
// Prototype / Blueprint
// Eg - A hotel, A room, An Attraction, A Facility, A Landmark


// An Object - an instance of the class in Object Oriented Programming
// "Oria Hotel", "Pullman Hotel"

public class Person {
	
	// properties - what describe a class
	
	private String name;
	private int age;
	
	// Constructor - The way to call the class for an object to be created
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	//Encapsulation in OOP means keeping an object's data (properties) private 
	//and restricting direct access to them. 
	//Access is provided through public methods (getters and setters) 
	//to control how the data is read or modified.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public / private  / protected -> Can be called elsewhere or not
	// int / String  / void -> Return type [void -> I retrieve nothing]
	// getAge - > The method name 
	// (arguments) -> Arguments of the method
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void introduce() {
		System.out.println("Hi, I'm "+this.name+ " and I'm "+this.age+" years old");
	}
	


}
