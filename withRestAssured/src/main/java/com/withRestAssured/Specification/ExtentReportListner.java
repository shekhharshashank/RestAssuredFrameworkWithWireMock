package com.withRestAssured.Specification;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtentReportListner  implements ITestListener{
	
	protected static ExtentReports reports;
	protected static ExtentTest test;
	public static  PrintStream  requestCapture;
	public static StringWriter requestWriter;
	public Response apiResponse;
	public RequestSpecificationImpl request;
	public RequestSpecification requestSpecification;
	private static String resultpath = getResultPath();


	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {

		resultpath = "test";//new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	String ReportLocation = "test-output/Report/" + resultpath + "/";

	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		//System.out.println(result.getTestClass().getTestName());
		//System.out.println(result.getMethod().getMethodName());
		reports.addSystemInfo("UserName", "Shashank");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		test.log(LogStatus.PASS, "Test is pass");
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test  Failed");
		test.log(LogStatus.FAIL, "Caused Due to:- "+result.getThrowable());
		//test.log(LogStatus.FAIL, result.getThrowable().getStackTrace());
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		//System.out.println(ReportLocation + "  ReportLocation");
		reports = new ExtentReports(ReportLocation + "TestReport.html");
		

	}

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
		
	}
	
}
