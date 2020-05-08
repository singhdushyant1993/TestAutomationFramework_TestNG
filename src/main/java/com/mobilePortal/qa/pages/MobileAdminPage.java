package com.mobilePortal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Step;

public class MobileAdminPage extends TestBase{

	@FindBy(xpath = "//*[@data-item='dashboard']")
	WebElement dashboardLbl;
	
	@FindBy(xpath = "//*[@class='nav-menu' and @data-item='policy']")
	WebElement policyLabel;
	
	@FindBy(xpath = "//*[@class='button big primary -js-cancel-button']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//*[@class='nav-menu-list-item mobile-portal']")
	WebElement zappLabel;
	
	@FindBy(xpath = "//*[@class='nav-menu-header-label' and text()='App Profiles']")
	WebElement AppProfilesLbl;
	
	public MobileAdminPage() {
	
		PageFactory.initElements(driver, this);
	
	}
	
	//Actions	
	@Step("Login to zscaler app portal step.....")
	public void validateZappPortalLogin() {
		
		TestUtil.webDriverWait(driver, closeBtn, 95);
		
		if (closeBtn.isEnabled()) {
			
			closeBtn.click();
			 
		}
		
		Actions action = new Actions(driver);
		
		action.moveToElement(policyLabel).build().perform();
		
		TestUtil.webDriverWait(driver, zappLabel, 5);
		
		zappLabel.click();
		
		TestUtil.webDriverWait(driver, AppProfilesLbl, 90);
		
		Assert.assertTrue(AppProfilesLbl.isDisplayed());
		
		
	}//func
	
	
	
	
	
}//class
