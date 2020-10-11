package com.soccer_inventory.soccer_inventory.Dao;

import java.util.List;

public interface VariantDao {
	
	List<String> getAllColorsByProductId(int id);
	
	List<String> getAllSizesByProductId(int id);
	
	int getProductIdByNameandVariant(String name,String brand);


}
