package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;


public class MyFirstTest {
	
	@DisplayName("Getting all the students from the database")
	@Test
	void getAllStudents() {
		
		RestAssured.given()
			.when()
			.get("http://localhost:8085/student/list")
			.then()
			.statusCode(200);
		
	}
}
