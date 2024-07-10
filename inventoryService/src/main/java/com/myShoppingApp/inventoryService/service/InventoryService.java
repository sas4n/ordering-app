package com.myShoppingApp.inventoryService.service;

import org.springframework.stereotype.Service;

import com.myShoppingApp.inventoryService.repository.IInventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final IInventoryRepository iInventoryRepository;

    public boolean isAvailable(String skuCode, int quantity) {
        return iInventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }
}
