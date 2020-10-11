package com.soccer_inventory.soccer_inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccer_inventory.soccer_inventory.model.Product;



public interface ProductService {
	
   Product addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	Product updateProduct(Product product);
	
	String getProductByProdName(String name);
}
