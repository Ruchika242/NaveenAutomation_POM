package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class AccountLogoutPage extends TestBase {
	public AccountLogoutPage() {
		PageFactory.initElements(wd, this);
		
	}
	
	@FindBy(xpath=("//p[text()='You have been logged off your account. It is now safe to leave the computer.']"))
	WebElement textAfterlogOut;
	
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;
	
	
	
	public String getTextOfMsgAfterLogout() {
		return textAfterlogOut.getText();
	}
	
	public HomePage clickContineBtn() {
		continueBtn.click();
		return new HomePage();
	}
    
}
