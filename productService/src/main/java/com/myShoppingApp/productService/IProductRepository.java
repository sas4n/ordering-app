package com.myShoppingApp.productService;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myShoppingApp.model.Product;

public interface IProductRepository extends MongoRepository<Product, String>{
    
}
