package com.myShoppingApp.orderService.openAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI orderServicOpenAPI() {
        return new OpenAPI().info(new Info().title("Order Service Open API")
                .description("The order service of shopping app")
                .version("1.0.0")
                .license(new License().name("M.I.T")));
    }
}
