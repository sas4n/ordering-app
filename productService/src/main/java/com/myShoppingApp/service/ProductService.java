package com.myShoppingApp.service;

import org.springframework.stereotype.Service;

import com.myShoppingApp.dto.ProductRequest;
import com.myShoppingApp.model.Product;
import com.myShoppingApp.productService.IProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final IProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                          .name(productRequest.getName())
                          .description(productRequest.getDescription())
                          .price(productRequest.getPrice())
                          .build(); 
        productRepository.save(product); 
        log.info("product {} is saved", product.getId());
    }
    
}
