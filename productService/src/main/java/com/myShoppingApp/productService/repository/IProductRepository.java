package com.myShoppingApp.productService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myShoppingApp.productService.model.Product;

public interface IProductRepository extends MongoRepository<Product, String> {

}
