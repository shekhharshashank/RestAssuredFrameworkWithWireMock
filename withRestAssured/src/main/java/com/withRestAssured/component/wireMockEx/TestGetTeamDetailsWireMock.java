package com.withRestAssured.component.wireMockEx;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.withRestAssured.model.apiobjects.Type1ApiObjects;
import com.withRestAssured.model.base.ProjectBaseTest;
import com.github.tomakehurst.wiremock.*;
import com.withRestAssured.model.utils.HttpUrlConnection;

import io.restassured.response.Response;

public class TestGetTeamDetailsWireMock extends ProjectBaseTest implements ITest{

	public Response apiResponse;
	public Type1ApiObjects type1ApiObjects;
	protected static WireMockServer  server= new WireMockServer(PORT);
	
	
	/**
	 * 
	 * 
	 * Starting the wireMock Server and configuring for Port
	 */
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethods() {
		type1ApiObjects= new Type1ApiObjects();
		server.start();
		WireMock.configureFor(HOST, PORT);
		
	}
	
	/**
	 * 
	 */
	@AfterMethod(alwaysRun=true)
	public void afterMethods() {
		type1ApiObjects= null;
		server.stop();
	}
	
	/**
	 * @throws IOException
	 */
	@Test(enabled=true,groups="type3",testName="TestWireMock",description="TestWireMock",priority=1)
	public void TestWireMock() throws IOException {
	
		
		apiResponse=type1ApiObjects.getTeamsDetailsviaWireMock("/api/wiremock/");
		
		printResponse(this.apiResponse);
		Assert.assertTrue(verifyStatusCode(apiResponse, HttpUrlConnection.HTTP_OK));
		Assert.assertTrue(apiResponse.getBody().asString().contains("Sample Body"));
		
	}
		
	/**
	 *For Logging The Method Name and ClassName
	 */
	@Override
	public String getTestName() {
		return TestGetTeamDetailsWireMock.class.getName();
	}
	
}
