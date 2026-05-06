package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ForgottenPage extends TestBase{
	
	public ForgottenPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//div[@class='col-sm-10']//input[@id='input-email']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtnForForgottenPage;
	
	
	
	public LoginPage enterEmailAddress(String emailID) {
		emailTextBox.sendKeys(emailID);
		continueBtnForForgottenPage.click();
		return new LoginPage();
	}

}
