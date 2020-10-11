package com.soccer_inventory.soccer_inventory.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.soccer_inventory.soccer_inventory.model.Product;


public class ProductRepoImpl implements ProdcutRepoistory {

	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Product> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Product entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll(Iterable<? extends Product> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public <S extends Product> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Product> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	

	


}
