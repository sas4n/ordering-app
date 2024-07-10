package com.myShoppingApp.orderService.service;

import java.util.UUID;

import com.myShoppingApp.orderService.dto.OrderRequest;
import com.myShoppingApp.orderService.dto.OrderResponse;
import com.myShoppingApp.orderService.model.Order;
import com.myShoppingApp.orderService.repository.IRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class Service {

    private final IRepository iRepository;

    public OrderResponse placeNewOrder(OrderRequest orderRequest) {
        Order newOrder = Order.builder()
                .orderRefrence(UUID.randomUUID().toString())
                .skuCode(orderRequest.skuCode())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .build();

        iRepository.save(newOrder);

        log.info("order {} is saved", newOrder.getId());
        return new OrderResponse(newOrder.getId(), newOrder.getOrderRefrence(), newOrder.getSkuCode(),
                newOrder.getPrice(), newOrder.getQuantity());
    }
}
