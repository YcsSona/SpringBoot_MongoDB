package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.collection.Product;
import com.app.respository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addOrUpdateProductDetails(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductDetailsById(int prodId) {
		return productRepository.findById(prodId)
				.orElseThrow(() -> new RuntimeException("Could not find product details by id: " + prodId));
	}

	@Override
	public String deleteProductDetails(int prodId) {
		if (productRepository.existsById(prodId)) {
			productRepository.deleteById(prodId);
			return "Product details with ID: " + prodId + " deleted successfully.";
		}
		return "Could not delete product details by id: " + prodId;
	}

}
