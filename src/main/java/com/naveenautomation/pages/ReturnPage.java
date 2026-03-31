package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ReturnPage extends TestBase {

	public ReturnPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have not made any previous returns!']")
	WebElement textForNoReturn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement contineBtnOnReturnsPage;

	public String messageForNoReturns() {
		return textForNoReturn.getText();

	}

	public AccountPage clickOnContinueBtnOnReturnPage() {
		contineBtnOnReturnsPage.click();
		return new AccountPage();
	}

}
