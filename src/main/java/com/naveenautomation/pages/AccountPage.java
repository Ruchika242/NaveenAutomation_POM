package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class AccountPage extends TestBase{
	
	public AccountPage() {
		PageFactory.initElements(wd, this);
		
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccText;
	
	@FindBy(xpath ="//a[text()='Edit your account information']")
	WebElement editAccInfo;
	
	@FindBy(css="div.alert-success")
	WebElement successMsgOnUpdatingInfo;
	
	public String getTextOfMyAccountPage() {
		return myAccText.getText();
	}
	
	
	public EditPage clickOnEditAccount() {
		editAccInfo.click();
		return new EditPage();
	}
	
	public String getTextOfSucessMsg() {
		return successMsgOnUpdatingInfo.getText();
	}
	

}
