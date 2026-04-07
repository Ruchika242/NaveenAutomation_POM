package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class CategoryPage extends TestBase{
	
	public CategoryPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath="(//div[@class='button-group']//button)[2]")
	WebElement addToWishlistBtn;
	
	@FindBy(css ="#product-category > div.alert")
	WebElement msgOnAddingProductInWishList;
	
	@FindBy(xpath="//span[text()='Wish List (1)']")
	WebElement wishListBtn;
	
	@FindBy(xpath = "(//div[@class='button-group']//button[@data-original-title='Compare this Product'])[1]")
	WebElement compareIcon; 
	
	@FindBy(xpath="//div//a[text()='product comparison']")
	WebElement productComparisonText;
	
	
	public void clickOnProductWishlistButton() {
		addToWishlistBtn.click();
	}
	
	public String getTextMsgOnAddingProductInWishList() {
		return msgOnAddingProductInWishList.getText().replace("×", "").trim();
		
	}
	
	public WishListPage clickOnWishListButton() {
		wishListBtn.click();
		return new WishListPage();
	}
	
	public void clickOnCompareIcon() {
		compareIcon.click();
	}
	
	public ComparePage clickOnProductComparison() {
		productComparisonText.click();
		return new ComparePage();
	}

}
