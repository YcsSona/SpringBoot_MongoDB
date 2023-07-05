package com.app.service;

import java.util.List;

import com.app.collection.Product;

public interface ProductService {

	Product addOrUpdateProductDetails(Product product);

	List<Product> getAllProducts();

	Product getProductDetailsById(int prodId);

	String deleteProductDetails(int prodId);
}
