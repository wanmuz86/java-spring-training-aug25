package com.example.restsimapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	// A List, ArrayList to store the products added by user
	static List<Product> productList = new ArrayList<>();
	
	// Scanner I/O package -> To retrieve value from the cursor
	static Scanner scanner = new Scanner(System.in);
	
	// to store the ID of each of the product
	static int nextId = 1;
	
	public static void main(String[] args) {
	
		//While the program is running
		while(true) {
			System.out.println("\n--- Product REST Console ---");
			System.out.println("1. Create new product");
			System.out.println("2. Read all products");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Exit");
			System.out.println("Choose an option: ");
			
			// wait for the response
			int choice = scanner.nextInt();
			// clear the buffer/cursor
			scanner.nextLine();
			
			switch(choice) {
			case 1 -> createProduct();
			case 2 -> readProducts();
			case 3 -> updateProduct();
			case 4 -> deleteProduct();
			case 5 -> {
				System.out.println("Exiting");
				return; // stop the program
			}
			// Other than the specified case
			default -> System.out.println("Invalid choice");
			
			}
			
		}

	}

	// whenever void is the return type no return keyword
	
	private static void deleteProduct() {
		
	}


	private static void updateProduct() {
		// TODO Auto-generated method stub
		
	}


	private static void readProducts() {
		if (productList.isEmpty()) {
			System.out.println("No product available at the moment");
		}
		else {
			System.out.println("Product List");
			for (Product p : productList) {
				p.display();
			}
		}
	
	}


	private static void createProduct() {
	System.out.println("Enter product name");
	String name = scanner.nextLine(); // Wait for the response of type String
	
	System.out.println("Enter product price");
	double price = scanner.nextDouble(); // Wait for the response of type double
	
	// create based on the constructor (id, name, price)
	// nexId++ , return 1 then increment the id to 2
	
	Product product = new Product(nextId++,name,price);
	productList.add(product);
	
	System.out.println("Product successfully added");
	
		
	}

}
