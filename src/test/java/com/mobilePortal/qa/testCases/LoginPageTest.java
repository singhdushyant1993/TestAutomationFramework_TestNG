package com.mobilePortal.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mobilePortal.qa.Listeners.TestAllureListener;
import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase{

	LoginPage loginPage;
		
	public LoginPageTest() {
	
		super();
				
	} 
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1,description = "Test case description: Verify login page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: Verify login page title")
	@Story("Story Name: To check login page title")
	public void validateLoginPage() {
		
		loginPage.validateLoginPage();
		
	}
	
	@Test(priority=2,description = "Test case description: Login to admin portal and verify it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description: Login to admin portal and verify it")
	@Story("Story Name: To login to admin portal")
	public void validateLogin() {
		
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}//class
