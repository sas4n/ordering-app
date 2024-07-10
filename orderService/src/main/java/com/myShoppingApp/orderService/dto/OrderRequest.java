package com.myShoppingApp.orderService.dto;

public record OrderRequest(String skuCode, double price, int quantity) {

}
