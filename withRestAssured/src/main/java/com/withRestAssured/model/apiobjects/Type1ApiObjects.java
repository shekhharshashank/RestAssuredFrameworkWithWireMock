package com.withRestAssured.model.apiobjects;

import java.util.Map;

import com.relevantcodes.extentreports.LogStatus;
import com.withRestAssured.model.Requests.RequestModel;

import io.restassured.response.Response;

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
	
	
	
	
}
