package com.example.oop;

public class EmployeeDemo {

	public static void main(String[] args) {
		
		// Create me an object person with the following data name=" Alice, age=30
		Person person1 = new Person("Alice",30);
		Person person2 = new Person("Bob", 25);
		
		// Use the getter to retrieve the name
		System.out.println("Person 1 is "+person1.getName());
		System.out.println("Person 2 is "+person2.getName());
		
		// TODO exercise:
		// Add another person : Jane Doe, 35
		// Show the following message
		// Person 3 is Jane Doe and she is 35 years old
		
		Person newEmployee = new Person("Jane Doe",35);
		System.out.println("Person 3 is "+newEmployee.getName()+" and she is "
		+newEmployee.getAge()+" years old");
		
		
		person1.introduce();
		person2.introduce();
		newEmployee.introduce();

	}

}
