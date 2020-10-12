package com.soccer_inventory.soccer_inventory.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccer_inventory.soccer_inventory.Dao.StockDao;
import com.soccer_inventory.soccer_inventory.model.Stock;
import com.soccer_inventory.soccer_inventory.seq.StockSeqGenerator;
@Service
public class StockServiceImpl implements StcokService{

	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockSeqGenerator seqGen;
	
	public Stock addNewStock(Stock stock) throws JsonParseException, JsonMappingException, IOException {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    Stock stock1=null;
		Stock old_stock=stockDao.getStockByVariantId(stock.getVariant_id());
		if(old_stock!=null) {
			int old_units=Integer.parseInt(old_stock.getUnits());
			old_stock.setUnits((Integer.parseInt(stock.getUnits())+old_units)+"");
			old_stock.setLast_modified_Date(formatter.format(date));
			stock1=stockDao.addNewStock(old_stock);
		}else {
			stock.setId(seqGen.getSequence());
		    stock.setCreated_Date(formatter.format(date));
		    stock.setLast_modified_Date(formatter.format(date));
		    stock1=stockDao.addNewStock(stock);
		}
   
		return stock1;
	}

	public List<Stock> getAllStocks() {
		List<Stock> stocks= stockDao.getAllStocks();
		return stocks;
	}

	public Stock getStockByVariantId(int id) throws JsonParseException, JsonMappingException, IOException {
		
		return stockDao.getStockByVariantId(id);
		
	}





}
