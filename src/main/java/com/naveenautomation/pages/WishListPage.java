package com.naveenautomation.pages;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class WishListPage extends TestBase {
	
	public WishListPage() {
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(xpath ="//tr[.//a[text()='Apple Cinema 30\"']]//td[6]/a")
	WebElement removeBtnFromWishList;
	
	@FindBy(xpath="(//div[contains(normalize-space(),'Success: You have modified you')])[2]")
	WebElement msgOnRemovingProductFromWishlist;
	
	@FindBy(xpath="//a[text()='Continue']")
    WebElement continueBtnOnWishListPage;
	
	
	public void clickOnRemoveBtn() {
		removeBtnFromWishList.click();
	}
	
	public String getTextMsgOnRemovingProductFromWishlist() {
		return msgOnRemovingProductFromWishlist.getText();
	}
	
	public AccountPage clickOnContinueBtnOnWishListPage() {
		continueBtnOnWishListPage.click();
		return new AccountPage();
	}
}
