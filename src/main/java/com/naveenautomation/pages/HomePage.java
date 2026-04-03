package com.naveenautomation.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(wd, this);

	}
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBar;

	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement homePageText;
	
	@FindBy(css="#search>span.input-group-btn>button")
	WebElement searchBtn;

	public String getHomePageText() {
		return homePageText.getText();
	}
	
	public ProductSearchPage enterProductNameInSearchBar(String productName) {
		searchBar.sendKeys(productName);
		searchBtn.click();
		return new ProductSearchPage();
		

	}

}
