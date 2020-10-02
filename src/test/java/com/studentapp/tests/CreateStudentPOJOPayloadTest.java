package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentPOJOPayloadTest extends TestBase {
	@DisplayName("Create a new student by sending payload as an object")
	@Test
	void createNewStudent() {
		
		StudentPojo student = new StudentPojo();
		
		List<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		student.setFirstName("Jhon");
		student.setLastName("Doe");
		student.setEmail("testuser3@test.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
			.when()
			.contentType(ContentType.JSON)
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
	}
}
