package br.ce.wcaquino.tasks.apitest;

import org.junit.Test;

import io.restassured.RestAssured;

public class APITest {
	@Test
	
	public void deveRetornarTarefa() {
		RestAssured.given()			
		.when()
			.get("http://localhost:8001/tasks-backend/todo")
		.then()
			.statusCode(200)
		;
		
	}
	

}
