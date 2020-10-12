package com.soccer_inventory.soccer_inventory.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.soccer_inventory.soccer_inventory.model.Stock;

public interface StcokService {
	
	Stock addNewStock(Stock stock) throws JsonParseException, JsonMappingException, IOException;
	
	List<Stock> getAllStocks();
	
	Stock getStockByVariantId(int id) throws JsonParseException, JsonMappingException, IOException;
	
}
