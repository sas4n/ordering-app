package com.myShoppingApp.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.myShoppingApp.dto.ProductRequest;
import com.myShoppingApp.dto.ProductResponse;
import com.myShoppingApp.model.Product;
import com.myShoppingApp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@ComponentScan(basePackages = "com.myShoppingApp.repository")
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
    
    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> ProductResponse.builder()
                                        .id(product.getId())
                                        .name(product.getName())
                                        .description(product.getDescription())
                                        .price(product.getPrice())
                                        .build()).toList();   
    }
    
}
