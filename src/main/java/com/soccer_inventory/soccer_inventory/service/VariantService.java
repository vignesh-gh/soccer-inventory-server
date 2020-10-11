package com.soccer_inventory.soccer_inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.soccer_inventory.soccer_inventory.model.Variant;

public interface VariantService {
	
	Variant addVariant(Variant variant);
	
	List<Variant> getAllVariant();

	Variant getVariantById(int id);
	
	Variant updateVariant(Variant variant);
	
	List<String> getAllColorsByProductId(int id);
	
	List<String> getAllSizesByProductId(int id);
	
	int getProductIdByNameandVariant(String name,String brand);
	
	List<String> getAllColorsByNameandVariant(String name,String brand);
	
	List<String> getAllSizesByNameandVariant(String name,String brand);



}
