package com.mobilePortal.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mobilePortal.qa.util.TestUtil;
import com.mobilePortal.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		try {
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/mobilePortal/qa/config/config.properties");
			
			prop = new Properties();
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	
	}//TestBase
	

	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
						
			System.setProperty("webdriver.chrome.driver", prop.getProperty("webDriverPath"));
			
			driver = new ChromeDriver();
			
		} else if(browserName.equals("safari")) {
			
			driver = new SafariDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		
		e_driver.register(eventListener);
		
		driver = e_driver;
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}//initialization
	
	
	
	
}//class
