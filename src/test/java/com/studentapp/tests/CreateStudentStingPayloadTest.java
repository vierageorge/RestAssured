package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentStingPayloadTest extends TestBase {
	@DisplayName("Create a new student by sending payload as a string")
	@Test
	void createNewStudent() {
		
		String payload = "{\"firstName\":\"Test\",\"lastName\":\"User2\",\"email\":\"testuser2@testmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
			.when()
			.contentType(ContentType.JSON)
			.when()
			.body(payload)
			.post()
			.then()
			.statusCode(201);
	}
}
