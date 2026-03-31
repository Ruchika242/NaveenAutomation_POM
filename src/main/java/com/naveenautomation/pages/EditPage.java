package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class EditPage extends TestBase {

	public EditPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	WebElement lastNameInput;

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-telephone")
	WebElement telephoneInput;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;

	public void enterFirstName(String firstName) {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);

	}

	public void enterLastName(String LastName) {
		lastNameInput.clear();
		lastNameInput.sendKeys(LastName);

	}

	public void enterEmailID(String Emailid) {
		emailInput.clear();
		emailInput.sendKeys(Emailid);

	}

	public void enterContactNo(String mobNo) {
		emailInput.clear();
		emailInput.sendKeys(mobNo);

	}

	public AccountPage clickOnContinuebtn() {
		continueBtn.click();
		return new AccountPage();
	}

}
