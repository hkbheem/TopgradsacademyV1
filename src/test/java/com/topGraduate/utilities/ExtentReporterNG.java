package com.topGraduate.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG 
{
	
	public static ExtentReports getReportObject()
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		
		String path = System.getProperty("user.dir")+"//reports//"+repName;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Bheem");
		
		reporter.config().setDocumentTitle("TopGraduate Test Project");
		reporter.config().setReportName("Functional Test Automation Report");
		reporter.config().setTheme(Theme.DARK);
		return extent;
	}
	

}
