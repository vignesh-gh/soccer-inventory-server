package com.soccer_inventory.soccer_inventory.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.soccer_inventory.soccer_inventory.model.Stock;
import com.soccer_inventory.soccer_inventory.service.StcokService;

@Service
public class StockDaoImpl implements StockDao {
	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	MongoDatabase database = mongoClient.getDatabase("soccer-inventory");
	MongoCollection<Document> stockCollection = database.getCollection("stock");
	
	@Autowired
	private StockRepoistory stockRepo;

	public Stock addNewStock(Stock stock) {
		
		return stockRepo.save(stock);		
		
	}

	public List<Stock> getAllStocks() {
	
		return stockRepo.findAll();
	}

	public Stock getStockByVariantId(int id) throws JsonParseException, JsonMappingException, IOException {
		String stockJSON="";
		Stock stock=null;
		BasicDBObject andQuery1 = new BasicDBObject();
		List<BasicDBObject> obj1 = new ArrayList<BasicDBObject>();
		obj1.add(new BasicDBObject("variant_id", id));
		andQuery1.put("$and",obj1);
		for(Document doc:stockCollection.find(andQuery1)) {
			stockJSON=doc.toJson();
		}	
		if(stockJSON !="") {
		    ObjectMapper mapper = new ObjectMapper();
		    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		     stock = mapper.readValue(stockJSON, Stock.class);
		}

		return stock;
	}


}
