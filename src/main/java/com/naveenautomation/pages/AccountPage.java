package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccText;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccInfo;

	@FindBy(css = "div.alert-success")
	WebElement successMsgOnUpdatingInfo;

	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logoutBtn;
	
	@FindBy(xpath="//a[text()='Password']")
	WebElement passwordChange;
	
	@FindBy(xpath ="//div[text()=' Success: Your password has been successfully updated.']")
	WebElement sucessMsgOnChangingPassword;

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

	public AccountLogoutPage clickOnLogout() {
		logoutBtn.click();
		return new AccountLogoutPage();

	}
	
	public PasswordPage clickOnPassword() {
		passwordChange.click();
		return new PasswordPage();
	}
	
	public String getTextOfSuccessMsgOnChangingThePwd() {
		return sucessMsgOnChangingPassword.getText();
	}

}
