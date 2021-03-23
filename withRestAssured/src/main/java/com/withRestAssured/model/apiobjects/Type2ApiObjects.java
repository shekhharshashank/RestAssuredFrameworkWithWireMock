package com.withRestAssured.model.apiobjects;

import com.relevantcodes.extentreports.LogStatus;
import com.withRestAssured.model.Requests.RequestModel;

import io.restassured.response.Response;

public class Type2ApiObjects extends RequestModel{

	private final String BASE_URL="https://reqres.in";
	private final String CREATE_USERS="/api/users";
	String basePath;
	
	public Response createUsers(Object payload) {
		basePath=BASE_URL+CREATE_USERS;
		apiResponse=postRequests(basePath, payload);
		test.log(LogStatus.INFO,"Response :-"+ this.apiResponse.prettyPrint());
		return apiResponse;
		
	}
	
	
}
