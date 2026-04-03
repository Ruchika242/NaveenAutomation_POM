package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ProductSearchPage extends TestBase {
	
	public ProductSearchPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//a[text()='HP LP3065']")
	WebElement HpLaptopText;
	
	
	
	
	
	
	public String getTextHPLaptop() {
		return HpLaptopText.getText();
	}
	
	public ProductDetailsPage clickOnProduct() {
		HpLaptopText.click();
		return new ProductDetailsPage();
	}
	
	
	

}
