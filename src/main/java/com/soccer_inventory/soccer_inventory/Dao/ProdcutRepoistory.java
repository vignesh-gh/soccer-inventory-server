package com.soccer_inventory.soccer_inventory.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soccer_inventory.soccer_inventory.model.Product;

@Repository
public interface ProdcutRepoistory extends MongoRepository<Product, Integer>{
	
}
