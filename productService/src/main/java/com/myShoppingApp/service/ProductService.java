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

    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("product {} is saved", product.getId());
        return product;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice())).toList();
    }

}
