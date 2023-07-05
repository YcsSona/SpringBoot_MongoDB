package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.collection.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> addProductDetails(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addOrUpdateProductDetails(product), HttpStatus.CREATED);
	}

	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProductDetailsById(@PathVariable int prodId) {
		try {
			return new ResponseEntity<>(productService.getProductDetailsById(prodId), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{prodId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int prodId) {
		return new ResponseEntity<>(productService.deleteProductDetails(prodId), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<?> updateProductDetails(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addOrUpdateProductDetails(product), HttpStatus.OK);
	}
}
