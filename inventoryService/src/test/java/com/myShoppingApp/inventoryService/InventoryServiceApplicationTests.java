package com.myShoppingApp.inventoryService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
class InventoryServiceApplicationTests {

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
	void isAvaliableShouldReturnCorrectBoleanValuesAndStatusCode() {

		var trueResponse = RestAssured.given()
				.when()
				.get("api/inventory?skuCode=bleach&quantity=10")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertTrue(trueResponse);

		var falseResponse = RestAssured.given()
				.when()
				.get("api/inventory?skuCode=bleach&quantity=100")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertFalse(falseResponse);
	}

}
