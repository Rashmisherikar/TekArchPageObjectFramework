package com.TekArch.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TekArch.Utility.TeKArchBaseClass;

public class TekArchFileUploadpage extends TeKArchBaseClass{
	WebDriver driver;
	public TekArchFileUploadpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[contains(text(),'File Upload')]") WebElement FileUpload;
	@FindBy(id="logo") WebElement ChooseFile;
	@FindBy(xpath="//img[contains(@src,'data')]") WebElement ImageDisplayed;
	
	public boolean UploadPicture() throws Exception {
		boolean flag = false;
		oBroUtil.ExplicitWebDriverWait(FileUpload, 40);
		oBroUtil.ufClickElement(FileUpload);
		oBroUtil.ExplicitWebDriverWait(ChooseFile, 40);
		oBroUtil.ufSendKeys(ChooseFile, "C:\\Users\\gsshy\\Downloads\\Amazon-parrot.jpg");
		oBroUtil.CaptureScreenShot("Uploaded Picture");
		Thread.sleep(1000);
		if(oBroUtil.isDisplayed(ImageDisplayed)) {
			flag = true;
		}
		return flag;
	}
}
