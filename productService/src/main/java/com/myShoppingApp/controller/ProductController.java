package com.myShoppingApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myShoppingApp.dto.ProductRequest;
import com.myShoppingApp.dto.ProductResponse;
import com.myShoppingApp.model.Product;
import com.myShoppingApp.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.myShoppingApp.service")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @PostMapping("/newProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest ProductRequest) {
        System.out.println("hi");
        return productService.createProduct(ProductRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
