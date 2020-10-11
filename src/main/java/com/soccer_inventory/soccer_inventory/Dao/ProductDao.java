package com.soccer_inventory.soccer_inventory.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soccer_inventory.soccer_inventory.model.Product;


public interface ProductDao {
	
	String getProductByNameandBrand(String name,String brand);
	
	String  getproductByProdName(String name);
	
	

}
