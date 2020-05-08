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
import com.mobilePortal.qa.pages.EditmacOSPolicyPage;
import com.mobilePortal.qa.pages.MobileAdminPage;
import com.mobilePortal.qa.pages.LoginPage;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class EditmacOSPolicyPageTest extends TestBase {

	String sheetName = "EditMacOSPolicy";
	
	LoginPage loginPage;
	
	MobileAdminPage mobileAdminPage;
	
	EditmacOSPolicyPage editmacOSPolicyPage;
		
	public EditmacOSPolicyPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
		mobileAdminPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

		mobileAdminPage.validateZappPortalLogin();

		editmacOSPolicyPage = new EditmacOSPolicyPage();
		
	}
	
	@DataProvider
	public Object[][] getEditPolicyTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
	
	}
	
	@Test(priority = 1,dataProvider = "getEditPolicyTestData",description = "Test case description: Edit macOS policy description")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description: Edit macOS policy description")
	@Story("Story name: To edit macOS policy description")
	public void validateEditMacOsPolicy(String name,String ruleOrder,String enable,String groups,String logoutPassword,String disablePassword,String customPACUrl,String forwardingProfile,String installCert,String logMode,String logFileSize,String reactiveInternetSecurity,String hostName,String z_tunnelConfig,String destinationInclusions,String policyDescription) {
		
		editmacOSPolicyPage.validateEditMacOsPolicy(name, ruleOrder, enable, groups, logoutPassword, disablePassword, customPACUrl, forwardingProfile, installCert, logMode, logFileSize, reactiveInternetSecurity, hostName, z_tunnelConfig, destinationInclusions, policyDescription);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
