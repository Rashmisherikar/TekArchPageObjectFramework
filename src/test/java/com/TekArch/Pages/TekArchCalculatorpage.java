package com.TekArch.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TekArch.Utility.TeKArchBaseClass;

public class TekArchCalculatorpage extends TeKArchBaseClass{

	WebDriver driver;
	public TekArchCalculatorpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath="//a[contains(text(),'Calculator')]") WebElement CalculaotorTab;
	
	@FindBy(xpath="//input[@value='0']") WebElement Num0;
	@FindBy(xpath="//input[@value='1']") WebElement Num1;
	@FindBy(xpath="//input[@value='2']") WebElement Num2;
	@FindBy(xpath="//input[@value='3']") WebElement Num3;
	@FindBy(xpath="//input[@value='4']") WebElement Num4;
	@FindBy(xpath="//input[@value='5']") WebElement Num5;
	@FindBy(xpath="//input[@value='6']") WebElement Num6;
	@FindBy(xpath="//input[@value='7']") WebElement Num7;
	@FindBy(xpath="//input[@value='8']") WebElement Num8;
	@FindBy(xpath="//input[@value='9']") WebElement Num9;
	
	@FindBy(xpath="//input[@value='+']") WebElement Add;
	@FindBy(xpath="//input[@value='-']") WebElement Sub;
	@FindBy(xpath="//input[@value='x']") WebElement Mul;
	@FindBy(xpath="//input[@value='/']") WebElement Div;
	@FindBy(xpath="//input[@value='=']") WebElement Equal;
	
	
	public void calculator() throws InterruptedException {
		oBroUtil.ExplicitWebDriverWait(CalculaotorTab, 40);
		oBroUtil.ufClickElement(CalculaotorTab);
		Thread.sleep(3000);
		oBroUtil.ExplicitWebDriverWait(Num1, 40);
		oBroUtil.ufClickElement(Num1);
		oBroUtil.ExplicitWebDriverWait(Num7, 40);
		oBroUtil.ufClickElement(Num7);
		oBroUtil.ExplicitWebDriverWait(Add, 40);
		oBroUtil.ufClickElement(Add);
		oBroUtil.ExplicitWebDriverWait(Num7, 40);
		oBroUtil.ufClickElement(Num7);
		oBroUtil.ExplicitWebDriverWait(Equal, 40);
		oBroUtil.ufClickElement(Equal);	
			
		}
}
