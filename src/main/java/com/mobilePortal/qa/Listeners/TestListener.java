package com.mobilePortal.qa.Listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mobilePortal.qa.util.TestUtil;

public class TestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
	
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
