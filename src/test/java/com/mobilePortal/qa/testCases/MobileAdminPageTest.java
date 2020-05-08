package com.mobilePortal.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mobilePortal.qa.Listeners.TestAllureListener;
import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.pages.MobileAdminPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import com.mobilePortal.qa.pages.LoginPage;

@Listeners({TestAllureListener.class})
public class MobileAdminPageTest extends TestBase{
	
	MobileAdminPage mobileAdminPage;
	
	LoginPage loginPage;
	
	MobileAdminPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
		mobileAdminPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1,description = "Test case description: Validate Zscaler app portal login")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description: Validate Zscaler app portal login")
	@Story("Story Name: To login to Zscaler app portal")
	public void validateZappPortalLogin() throws InterruptedException {
		
		mobileAdminPage.validateZappPortalLogin();
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
}
