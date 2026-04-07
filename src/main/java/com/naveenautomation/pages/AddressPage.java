package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class AddressPage extends TestBase {
	
	public AddressPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath="//a[text()='New Address']")
	WebElement newAddressBtn;
	
	@FindBy(xpath="//div[text()=' Your address has been successfully added']")
	WebElement msgOnAddingNewAddress;
	
	@FindBy(xpath="(//td[@class='text-right']//a[text()='Delete'])[2]")
	WebElement deleteAddress;
	
	@FindBy(xpath="//div[text()=' Your address has been successfully deleted']")
	WebElement msgOnRemovingNewAddress;
	
	public  AddAddressPage clickOnNewAddress() {
		newAddressBtn.click();
		return new AddAddressPage();
	}
	
	public String getTextOnAddressAdded() {
		return msgOnAddingNewAddress.getText();
	}
	
	public void clickOnDeleteBtn() {
		deleteAddress.click();
	}
	
	public String getTextOnRemovingAddress() {
		return msgOnRemovingNewAddress.getText();
	}
	
	
	

}
