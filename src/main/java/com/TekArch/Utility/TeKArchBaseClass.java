package com.TekArch.Utility;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(com.TekArch.Listeners.TestListener.class)
public class TeKArchBaseClass {

	public WebDriver driver;
	public Properties prop;
	public static TekarchBrowserUtility oBroUtil = new TekarchBrowserUtility();
	public static Logger logger;
	public static ExtentReports reports;
	public static ExtentTest extlogger;
	String sPath = System.getProperty("user.dir")+"/ExtentReports/sampleReportBrowser.html";
	
@BeforeSuite
public void launchBrowser() throws Exception {
	reports = new ExtentReports(sPath);
	driver = oBroUtil.LaunchBrowser("ch", "https://qa-tekarch.firebaseapp.com/");
	prop = oBroUtil.loginReadDetails();
	//driver = oBroUtil.LaunchBrowser("ff", "https://qa-tekarch.firebaseapp.com/");
	System.out.println(driver.getTitle());
	logger = Logger.getLogger(getClass().getSimpleName());
	PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/java/properties/log4j.properties");
	
}

@AfterSuite
public void CloseBrowser() {
	oBroUtil.tearDownBrowser();
	reports.flush();
	
}

}
