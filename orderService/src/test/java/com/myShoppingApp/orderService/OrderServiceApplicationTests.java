package com.myShoppingApp.orderService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer<?> mySQLDBContainer = new MySQLContainer<>("mysql:8.1");

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLDBContainer.start();
	}

	@Test
	void placeNewOrderShouldReturnCorrectValuesAndStatusCode() {
		String requestBody = """
								{
				  "skuCode":"something3",
				  "price":1000.97,
				  "quantity":10
				}
								""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("api/order/newOrder")
				.then()
				.statusCode(201)
				.body("skuCode", Matchers.equalTo("something3"));
	}

}
