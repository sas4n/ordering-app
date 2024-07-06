package com.myShoppingApp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myShoppingApp.dto.ProductRequest;
import com.myShoppingApp.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest ProductRequest){
        productService.createProduct(ProductRequest);
    }
}
