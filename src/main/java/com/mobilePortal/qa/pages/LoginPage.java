package com.mobilePortal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {

	//PageFactory or ObjectRepository
	
	@FindBy(id="login-panel-input-email")
	WebElement username;
	
	@FindBy(id="login-panel-input-password")
	WebElement password;
	
	@FindBy(id="login-panel-signin-button")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[@src='img/zscaler_login_logo.png']")
	WebElement zscalerLogo;
	
	@FindBy(xpath = "//*[@data-item='dashboard']")
	WebElement dashboardLbl;
	
	//Initialize the page objects
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	@Step("getting login page title step.....")
	public void validateLoginPage() {
		
		driver.get(prop.getProperty("url"));
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Zscaler Cloud Portal");
			
		Assert.assertTrue(zscalerLogo.isDisplayed());
		
	}
	
	@Step("login to admin portal and verifying it step......")
	public MobileAdminPage validateLogin(String usrname,String pwd) {
		
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		loginBtn.click();

		TestUtil.webDriverWait(driver, dashboardLbl, 90);
		
		boolean flag = dashboardLbl.isDisplayed();
		
		Assert.assertTrue(flag);
		
		return new MobileAdminPage();
		
	}

	
	
	
}//class
