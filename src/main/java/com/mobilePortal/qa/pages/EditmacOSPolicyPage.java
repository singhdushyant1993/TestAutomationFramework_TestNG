package com.mobilePortal.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Step;

public class EditmacOSPolicyPage extends TestBase {

	@FindBy(xpath = "//*[@class='nav-menu-header-label' and text()='App Profiles']")
	WebElement AppProfilesLbl;
	
	@FindBy(id = "add-windows-policy")
	WebElement addWindowsPolicyBtn;
	
	@FindBy(xpath = "//*[text()='macOS' and @class='nav-menu-list-item']")
	WebElement macOSLbl;
	
	@FindBy(xpath = "//textarea[@data-form-element-name='description']")
	WebElement policyDescriptionTxtField;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(id = "add-macOS-policy")
	WebElement AddmacOSPolicyBtn;
	
	public EditmacOSPolicyPage() {
		
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@Step("Editing macOS policy description step......")
	public void validateEditMacOsPolicy(String name,String ruleOrder,String enable,String groups,String logoutPassword,String disablePassword,String customPACUrl,String forwardingProfile,String installCert,String logMode,String logFileSize,String reactiveInternetSecurity,String hostName,String z_tunnelConfig,String destinationInclusions,String policyDescription) {
		
		validateMacOSLblClick();
		
		validateEditPolicyDescription(name,policyDescription);
		
	}

	@Step("Clicking on macOS lbl step......")
	public void validateMacOSLblClick() {
		
		TestUtil.webDriverWait(driver, AppProfilesLbl, 60);
		
		AppProfilesLbl.click();
		
		TestUtil.webDriverWait(driver, addWindowsPolicyBtn, 90);
		
		macOSLbl.click();
		
	}
	
	@Step("Editing macOS policy description step......")
	public void validateEditPolicyDescription(String name,String policyDescription) {
		
		TestUtil.webDriverWait(driver, AddmacOSPolicyBtn, 60);
		
		WebElement policyNameEditBtn = driver.findElement(By.xpath("//*[text()='"+name+"']//parent::span//parent::div//child::span[@title='Configure']"));
		
		policyNameEditBtn.click();
		
		policyDescriptionTxtField.clear();
		
		policyDescriptionTxtField.sendKeys(policyDescription);
		
		saveBtn.click();
		
		TestUtil.webDriverWait(driver, AddmacOSPolicyBtn, 20);
		
	}
	
	
}
