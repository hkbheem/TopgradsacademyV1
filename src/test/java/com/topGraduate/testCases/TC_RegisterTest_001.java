package com.topGraduate.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.topGraduate.pageObjects.EmployerRegistrationPage;
import com.topGraduate.pageObjects.LandingPage;
import com.topGraduate.pageObjects.RegisterPage;

public class TC_RegisterTest_001 extends BaseClass
{
	
	@Test
	public void Verify_Employer_Register_Page_Display() throws InterruptedException, IOException
	{
		
		LandingPage landpage = new LandingPage(driver);
		landpage.openRegisterPage();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.openEmplRegisterPage();
		
		
	}
	
	@Test
	public void Verify_Employer_Registration_with_ValidData() throws InterruptedException
	{
		LandingPage landpage = new LandingPage(driver);
		landpage.openRegisterPage();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.openEmplRegisterPage();
		
		EmployerRegistrationPage regpage = new EmployerRegistrationPage(driver);
		regpage.CreateEmployerAccount("Keshav", "K", "keshavl.r@gmail.com", "Broadridge", "Keshav@111" );
		
		
	}
	
	@Test(dependsOnMethods = "Verify_Employer_Registration_with_ValidData")
	public void Verify_Resend_Email_Functionality() throws InterruptedException
	{
		
		EmployerRegistrationPage regpage = new EmployerRegistrationPage(driver);
		regpage.ResendEmail();
		
		
	}
	
	

}
