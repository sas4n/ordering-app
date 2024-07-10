package com.myShoppingApp.inventoryService.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myShoppingApp.inventoryService.service.InventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isItemAvailable(@RequestParam String skuCode, @RequestParam int quantity) {
        return inventoryService.isAvailable(skuCode, quantity);
    }

}
