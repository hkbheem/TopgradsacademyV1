package com.topGraduate.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;
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
	public void Verify_Employer_Registration_with_ValidData()
	{
		LandingPage landpage = new LandingPage(driver);
		landpage.openRegisterPage();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.openEmplRegisterPage();
		
		
	}

}
