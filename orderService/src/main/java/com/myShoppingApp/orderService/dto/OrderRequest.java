package com.myShoppingApp.orderService.dto;

public record OrderRequest(String orderRefrence, String skuCode, double price, int quantity) {

}
