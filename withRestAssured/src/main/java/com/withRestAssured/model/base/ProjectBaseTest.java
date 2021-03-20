package com.withRestAssured.model.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.withRestAssured.Specification.ExtentReportListner;

import io.restassured.response.Response;

@Listeners(ExtentReportListner.class)
public class ProjectBaseTest extends ExtentReportListner{

	public static final String BASEURL = "baseUrl";
	public String PORTNO = "port";
	public boolean flag = false;

	
	@BeforeClass(enabled = true)
	public static void init() {

	}

	@AfterClass(enabled = true)
	public void tearup() {

	}

	public void readvaluesFromTestng(String valuetobeRead) {

	}

	public String getNodeValue(Response response, String nodeLooked) {

		String nodeValue = response.then().extract().path(nodeLooked);

		return nodeValue;
	}

	public void printResponse(Response response) {
		System.out.println(response.asString());
	}

	public boolean verifyStatusCode(Response response, int statusExpected) {
		if (response.getStatusCode() == statusExpected) {
			flag = true;

		}
		return flag;

	}

	public boolean verifyExpectedNodeValues(Response response, String nodeName, String expectedNodeValue) {

		if (getNodeValue(response, nodeName).equalsIgnoreCase(expectedNodeValue)) {
			flag = true;
		}

		return flag;

	}

	public String readValuefromPropertiesfile(String propertytobeFetched) throws IOException {

		String propValue = "";
		FileInputStream fis = null;
		Properties prop = null;
		try {

			fis = new FileInputStream("src/main/resources/Application.properties");
			prop = new Properties();
			prop.load(fis);
		}

		finally {
			fis.close();
		}
		propValue = prop.getProperty(propertytobeFetched);

		if (!propValue.isEmpty()) {
			return propValue;
		} else {
			throw new ArithmeticException("PropertyNotFound");
		}

	}

}
