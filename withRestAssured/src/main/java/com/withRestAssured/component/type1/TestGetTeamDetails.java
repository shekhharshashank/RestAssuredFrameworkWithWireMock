package com.withRestAssured.component.type1;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.withRestAssured.model.apiobjects.Type1ApiObjects;
import com.withRestAssured.model.base.ProjectBaseTest;
import com.withRestAssured.model.utils.HttpUrlConnection;

import io.restassured.response.Response;

public class TestGetTeamDetails extends ProjectBaseTest {

	public Response apiResponse;
	public Type1ApiObjects type1ApiObjects;
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethods() {
		type1ApiObjects= new Type1ApiObjects();
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethods() {
		type1ApiObjects= null;
	}
	
	@Test(enabled=true,groups="type1",testName="Test1",description="Test1",priority=1)
	public void Test1() throws IOException {
	
		HashMap<String, String> hmap= new HashMap<>();
		hmap.put("x-rapidapi-key", readValuefromPropertiesfile("x-rapidapi-key"));
		hmap.put("x-rapidapi-host",readValuefromPropertiesfile("x-rapidapi-host"));
		//type1ApiObjects= new Type1ApiObjects();
		apiResponse=type1ApiObjects.getTeamsDetails(hmap);
		
		printResponse(apiResponse);
		verifyStatusCode(apiResponse, HttpUrlConnection.HTTP_NOT_ALLOWED);
		verifyExpectedNodeValues(apiResponse, "message", "You are not subscribed to this API.");
		
	}
	
	@Test(enabled=true,groups="type2",testName="Test2",description="Test2",priority=2)
	public void Test2() throws IOException {
	
		HashMap<String, String> hmap= new HashMap<>();
		hmap.put("x-rapidapi-key", readValuefromPropertiesfile("x-rapidapi-key"));
		hmap.put("x-rapidapi-host", readValuefromPropertiesfile("x-rapidapi-host"));
		apiResponse=type1ApiObjects.getTeamsDetails(hmap);
		
		
		System.out.println("ppppppppppppppppppppppppppppppppp");
		
	}
	
}
