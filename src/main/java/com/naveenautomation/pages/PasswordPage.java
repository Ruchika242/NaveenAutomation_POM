package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class PasswordPage extends TestBase {

	public PasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-password")
	WebElement newPasswdInput;

	@FindBy(id = "input-confirm")
	WebElement confirmPasswdInput;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement cntueBtn;

	public void enterNewPassword(String newPwd, String againNewPwd) {
		newPasswdInput.sendKeys(newPwd);
		confirmPasswdInput.sendKeys(againNewPwd);

	}

	public AccountPage clickOnBtnPwdPage() {
		cntueBtn.click();
		return new AccountPage();

	}

}
