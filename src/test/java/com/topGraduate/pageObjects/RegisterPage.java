package com.topGraduate.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.topGraduate.testCases.BaseClass;

public class RegisterPage extends BaseClass
{
	
	WebDriver ldriver;
	
	public RegisterPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-blue home_btns']")
	WebElement employerRegister;
	
	@FindBy(xpath="//h1[normalize-space()='Create your Employer account']")
	WebElement createEmployerAccount;
	
	
	public void openEmplRegisterPage()
	{
		employerRegister.click();
		WaitForAnElementToAppear(createEmployerAccount);
	}
	

}
