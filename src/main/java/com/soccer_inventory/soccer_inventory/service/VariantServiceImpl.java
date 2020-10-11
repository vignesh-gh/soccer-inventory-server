package com.soccer_inventory.soccer_inventory.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccer_inventory.soccer_inventory.Dao.VariantDao;
import com.soccer_inventory.soccer_inventory.Dao.VariantRepoistory;
import com.soccer_inventory.soccer_inventory.model.Product;
import com.soccer_inventory.soccer_inventory.model.Variant;
import com.soccer_inventory.soccer_inventory.seq.VariantSeqGenerator;
@Service
public class VariantServiceImpl implements VariantService {
	
	@Autowired
	public VariantRepoistory variantRepo;
	
	@Autowired
	public VariantDao variantDao;
	
	@Autowired
	public VariantSeqGenerator seqGenerator;

	public Variant addVariant(Variant variant) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
		variant.setId(seqGenerator.getSequence());
		variant.setCreated_Date(formatter.format(date));
		variant.setLast_Modified_Date(formatter.format(date));
		Variant res=variantRepo.save(variant);
		return res;
	}

	public List<Variant> getAllVariant() {
		
		return variantRepo.findAll();
	}
	
	public Variant getVariantById(int id){
		return variantRepo.findById(id).get();
	}
	
	public Variant updateVariant(Variant variant) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    variant.setLast_Modified_Date(formatter.format(date));  
		return variantRepo.save(variant);
	}

	public List<String> getAllColorsByProductId(int id) {
		List<String> colors=variantDao.getAllColorsByProductId(id);
		return colors;
	}

	public List<String> getAllSizesByProductId(int id) {		
		List<String> sizes=variantDao.getAllSizesByProductId(id);
		return sizes;
	}

	public int getProductIdByNameandVariant(String name, String brand) {
		int productId=variantDao.getProductIdByNameandVariant(name, brand);
		return productId;
	}

	public List<String> getAllColorsByNameandVariant(String name, String brand) {
		int id=getProductIdByNameandVariant(name, brand);
		List<String> color=getAllColorsByProductId(id);
		return color;
	}

	public List<String> getAllSizesByNameandVariant(String name, String brand) {
		int id=getProductIdByNameandVariant(name, brand);
		List<String> sizes=getAllSizesByProductId(id);
		return sizes;
	}




}
