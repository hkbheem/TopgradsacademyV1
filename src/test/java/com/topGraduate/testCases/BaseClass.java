package com.topGraduate.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import com.topGraduate.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	
	public String employerUsername = readconfig.getEUsername();
	public String employerPassword = readconfig.getEPassword();
	
	public static WebDriver driver;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		//driver.get(baseURL);
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(br.equals("msedge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//		
//	}
	
	public String captureScreenshot(String tname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png");
		FileUtils.copyFile(src, target);
		return System.getProperty("user.dir")+"/Screenshots/"+ tname +".png";
	}
	
	public void WaitForAnElementToAppear(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
	public void WaitForAnElementToClickable(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	
	

}
