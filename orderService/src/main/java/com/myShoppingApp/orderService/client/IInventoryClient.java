package com.myShoppingApp.orderService.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public interface IInventoryClient {

    Logger logger = LoggerFactory.getLogger(IInventoryClient.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    public boolean isAvalable(@RequestParam String skuCode, @RequestParam int quantity);

    default boolean fallbackMethod(String skuCode, Throwable throwable) {
        logger.info("The error {} happend for the product with skucode {}", throwable.getMessage(), skuCode);
        return false;
    }

}
