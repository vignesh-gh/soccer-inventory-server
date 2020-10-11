package com.soccer_inventory.soccer_inventory.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.soccer_inventory.soccer_inventory.model.Product;

import ch.qos.logback.core.filter.Filter;

@Component
public class ProductDaoImpl implements ProductDao {
	
	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	MongoDatabase database = mongoClient.getDatabase("soccer-inventory");
	MongoCollection<Document> collection = database.getCollection("product");

	public String getProductByNameandBrand(String name, String brand) {
		String product=null;
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("name", name));
		obj.add(new BasicDBObject("brand", brand));
		andQuery.put("$and", obj);
		for(Document doc:collection.find(andQuery)) {
			product=doc.toJson();
		}
		return  product;
	}

	public String getproductByProdName(String name) {
		String product=null;
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("name", name));	
		andQuery.put("$and", obj);
		for(Document doc:collection.find(andQuery)) {
			product=doc.toJson();
		}
		return  product;
	}



}
