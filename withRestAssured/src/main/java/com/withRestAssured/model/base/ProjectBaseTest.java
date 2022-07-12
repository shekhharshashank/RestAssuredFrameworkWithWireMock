package com.withRestAssured.model.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.withRestAssured.Specification.ExtentReportListner;

import io.restassured.response.Response;

@Listeners(ExtentReportListner.class)
public class ProjectBaseTest extends ExtentReportListner{

	public static final String BASEURL = "baseUrl";
	public String PORTNO = "port";
	public boolean flag = false;
	protected final String BASE_URL_WIREMOCK="http://localhost:8080";
	protected static final int PORT=8080;
	protected static final String HOST="localhost";
 
	
	
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
	
	public void reportLog(String message) {    
	    test.log(LogStatus.INFO, message);//For extentTest HTML report
	    Logger logger= Logger.getLogger(Thread.currentThread().getClass().getCanonicalName());
	    logger.info("Message: " + message);
	    Reporter.log(message);

	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		
	}
	
	
	@BeforeSuite(alwaysRun=true)
	public static void initializeThings() {

	}
	@AfterSuite(alwaysRun=true)
	public static void tearThings() {
		
		//reports.close();
	}
	
	
}
