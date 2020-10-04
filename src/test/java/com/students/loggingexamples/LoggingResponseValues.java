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

public class LoggingResponseValues extends TestBase{
	
	@DisplayName("Prints out all the response headers")
	@Test
	public void test001() {
		System.out.println("-------------------Printing Response Headers-------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
	}
	
	@DisplayName("Prints out all the response status line")
	@Test
	public void test002() {
		System.out.println("-------------------Printing Response Status Line-------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
	}
	
	@DisplayName("Prints out the response body")
	@Test
	public void test003() {
		System.out.println("-------------------Printing Response Body-------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	@DisplayName("Prints out the response body, if validation fails")
	@Test
	public void test004() {
		System.out.println("--------------Printing Response Body, if validation fails--------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", -1)
		.when()
		.get("/list")
		.then()
		.log()
		.ifError();
	}
	
}
