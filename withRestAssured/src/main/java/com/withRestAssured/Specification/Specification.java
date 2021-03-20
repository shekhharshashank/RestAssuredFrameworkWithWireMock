package com.withRestAssured.Specification;

import com.withRestAssured.model.base.ProjectBaseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification extends ProjectBaseTest {
	
	//Logging of Respones
	public static synchronized ResponseSpecification logResponse() {
		ResponseSpecification responseSpecification;
		ResponseSpecBuilder responseSpecBuilder= new ResponseSpecBuilder();
		responseSpecBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		
		responseSpecification=responseSpecBuilder.build();
		
		return responseSpecification;
	}

	public static synchronized RequestSpecification logRequest() {
		
		RequestSpecification requestSpecification;
		RequestSpecBuilder requestBuilder;
		
		requestBuilder=new RequestSpecBuilder();
		//requestBuilder.addFilter(new AllureRestAssured());
		
		requestSpecification=requestBuilder.build();
		
		return requestSpecification; 

	}


}
