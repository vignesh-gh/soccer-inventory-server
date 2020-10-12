package com.soccer_inventory.soccer_inventory.Dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.soccer_inventory.soccer_inventory.model.Stock;

public interface StockDao {
	
	Stock addNewStock(Stock stock);
	
	List<Stock> getAllStocks();
	
	Stock getStockByVariantId(int id) throws JsonParseException, JsonMappingException, IOException;
	
}
