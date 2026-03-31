package com.naveenautomation.pages;

import java.nio.file.Watchable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class NewsLetterPage extends TestBase {

	public NewsLetterPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//input[@value='1']")
	WebElement yesRadioBtnForSubscribe;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement contnueBtnOnNewsLetterPage;

	// Success: Your newsletter subscription has been successfully updated!

	public AccountPage clickOnYesRadioButton() {
		yesRadioBtnForSubscribe.click();
		contnueBtnOnNewsLetterPage.click();
		return new AccountPage();
	}

}
