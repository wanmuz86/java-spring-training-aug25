package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	// Create
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	
	// Read
	
	public List<Product> getAllProducts(){
	
		return productRepository.findAll();
	}
	
	
	//Read by Id
	
	
	//Update
	
	
	
	// Delete

}
