package com.topGraduate.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.topGraduate.testCases.BaseClass;

public class LandingPage extends BaseClass
{
	
	WebDriver ldriver;
	
	public LandingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='/contents/about-us']")
	WebElement aboutUs;
	
	@FindBy(xpath="//a[@href='/contents/howitworks']")
	WebElement howitworks;
	
	@FindBy(xpath="//a[@href='/blogs']")
	WebElement blogs;
	
	@FindBy(xpath="//a[@text='Login']")
	WebElement login;
	
	@FindBy(xpath="(//a[normalize-space()='Register'])")
	WebElement register;
	
	@FindBy(id="exampleInputEmail1")
	WebElement emailaddress;
	
	public void openAboutUspage()
	{
		aboutUs.click();
		
	}
	
	public void openHowItWorkspage()
	{
		howitworks.click();
	}
	
	public void openBlogspage()
	{
		blogs.click();
	}
	
	public void openLoginpage()
	{
		//WaitForAnElementToClickable(login);
		howitworks.click();
		//login.click();
		//WaitForAnElementToAppear(emailaddress);
	}
	
	public void openRegisterPage()
	{
		register.click();
		
	}
	

}
