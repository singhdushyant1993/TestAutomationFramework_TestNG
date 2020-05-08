package com.mobilePortal.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Step;

public class DeletemacOSPolicyPage extends TestBase {
	
	@FindBy(xpath = "//*[@class='nav-menu-header-label' and text()='App Profiles']")
	WebElement AppProfilesLbl;
	
	@FindBy(id = "add-windows-policy")
	WebElement addWindowsPolicyBtn;
	
	@FindBy(xpath = "//*[text()='macOS' and @class='nav-menu-list-item']")
	WebElement macOSLbl;
	
	@FindBy(id = "add-macOS-policy")
	WebElement macOSPolicyAddBtn;
	
	public DeletemacOSPolicyPage() {
		
		PageFactory.initElements(driver, this);
		
	}

	@Step("Deleting macOS policy step......")
	public void validateDeletePolicy(String name) throws InterruptedException {
		
		validateMacOSLblClick();
		
		TestUtil.webDriverWait(driver, macOSPolicyAddBtn, 60);
		
		WebElement policyNameDeleteBtn = driver.findElement(By.xpath("//*[text()='"+name+"']//parent::span//parent::div//child::span[@title='Delete']"));
		
		TestUtil.webDriverWait(driver, policyNameDeleteBtn, 60);
		
		policyNameDeleteBtn.click();
		
		WebElement okBtn = driver.findElement(By.xpath("//*[text()='OK']"));
		
		TestUtil.webDriverWait(driver, okBtn, 10);
		
		okBtn.click();
		
		Thread.sleep(800);
		
		TestUtil.webDriverWait(driver, macOSPolicyAddBtn, 60);
	}
	
	@Step("Clicking on macOS lbl step......")
	public void validateMacOSLblClick() {
		
		TestUtil.webDriverWait(driver, AppProfilesLbl, 60);
		
		AppProfilesLbl.click();
		
		TestUtil.webDriverWait(driver, addWindowsPolicyBtn, 90);
		
		macOSLbl.click();
		
	}

	
	
}
