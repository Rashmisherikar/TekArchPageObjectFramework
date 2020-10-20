package com.TekArch.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TekArch.Pages.TekArchCalculatorpage;
import com.TekArch.Pages.TekArchloginpage;
import com.TekArch.Utility.TeKArchBaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class TekArchCalculatorTest extends TeKArchBaseClass{

	TekArchCalculatorpage TekCal;
	TekArchloginpage Teklogin;
	
	@BeforeTest
	 public void triggerDependency() {
		TekCal = new TekArchCalculatorpage(driver);
		Teklogin = new TekArchloginpage(driver);
	 }
	
	 @Test
	 public void TekArchCalculator() throws Exception {
		
		 logger.info("URL Opened");
		 Teklogin.LoginTekArchUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
		 logger.info("Calculator Starts");
		 extlogger = reports.startTest("Calculator Starts");
		 extlogger.log(LogStatus.INFO, "Calculator Successful");
		 TekCal.calculator();
		 reports.endTest(extlogger);
		 oBroUtil.CaptureScreenShot("Calcualte Addition Picture");
		 logger.info("Get Added number Results in calculator");
		 
		 extlogger.log(LogStatus.INFO, "uploading picture is passed");
		
		//take a Screenshot using selenium
			TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
			File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
			String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"AddCalculator"+".png";//path of screenshot.
			File destination = new File(spathOfScreenShot);//file got created
			FileUtils.copyFile(source, destination);//file is copied here.
			extlogger.log(LogStatus.INFO, "login test case is passed");
			extlogger.log(LogStatus.PASS, extlogger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
		
	 }
}
