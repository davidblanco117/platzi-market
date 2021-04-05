package com.platzimarket.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>>  getAll(){
		return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
		return productService.getProduct(productId).map(prod -> new ResponseEntity<>(prod,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	

	@GetMapping("/category/{id}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
		return productService.getByCategory(categoryId).map(prods -> new ResponseEntity<>(prods,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int productId) {
		if(productService.delete(productId))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}





}
