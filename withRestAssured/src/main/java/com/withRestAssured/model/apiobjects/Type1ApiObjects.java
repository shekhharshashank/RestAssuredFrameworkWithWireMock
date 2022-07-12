package com.withRestAssured.model.apiobjects;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.Map;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.relevantcodes.extentreports.LogStatus;
import com.withRestAssured.model.Requests.RequestModel;

import io.restassured.response.Response;

/**
 * @author shashank
 *
 */
public class Type1ApiObjects extends RequestModel {

	private final String BASE_URL="https://api-football-v1.p.rapidapi.com/";
	
	private final String ENDPOINT_GET_TEAMS="v2/teams/league";
	String basePath;

	public Response getTeamsDetails(Map<String,String> headerMap) {
		basePath=BASE_URL+ENDPOINT_GET_TEAMS;
		apiResponse=getRequests(basePath, headerMap);
		test.log(LogStatus.INFO,"Response :-"+ this.apiResponse.prettyPrint());
		return apiResponse;		
	}
	
	
	
	public Response getTeamsDetailsviaWireMock(String endPoint) {

		// Creating a Mock response
		ResponseDefinitionBuilder mcokRes = new ResponseDefinitionBuilder();
		mcokRes.withStatus(200).withBody("Sample Body");
		
		
		createStub(endPoint,mcokRes);
		basePath = BASE_URL_WIREMOCK + endPoint;

		apiResponse = getRequests(basePath);
		test.log(LogStatus.INFO, "Response :-" + this.apiResponse.prettyPrint());
		return apiResponse;
	}
	/**
	 * Using WireMock
	 * 
	 */
	public void createStub(String endPoint,ResponseDefinitionBuilder mcokRes) {
	
		stubFor(get(urlEqualTo(endPoint)).willReturn(
				mcokRes));
		
		/*
		 * stubFor(get(urlEqualTo(endPoint)).willReturn(
		 * aResponse().withStatus(200).withBody("Sample Body").withHeader(
		 * "Content-Type", "application/json")));
		 */

	}
	
	
	
	
}
