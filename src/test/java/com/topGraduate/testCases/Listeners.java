package com.topGraduate.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.topGraduate.utilities.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent =ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String filepath = null;
		try {
			filepath = captureScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
		
	}
	
	@Override
	public void onStart(ITestContext context)
	{
		//TODO Auto-generated
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		
		extent.flush();
	}
	
	
	

}
