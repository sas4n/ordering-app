package com.myShoppingApp.orderService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import com.myShoppingApp.orderService.stub.InventoryClientStub;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
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
		InventoryClientStub.stubInventoryCall("something3", 10);
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
