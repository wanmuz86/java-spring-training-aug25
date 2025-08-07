package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	
	// Create
	// Add a parameter categoryId so that I can retrieve the category
	public Product createProduct(Product product, Long categoryId) {
		
		// When I create a new product, I will get the category from categoryId
		// and set it to the product
		product.setCategory(categoryService.get(categoryId));
		
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
