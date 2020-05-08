package com.mobilePortal.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mobilePortal.qa.Listeners.TestAllureListener;
import com.mobilePortal.qa.base.TestBase;
import com.mobilePortal.qa.pages.AddmacOSPolicyPage;
import com.mobilePortal.qa.pages.DeletemacOSPolicyPage;
import com.mobilePortal.qa.pages.MobileAdminPage;
import com.mobilePortal.qa.pages.LoginPage;
import com.mobilePortal.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class DeletemacOSPolicyPageTest extends TestBase {

	String sheetName = "DeleteMacOSPolicy";
	
	LoginPage loginPage;
	
	MobileAdminPage mobileAdminPage;
		
	DeletemacOSPolicyPage deletemacOSPolicyPage;
		
	public DeletemacOSPolicyPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
		mobileAdminPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

		mobileAdminPage.validateZappPortalLogin();

		deletemacOSPolicyPage = new DeletemacOSPolicyPage();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object testData[][] = TestUtil.getTestData(sheetName);
		
		return testData;
		
	}
	
	@Test(priority = 1,dataProvider = "getData",description = "Test case description: deleting macOS policy")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description: deleting macOS policy")
	@Story("Story Name: To delete macOS policy")
	public void validateDeletePolicy(String name) throws InterruptedException {
		
		deletemacOSPolicyPage.validateDeletePolicy(name);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
