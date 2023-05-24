package com.topGraduate.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.topGraduate.testCases.BaseClass;

public class EmployerRegistrationPage extends BaseClass
{
	
	WebDriver ldriver;
	
	public EmployerRegistrationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-blue home_btns']")
	WebElement employerRegister;
	
	@FindBy(xpath="//h1[normalize-space()='Create your Employer account']")
	WebElement createEmployerAccount;
	
	@FindBy(xpath="//div[@class='form-group mr-1']//input[@id='exampleInputEmail1']")
	WebElement firstName;
	
	@FindBy(xpath="//div[@class='form-group ml-1']//input[@id='exampleInputEmail1']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement workEmailAddress;
	
	@FindBy(xpath="//input[@formcontrolname='confirm_email']")
	WebElement confirmworkEmailAddress;
	
	@FindBy(xpath="//input[@formcontrolname='company']")
	WebElement companyName;
	
	@FindBy(xpath="//select[@id='exampleFormControlSelect1']")
	WebElement industryDropdown;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//input[@formcontrolname='confirm_password']")
	WebElement confirmpasswordfield;
	
	@FindBy(xpath="//span[@class='mat-checkbox-inner-container']")
	WebElement agreeTermsandConditions;
	
	@FindBy(xpath="//a[@class='btn btn-blue home_btns']")
	WebElement createAccountbutton;
	
	@FindBy(xpath="//div[@class='confirm-text text-center']/h1")
	WebElement registrationSuccessMsg;
	
	@FindBy(xpath="//div[@class='resend-btn mt-3']/button")
	WebElement resendEmailbutton;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container'][1]")
	WebElement mailsentsuccessmsg;
	
	
	
	
	public void CreateEmployerAccount(String firstname, String lastname, String emailaddress, String companyname, String password) throws InterruptedException
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		workEmailAddress.sendKeys(emailaddress);
		confirmworkEmailAddress.sendKeys(emailaddress);
		companyName.sendKeys(companyname);
		industryDropdown.click();
		Select s = new Select(industryDropdown);
		s.selectByVisibleText("Information Technology");
		passwordfield.sendKeys(password);
		confirmpasswordfield.sendKeys(password);
		agreeTermsandConditions.click();
		createAccountbutton.click();
		WaitForAnElementToAppear(registrationSuccessMsg);
		String regsuccessmessage = registrationSuccessMsg.getText();
		Assert.assertEquals(regsuccessmessage, "Registration success!");
		Thread.sleep(2000);
		
	}
	
	public void ResendEmail() throws InterruptedException
	{
		Thread.sleep(3000);
		resendEmailbutton.click();
		String mailSuccessMsg = mailsentsuccessmsg.getText();
		Assert.assertEquals(mailSuccessMsg, "Mail Sent Successfully");
	}
	
	
	
	
	
	public void openEmplRegisterPage()
	{
		employerRegister.click();
		WaitForAnElementToAppear(createEmployerAccount);
	}
	

}
