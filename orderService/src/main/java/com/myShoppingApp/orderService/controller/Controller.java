package com.myShoppingApp.orderService.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myShoppingApp.orderService.dto.OrderRequest;
import com.myShoppingApp.orderService.dto.OrderResponse;
import com.myShoppingApp.orderService.service.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class Controller {

    private final Service orderService;

    @PostMapping("/newOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeNewOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeNewOrder(orderRequest);
    }

}
