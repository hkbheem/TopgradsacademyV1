package com.topGraduate.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.topGraduate.pageObjects.LandingPage;

public class TC_LandingTest_001 extends BaseClass
{
	
	@Test
	public void landingTest() throws InterruptedException, IOException
	{
		
		LandingPage landpage = new LandingPage(driver);
		
		landpage.openLoginpage();
	}

}
