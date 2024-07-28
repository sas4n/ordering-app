package com.myShoppingApp.apiGateway.routes;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.servlet.function.RequestPredicates.path;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.setPath;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return route("product-service")
                .route(path("/api/product/newProduct").or(path("/api/product/all")), http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
        return route("product-service-swagger")
                .route(path("/aggregate/product-service/v3/api-docs"), http("http://localhost:8080"))
                .before(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return route("order-service")
                .route(path("/api/order/newOrder"), http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute() {
        return route("order-service-swagger")
                .route(path("/aggregate/order-service/v3/api-docs"), http("http://localhost:8081"))
                .before(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return route("inventory-service")
                .route(path("/api/inventory"), http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute() {
        return route("inventory-service-swagger")
                .route(path("/aggregate/inventory-service/v3/api-docs"), http("http://localhost:8082"))
                .before(setPath("/api-docs"))
                .build();
    }
}
