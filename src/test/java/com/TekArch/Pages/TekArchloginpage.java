package com.TekArch.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TekArch.Utility.TeKArchBaseClass;

public class TekArchloginpage extends TeKArchBaseClass{

	WebDriver driver;
	public TekArchloginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(id="email_field") WebElement UserName;
	@FindBy(id="password_field") WebElement PassWord;
	@FindBy(xpath="//button[contains(text(),'Login to Account')]") WebElement LoginButton;
	@FindBy(xpath="//a[contains(text(),'Home')]") WebElement HomeButton;
	
	
	public boolean LoginTekArchUserPassDetails(String username, String password) throws Exception {
		boolean flag = false;
		oBroUtil.ExplicitWebDriverWait(UserName, 40);
		oBroUtil.ufClearElement(UserName);
		oBroUtil.ufSendKeys(UserName, username);
		oBroUtil.ExplicitWebDriverWait(PassWord, 40);
		oBroUtil.ufClearElement(PassWord);
		oBroUtil.ufSendKeys(PassWord, password);
		oBroUtil.ExplicitWebDriverWait(LoginButton, 40);
		oBroUtil.ufClickElement(LoginButton);
		oBroUtil.ExplicitWebDriverWait(HomeButton, 40);
		if(oBroUtil.isDisplayed(HomeButton)) {
			flag = true;
		}
		return flag;
			
	}
}
