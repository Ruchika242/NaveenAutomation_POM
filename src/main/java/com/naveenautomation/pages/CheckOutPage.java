package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.testbase.TestBase;

public class CheckOutPage extends TestBase {
	public CheckOutPage() {
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement checkOutPagetext;
	
	@FindBy(id = "input-email")
	WebElement emailInputCOP;

	@FindBy(id = "input-password")
	WebElement pwdInputCOP;

	@FindBy(id = "button-login")
	WebElement loginBtnCOP;
	
	@FindBy(css = "div.radio>label>input[value='new']")
	WebElement newAddressRadioBtn;
	
	@FindBy(css="input[name='firstname']")
	WebElement firstNameInput;
	

	@FindBy(css="input[name='lastname']")
	WebElement lastNameInput;
	
	@FindBy(css="input[name='address_1']")
	WebElement address1Input;
	
	@FindBy(css="input[name='city']")
	WebElement cityName;
	
	@FindBy(css="input[name='postcode']")
	WebElement postalCode;
	
	@FindBy(css="select[name='country_id']")
	WebElement countrySelection;
	
	@FindBy(css="select[name='zone_id']")
	WebElement stateSelection;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueBtnForBillingDetails;
	
	@FindBy(css="input#button-shipping-address")
	WebElement continueBtnForDeliveryDetails;
	
	
	@FindBy(css="input#button-shipping-method")
	WebElement continueBtnForDeliveryMethod; 
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBoxForPaymentMethod;
	
	@FindBy(css="input#button-payment-method")
	WebElement continueBtnForPaymentMethod; 
	
	@FindBy(css="input#button-confirm")
	WebElement confirmOrderBtn;
	
	
	public String validateCheckoutPagetitle() {
		return checkOutPagetext.getText();
	}
	
	public void clickOnLoginForCheckOut(String email1, String pwd1) {
		emailInputCOP.sendKeys(email1);
		pwdInputCOP.sendKeys(pwd1);
		loginBtnCOP.click();
		
	}
	
	public void clickOnNewAddressRadioBtn() {
		newAddressRadioBtn.click();
	}
	
	

	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sc= new Select(element);
		sc.selectByVisibleText(visibleText);

}
	
	public void fillAndSubmitBillingDetails(String fName, String lName, String address1, String city, String pinCode, String countryname, String stateName) {
		firstNameInput.sendKeys(fName);
		lastNameInput.sendKeys(lName);
		address1Input.sendKeys(address1);
		cityName.sendKeys(city);
		postalCode.sendKeys(pinCode);
		countrySelection.sendKeys(countryname);
		stateSelection.sendKeys(stateName);
		continueBtnForBillingDetails.click();
		//#input#button-shipping-method
		
		
	}
	
	public void addDeliveryDetails() {
		continueBtnForDeliveryDetails.click();
		
	}
	
	public void selectDeliveryMethod() {
		continueBtnForDeliveryMethod.click();
	}
	
	public void selectCheckBoxForPaymentMethod() {
		checkBoxForPaymentMethod.click();
	}
	
	public void clickOnContinueBtnForPaymentMethod() {
		continueBtnForPaymentMethod.click();
	}
	
	public SuccessPage clickOnConfirmButton() {
		confirmOrderBtn.click();
		return new SuccessPage();
	}
	
	
	
	
	
	
	
	
}
