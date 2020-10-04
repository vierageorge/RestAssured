package com.students.loggingexamples;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import com.studentapp.tests.TestBase;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@DisplayName("Prints out the request body")
	@Test
	void test003() {
		System.out.println("-------------------Printing Request Body-------------------");
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		// Attributes generated with Faker
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
			.log()
			.body()
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
	}
	
	@DisplayName("Prints out all the details of the request")
	@Test
	void test004() {
		System.out.println("---------------Printing all the Request Details---------------");
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		// Attributes generated with Faker
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
	}
	
	@DisplayName("Prints out the details of the request if it fails")
	@Test
	void test005() {
		System.out.println("------------Printing all the Request Details on Failure------------");
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		// Attributes generated with Faker
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		//student.setEmail(fake.internet().emailAddress());
		student.setEmail("lenita.ondricka@gmail.com");
		
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
			.log()
			.ifValidationFails()
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
	}
	
}
