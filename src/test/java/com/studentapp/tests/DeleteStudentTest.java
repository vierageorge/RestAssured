package com.studentapp.tests;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

public class DeleteStudentTest extends TestBase {
	
	@DisplayName("Delete a student from the database.")
	@Test
	void deleteStudent() {
		given()
			.when()
			.contentType(ContentType.JSON)
			.when()
			.delete("/101")
			.then()
			.statusCode(204);
	}
	

}
