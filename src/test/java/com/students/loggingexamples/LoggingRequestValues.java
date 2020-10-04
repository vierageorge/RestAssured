package com.students.loggingexamples;

import com.studentapp.tests.TestBase;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoggingRequestValues extends TestBase{
	
	@DisplayName("Prints out all the request headers")
	@Test
	public void test001() {
		System.out.println("-------------------Printing Request Headers-------------------");
		given()
		.pathParam("id", 1)
		.log()
		.headers()
		.when()
		.get("/{id}")
		.then()
		.statusCode(200);
	}
	
	@DisplayName("Prints out all the request parameters")
	@Test
	public void test002() {
		System.out.println("-------------------Printing Request Parameters-------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
}
