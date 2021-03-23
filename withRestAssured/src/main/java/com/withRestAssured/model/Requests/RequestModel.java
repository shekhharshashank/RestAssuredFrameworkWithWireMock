package com.withRestAssured.model.Requests;

import java.util.Map;

import com.relevantcodes.extentreports.LogStatus;
import com.withRestAssured.Specification.Specification;
import com.withRestAssured.model.base.ProjectBaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;


public class RequestModel extends ProjectBaseTest {
	
	public Response getRequests(String basePath) {

		return RestAssured.given().when().get(basePath);

	}

	public Response postRequests(String basePath, Object payLoad) {
		requestSpecification= RestAssured.given().contentType(ContentType.JSON).spec(Specification.logRequest()).when().body(payLoad);
		request = (RequestSpecificationImpl) this.requestSpecification;
				extentReportAddons(basePath,request);
		return requestSpecification.post(basePath);
	}

	public Response deleteRequests(String basePath) {

		return RestAssured.given().when().get(basePath);

	}

	public Response putRequests(String basePath,Object payload) {

		return RestAssured.given().when().body(payload).put(basePath);

	}

	public Response patchRequests(String basePath,Object payload) {

		return RestAssured.given().when().body(payload).patch(basePath);

	}
	
	public Response getRequests(String basePath,Map<String, String> HeaderValueMap) {

		return RestAssured.given().headers((Map<String, String>) HeaderValueMap).when().get(basePath);
	}
	
	public static void extentReportAddons(String basePath, RequestSpecificationImpl request) {
		test.log(LogStatus.INFO,"Request BasePath :-"+ basePath);
		test.log(LogStatus.INFO,"Request Payload :-"+ request.getBody().toString());
	}

}
