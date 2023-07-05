package com.app.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.collection.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
