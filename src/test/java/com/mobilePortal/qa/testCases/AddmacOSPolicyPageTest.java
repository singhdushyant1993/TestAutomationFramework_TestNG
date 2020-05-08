package com.mobilePortal.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mobilePortal.qa.Listeners.TestAllureListener;
import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.pages.AddmacOSPolicyPage;
import com.mobilePortal.qa.pages.MobileAdminPage;
import com.mobilePortal.qa.pages.LoginPage;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class AddmacOSPolicyPageTest extends TestBase{

	String sheetName = "AddMacOSPolicy";

	LoginPage loginPage;
	
	MobileAdminPage mobileAdminPage;
	
	AddmacOSPolicyPage addmacOSPolicyPage;
		
	public AddmacOSPolicyPageTest() {
	
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
		mobileAdminPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

		mobileAdminPage.validateZappPortalLogin();

		addmacOSPolicyPage = new AddmacOSPolicyPage();
		
	}
	
	
	@DataProvider()
	public Object[][] getPolicyTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
		
	}
	
	
	@Test(priority = 1,dataProvider = "getPolicyTestData",description = "Test case description: Add macOS policy")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description: Add macOS policy")
	@Story("Story Name: To add macOS policy")
	public void validateAddMacOSPolicy(String name,String ruleOrder,String enable,String groups,String logoutPassword,String disablePassword,String customPACUrl,String forwardingProfile,String installCert,String logMode,String logFileSize,String reactiveInternetSecurity,String hostName,String z_tunnelConfig,String destinationInclusions,String policyDescription) throws InterruptedException  {

		addmacOSPolicyPage.validateAddMacOSPolicy(name, ruleOrder, enable, groups, logoutPassword, disablePassword, customPACUrl, forwardingProfile, installCert, logMode, logFileSize, reactiveInternetSecurity, hostName, z_tunnelConfig, destinationInclusions, policyDescription);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
}//class
