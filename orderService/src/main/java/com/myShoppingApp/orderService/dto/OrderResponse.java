package com.myShoppingApp.orderService.dto;

public record OrderResponse(Long id, String orderRefrence, String skuCode, double price, int quantity) {

}
