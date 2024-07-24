package com.myShoppingApp.productService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.12");

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void createProductShouldReturnCorrectValuesAndStatusCode() {
		String requestBody = """
								{
				  "name":"something3",
				  "description":"hey",
				  "price":100.09
				}
								""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("api/product/newProduct")
				.then()
				.statusCode(201)
				.body("name", Matchers.equalTo("something3"));
	}

}
