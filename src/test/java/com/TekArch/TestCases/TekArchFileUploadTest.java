package com.TekArch.TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TekArch.Pages.TekArchFileUploadpage;
import com.TekArch.Pages.TekArchloginpage;
import com.TekArch.Utility.TeKArchBaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class TekArchFileUploadTest extends TeKArchBaseClass{

	TekArchFileUploadpage TekUpload;
	TekArchloginpage Teklogin;
	
	@BeforeTest
	 public void triggerDependency() {
		TekUpload = new TekArchFileUploadpage(driver);
		Teklogin = new TekArchloginpage(driver);
	 }
	
	 @Test
	 public void TekArchCalculator() throws Exception {
		 extlogger = reports.startTest("Login Starts");
		 extlogger.log(LogStatus.INFO, "Login Successful");
		 logger.info("URL Opened");
		 Teklogin.LoginTekArchUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
		 logger.info("Login Success");
		 TekUpload.UploadPicture();
		 logger.info("Picture Uploaded Successful");
		 reports.endTest(extlogger);
		 extlogger.log(LogStatus.INFO, "uploading picture is passed");
		 extlogger.log(LogStatus.PASS, extlogger.addScreenCapture(System.getProperty("user.dir")+"//screenshotExtent/sreenshot_"+"PictureUpload"+".png"));
	 } 
}

