package com.withRestAssured.component.type2;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.withRestAssured.model.apiobjects.Type2ApiObjects;
import com.withRestAssured.model.base.ProjectBaseTest;
import com.withRestAssured.model.utils.HttpUrlConnection;

import io.restassured.response.Response;

public class TestCreateUsers extends ProjectBaseTest {

	
	public Response apiResponse;
	public Type2ApiObjects type2ApiObjects;
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethods() {
		type2ApiObjects= new Type2ApiObjects();
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethods() {
		type2ApiObjects= null;
	}
	
	@Test(enabled=true,groups="type2",testName="Test3",description="Test3",priority=1)
	public void Test3() throws IOException {
	
		HashMap<String, String> hmap= new HashMap<>();
		hmap.put("name", readValuefromPropertiesfile("name"));
		hmap.put("job", readValuefromPropertiesfile("job"));
		//type2ApiObjects= new Type2ApiObjects();
		apiResponse=type2ApiObjects.createUsers(hmap);
		
		printResponse(apiResponse);
		verifyStatusCode(apiResponse, HttpUrlConnection.HTTP_CREATED);
		verifyExpectedNodeValues(apiResponse, "job", readValuefromPropertiesfile("job"));
		
	}
}
