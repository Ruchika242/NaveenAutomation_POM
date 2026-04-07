package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.testbase.TestBase;

public class AddAddressPage extends TestBase{
	
	public AddAddressPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="input[name='firstname']")
	WebElement firstNameInput2;
	

	@FindBy(css="input[name='lastname']")
	WebElement lastNameInput2;
	
	@FindBy(css="input[name='address_1']")
	WebElement address1Input2;
	
	@FindBy(css="input[name='city']")
	WebElement cityName2;
	
	@FindBy(css="input[name='postcode']")
	WebElement postalCode2;
	
	@FindBy(css="select#input-country")
	WebElement countrySelection2;
	
	
	@FindBy(css="select#input-zone")
	WebElement stateSelection2;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueBtnForAddAddress;
	
	public void selectCountryFromDropDown(WebElement element, String value) {
	Select select = new Select(element);
	    select.selectByVisibleText(value);
		
	}
	
	public void selectStateFromDropDown(WebElement element, String value) {
	
	   Select select = new Select(element);
	    
	    select.selectByVisibleText(value);
		
	}
	
	
	public AddressPage addAddressDetails(String fName, String lName, String address1, String city, String pinCode, String countryname, String stateName) {
		firstNameInput2.sendKeys(fName);
		lastNameInput2.sendKeys(lName);
		address1Input2.sendKeys(address1);
		cityName2.sendKeys(city);
		postalCode2.sendKeys(pinCode);
		countrySelection2.click();
		selectCountryFromDropDown(countrySelection2, countryname);
		stateSelection2.click();
		selectStateFromDropDown(stateSelection2, stateName);
		continueBtnForAddAddress.click();
		return new AddressPage();
		
		
		
	}

}
