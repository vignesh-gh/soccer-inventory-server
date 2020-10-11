package com.soccer_inventory.soccer_inventory.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soccer_inventory.soccer_inventory.Dao.ProdcutRepoistory;
import com.soccer_inventory.soccer_inventory.Dao.ProductDao;
import com.soccer_inventory.soccer_inventory.model.Product;
import com.soccer_inventory.soccer_inventory.seq.ProductSeqGen;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductSeqGen seqGenerator;
	
	@Autowired
	public ProdcutRepoistory productRepo;
	
	@Autowired
	public ProductDao productDao;
	
	
	public Product addProduct(Product product) {
		Product response=null;
		String prod=productDao.getProductByNameandBrand(product.name,product.brand);
		if(prod!=null) {
			return response;
		}else {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		    Date date = new Date();  
		    product.setLast_modified_date(formatter.format(date)); 
			product.setId(seqGenerator.getSequence());
			product.setCreated_date(formatter.format(date));
			response=productRepo.save(product);
		}

		return response;
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {

		return productRepo.findById(id).get();
	}

	public Product updateProduct(Product product) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    product.setLast_modified_date(formatter.format(date));  
		return productRepo.save(product);
	}

	public String getProductByProdName(String name) {
		String product=this.productDao.getproductByProdName(name);
		
		return product;
	}



}
