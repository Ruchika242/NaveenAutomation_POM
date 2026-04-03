package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ProductDetailsPage extends TestBase {
	 
	public ProductDetailsPage() {
		PageFactory.initElements(wd, this);
	}
	
	

	
	@FindBy(xpath = "//input[@id=\"input-option225\"]")
	WebElement deliveryDateTextbox;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addToCartBtn;
	
	@FindBy(css="div#cart>button>span")
	WebElement itemAddedInCart;
	
	@FindBy(xpath="(//div//p[@class='text-right']//a)[2]")
	WebElement checkoutBtn;
	
	public void enterDeliveryDate(String date) {
		deliveryDateTextbox.clear();
		deliveryDateTextbox.sendKeys(date);
		
	}
	
	public void clickOnAddtoCart() {
		addToCartBtn.click();
	}
	
	public void clickOnCartBtn() {
		itemAddedInCart.click();
		
	}
	
	public CheckOutPage clickOnCheckoutBtn() {
		checkoutBtn.click();
		return new CheckOutPage();
	}
	
	
	
	

}
