package com.myShoppingApp.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface IInventoryClient {

    @GetMapping("/api/inventory")
    public boolean isAvalable(@RequestParam String skuCode, @RequestParam int quantity);

}
