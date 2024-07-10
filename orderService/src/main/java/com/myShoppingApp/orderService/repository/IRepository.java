package com.myShoppingApp.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myShoppingApp.orderService.model.Order;

public interface IRepository extends JpaRepository<Order, Long> {

}
