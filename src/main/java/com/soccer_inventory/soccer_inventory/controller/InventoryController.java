package com.soccer_inventory.soccer_inventory.controller;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.soccer_inventory.soccer_inventory.model.Product;
import com.soccer_inventory.soccer_inventory.model.Stock;
import com.soccer_inventory.soccer_inventory.model.Variant;
import com.soccer_inventory.soccer_inventory.service.ProductService;
import com.soccer_inventory.soccer_inventory.service.StcokService;
import com.soccer_inventory.soccer_inventory.service.StcokService;
import com.soccer_inventory.soccer_inventory.service.VariantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public VariantService variantService;
	
	@Autowired
	private StcokService stockService;
	
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
		System.out.println(variant);
		Variant res=variantService.addVariant(variant);	
		return new ResponseEntity<Variant>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("inventory/getAllVariants")
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
	
	@GetMapping("inventory/getAllColors/{id}")
	public List<String> getAllColorsByNProductId(@PathVariable int id){
		
		List<String> list= variantService.getAllColorsByProductId(id);
		return list;
	}
	
	@GetMapping("inventory/getAllSizes/{id}")
	public List<String> getAllSizesByProductId(@PathVariable int id){
		
		List<String> list= variantService.getAllSizesByProductId(id);
		return list;
	}
	
	@PostMapping("inventory/addNewStock")
	public ResponseEntity<Stock> addNewStock(@RequestBody Stock stock) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Stocksssss"+stock);
		Stock res=this.stockService.addNewStock(stock);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("inventory/getAllStocks")
	public List<Stock> getAllStocks(){
		
		List<Stock> stocks=stockService.getAllStocks();
		
		return stocks;
	}
	
	@GetMapping("inventory/getStock/{id}")
	public Stock getStockByVariantId(@PathVariable int id) throws JsonParseException, JsonMappingException, IOException {
		
		return stockService.getStockByVariantId(id);
	}
	
	
}
