package com.myShoppingApp.productService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myShoppingApp.productService.dto.ProductRequest;
import com.myShoppingApp.productService.dto.ProductResponse;
import com.myShoppingApp.productService.model.Product;
import com.myShoppingApp.productService.repository.IProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final IProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("product {} is saved", product.getId());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice())).toList();
    }

}
