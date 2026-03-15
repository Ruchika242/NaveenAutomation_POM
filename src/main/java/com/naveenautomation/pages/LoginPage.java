package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class LoginPage extends TestBase {
	 
	public LoginPage() {
		PageFactory.initElements(wd, this); // It helps in initialize all the elements with the webdriver of this LoginPage Class
	}
	


	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(css  = "div.alert")
	WebElement alertMsg;
    
	//This pvt method is not visible in LoginPageTest class of separate package
	private void enterEmail(String emailID) {
		emailInput.sendKeys(emailID);

	}

	private void enterPassword(String password) {

		pwdInput.sendKeys(password);
	}
	
	public AccountPage clickOnlogin(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
		loginBtn.click();
		return new AccountPage();
		
	}
	
	public String getAlertMsgText() {
		return alertMsg.getText();
	}

}
