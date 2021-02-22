package br.ce.wcaquino.tasks.apitest;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8001/tasks-backend";
	}
	
	@Test	
	public void deveRetornarTarefa() {
		RestAssured.given()			
		.when()
			.get("/todo")
		.then()
			.statusCode(200)
		;
		
	}
	
	@Test
	public void deveAdcionarTarefaComSucesso() {
		RestAssured.given()		
			.body("{\"task\": \"Test Via API\", \"dueDate\":\"2021-12-30\"}")
			.contentType(ContentType.JSON)
		.when()
			.post("/todo")
		.then()
			.statusCode(201)
		;
	}
	@Test
	public void naoDeveAdcionarTarefaInvalida() {
		RestAssured.given()		
			.body("{\"task\": \"Test Via API\", \"dueDate\":\"2010-12-30\"}")
			.contentType(ContentType.JSON)
		.when()
			.post("/todo")
		.then()
			.statusCode(400)
			.body("message",CoreMatchers.is("Due date must not be in past"))
		;
	}
	
	
	

}



