package com.TekArch.TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TekArch.Pages.TekArchloginpage;
import com.TekArch.Utility.TeKArchBaseClass;
import com.relevantcodes.extentreports.LogStatus;


public class TekArchloginTest extends TeKArchBaseClass{

	TekArchloginpage Teklogin;
	
	@BeforeTest
	 public void triggerDependency() {
		Teklogin = new TekArchloginpage(driver);
	 }
	 
	 @Test
	 public void loginTekArch() throws Exception {
		 extlogger = reports.startTest("Login Starts");
		 extlogger.log(LogStatus.INFO, "Login Successful");
		 logger.info("URL Opened");
		 Teklogin.LoginTekArchUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Login Success");
		reports.endTest(extlogger);
		extlogger.log(LogStatus.INFO, "login test case is passed");
		extlogger.log(LogStatus.PASS, extlogger.addScreenCapture(System.getProperty("user.dir")+"//screenshotExtent/sreenshot_"+"LoginTekArchPage"+".png"));
	 }
}
