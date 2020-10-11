package com.soccer_inventory.soccer_inventory.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soccer_inventory.soccer_inventory.model.Product;
import com.soccer_inventory.soccer_inventory.model.Variant;
import com.soccer_inventory.soccer_inventory.service.ProductService;
import com.soccer_inventory.soccer_inventory.service.VariantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public VariantService variantService;
	
	@PostMapping("inventory/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		Product res=productService.addProduct(product);		
		return new ResponseEntity<Product>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("inventory/getAllProducts")
	public List<Product> getAllProducts() {
		
		return productService.getAllProducts();
		
		
	}
	@PutMapping("inventory/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int id){
		
		
		Product old_product = productService.getProductById(id);
		if(old_product!=null) {
			old_product.setName(product.name);
			old_product.setBrand(product.brand);
			old_product.setGender(product.gender);
			productService.updateProduct(old_product);
		}
		return new ResponseEntity(old_product,HttpStatus.OK);
		
	}
	
	@GetMapping("inventory/getProduct/{id}")
	public Product getProductById(@PathVariable int id){
		System.out.println(id);
		return productService.getProductById(id);
	}
	
	
	
	@GetMapping("inventory/getProduct")
	public String getProductByProdName(@RequestParam String name){
		String product= productService.getProductByProdName(name);
		
		return product;
	}
	
	
	
	
	@PostMapping("inventory/addVariant")
	public ResponseEntity<Variant> addVariant(@RequestBody Variant variant) {
	
		Variant res=variantService.addVariant(variant);	
		return new ResponseEntity<Variant>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("inventory/getVariants")
	public List<Variant> getAllVariants() {
		
		return variantService.getAllVariant();
		
		
	}
	
	@GetMapping("inventory/getVariant/{id}")	
	public Variant getVariantById(@PathVariable int id){
		System.out.println(id);
		return variantService.getVariantById(id);
	}
	
	@PutMapping("inventory/updateVariant/{id}")
	public ResponseEntity<Product> updateVariant(@RequestBody Variant variant,@PathVariable int id){
		
		
		Variant old_variant = variantService.getVariantById(id);
		if(old_variant!=null) {
			old_variant.setColor(variant.color);
			old_variant.setPrice(variant.price);
			old_variant.setSize(variant.size);
			old_variant.setImages(variant.images);
			variantService.updateVariant(old_variant);
		}
		return new ResponseEntity(old_variant,HttpStatus.OK);
		
	}
	
	@GetMapping("inventory/getAllColors")
	public List<String> getAllColorsByNameandBrand(@RequestParam("name") String name,
			@RequestParam("brand") String brand){
		
		List<String> list= variantService.getAllColorsByNameandVariant(name, brand);
		return list;
	}
	
	@GetMapping("inventory/getAllSizes")
	public List<String> getAllSizesByNameandBrand(@RequestParam("name") String name,
			@RequestParam("brand") String brand){
		
		List<String> list= variantService.getAllSizesByNameandVariant(name, brand);
		return list;
	}
	
	
}
