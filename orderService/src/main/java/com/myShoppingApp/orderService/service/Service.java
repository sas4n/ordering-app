package com.myShoppingApp.orderService.service;

import java.util.UUID;

import com.myShoppingApp.orderService.dto.OrderRequest;
import com.myShoppingApp.orderService.model.Order;
import com.myShoppingApp.orderService.repository.IRepository;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final IRepository iRepository;

    public void placeNewOrder(OrderRequest orderRequest) {
        Order newOrder = Order.builder()
                .orderRefrence(UUID.randomUUID().toString())
                .skuCode(orderRequest.skuCode())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .build();

        iRepository.save(newOrder);
    }
}
