package com.studentapp.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class MyFirstTest {

	@DisplayName("Getting all the students from the database")
	@Test
	void getAllStudents() {

		given()
			.expect()
			.statusCode(200)
			.when()
			.get("http://localhost:8085/student/list");

	}
	
	@DisplayName("Get a CS Student from the database")
	@Test
	void getSingleCSStudent() {
		
		// Set Query Params as a HashMap
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("programme", "Computer Science");
		params.put("limit", 1);
		
		Response response =
		given()
//			.queryParam("programme", "Computer Science")
//			.queryParam("limit", 1)
//			.queryParams("programme", "Computer Science","limit", 1)
			.queryParams(params)
			.when()
			.get("http://localhost:8085/student/list");
		
		response.prettyPrint();
			
	}
	
	@DisplayName("Get the first student")
	@Test
	void getTheFirstStudent() {
		Response response =
		given()
			.pathParam("id", 2)
			.when()
			.get("http://localhost:8085/student/{id}");
		
		response.prettyPrint();
	}
}
