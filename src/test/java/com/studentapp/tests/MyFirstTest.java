package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class MyFirstTest {

	@DisplayName("Getting all the students from the database")
	@Test
	void getAllStudents() {

		given()
			.expect()
			.statusCode(201)
			.when()
			.get("http://localhost:8085/student/list");

	}
	
	@DisplayName("Get a CS Student from the database")
	@Test
	void getSingleCSStudent() {
		Response response =
		given()
			.queryParam("programme", "Computer Science")
			.queryParam("limit", 1)
			.when()
			.get("http://localhost:8085/student/list");
		
		response.prettyPrint();
			
	}
}
