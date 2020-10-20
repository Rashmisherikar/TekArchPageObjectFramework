package com.TekArch.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TekarchBrowserUtility extends TeKArchBaseClass{

public WebDriver LaunchBrowser(String sBrowserName, String appURL) {
		
		switch(sBrowserName) { 
		case "ch": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "ff": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
			default:
				break;
		}
		
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
public Properties loginReadDetails() throws Exception {
	
	String sPath = System.getProperty("user.dir")+"/src/main/java/properties/config.properties";
	Properties prop = new Properties();
	FileInputStream fi = new FileInputStream(sPath);
	prop.load(fi);
	return prop;
		
}
public void CaptureScreenShot(String ScreenShotName) {
	
	try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/"+ScreenShotName+".png")); //. operator refers to current working directory.
		System.out.println("Screenshot taken");
	} catch (Exception e) {
		
		System.out.println("Exception while taking screenshot" +e.getMessage());
	} 
	
}

//Fluent wait not working
/*@SuppressWarnings("deprecation")
public boolean waitforElementvisible(WebDriver driver, WebElement ele, int iTimeInSeconds) throws Exception{
	
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(iTimeInSeconds, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class);
	wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			if(ele.isDisplayed()) {
				logger.info("Element Displayed : " +ele);
				return ele;
			
			}
			else {
				logger.info("Element is still displaying : " +ele);
				return null;
			}
		}
	});
	return ele.isDisplayed();
	
}*/
	
public void ExplicitWebDriverWait(WebElement ele,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(ele));	
}

public boolean isDisplayed(WebElement ele) throws Exception {
	boolean flag = false;
	try {
		if(ele.isDisplayed()) {
			logger.info("Element Displayed : " +ele);
			flag = true;
		}	
	}catch (Exception e){
		flag = false;	
	}
	return flag;
}
public void ufClickElement(WebElement ele) {
	ele.click();
}

public void ufClearElement(WebElement ele) {
	ele.clear();
}

public void ufSendKeys(WebElement ele, String text) {
	ele.sendKeys(text);
}

public void tearDownBrowser() {
	driver.quit();
	}

}

