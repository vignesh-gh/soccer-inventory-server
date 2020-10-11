package com.soccer_inventory.soccer_inventory.Dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@Component
public class VariantDaoImpl implements VariantDao {
	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	MongoDatabase database = mongoClient.getDatabase("soccer-inventory");
	MongoCollection<Document> variantCollection = database.getCollection("variant");
	MongoCollection<Document> productCollection = database.getCollection("product");
	
	public List<String> getAllColorsByProductId(int id) {
		List<String> list =new ArrayList<String>();
		BasicDBObject andQuery1 = new BasicDBObject();
		List<BasicDBObject> obj1 = new ArrayList<BasicDBObject>();
		obj1.add(new BasicDBObject("product_id", id));
		andQuery1.put("$and",obj1);
		for(Document doc:variantCollection.find(andQuery1)) {
			System.out.println(doc.getString("color"));
			list.add(doc.getString("color"));
		}
		
		return list;
	}

	public List<String> getAllSizesByProductId(int id) {
		
		List<String> list =new ArrayList<String>();
		BasicDBObject andQuery1 = new BasicDBObject();
		List<BasicDBObject> obj1 = new ArrayList<BasicDBObject>();
		obj1.add(new BasicDBObject("product_id", id));
		andQuery1.put("$and",obj1);
		for(Document doc:variantCollection.find(andQuery1)) {
			System.out.println(doc.getString("size"));
			list.add(doc.getString("size"));
		}
		
		return list;
	}

	public int getProductIdByNameandVariant(String name, String brand) {
		
		List<String> list =new ArrayList<String>();
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("name", name));
		obj.add(new BasicDBObject("brand", brand));
		andQuery.put("$and", obj);
		int id=0;
		for(Document doc:productCollection.find(andQuery)) {
			id=doc.getInteger("_id");
		}
		return id;
	}


}
