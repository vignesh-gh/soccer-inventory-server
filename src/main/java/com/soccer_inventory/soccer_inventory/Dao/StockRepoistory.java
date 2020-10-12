package com.soccer_inventory.soccer_inventory.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soccer_inventory.soccer_inventory.model.Stock;
@Repository
public interface StockRepoistory extends MongoRepository<Stock, Integer> {

}
