package com.myShoppingApp.inventoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myShoppingApp.inventoryService.model.Inventory;

public interface IInventoryRepository extends JpaRepository<Inventory, Long> {

}
