package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MyFirstTest {
	
	@DisplayName("Getting all the students from the database")
	@Test
	void getAllStudents() {
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get("http://localhost:8085/student/list");
		response.prettyPrint();
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
	}
}
