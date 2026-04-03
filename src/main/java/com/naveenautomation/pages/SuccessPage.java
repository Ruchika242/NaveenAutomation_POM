package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class SuccessPage extends TestBase {
	
	public SuccessPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath="//h1[text()='Your order has been placed!']")
	WebElement msgOnOrderPlaced;
	
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtnOnSuccessPage;
	
	public String textOnOrderPlaced() {
		return msgOnOrderPlaced.getText();
	}
	
	public HomePage clickOnContinueBtnOnSuccessPage() {
		continueBtnOnSuccessPage.click();
		return new HomePage();
	}
	
	

}
