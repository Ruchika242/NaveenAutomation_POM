package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.naveenautomation.testbase.TestBase;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccText;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccInfo;

	@FindBy(css = "div.alert-success")
	WebElement successMsgOnUpdatingInfo;

	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logoutBtn;
	
	@FindBy(xpath="//a[text()='Password']")
	WebElement passwordChange;
	
	@FindBy(xpath ="//div[text()=' Success: Your password has been successfully updated.']")
	WebElement sucessMsgOnChangingPassword;
	
	@FindBy(xpath = "(//a[text()='Returns'])[1]")
	WebElement returns;
	
	@FindBy(xpath = "(//a[text()='Newsletter'])[1]")
	WebElement newsLetter;
	
	@FindBy(xpath=" //div[text()=' Success: Your newsletter subscription has been successfully updated!']")
	WebElement successMsgOnUpdatingSubscription;
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="(//a[text()='Order History'])[1]")
	WebElement orderHistoryText;
	
	
	@FindBy(xpath="//a[text()='Desktops']")
	WebElement desktopElement;
	
	@FindBy(xpath="//a[text()='Show All Desktops']")
	WebElement showAllDesktopsElement;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Address Book']")
	WebElement addressBook;

	@FindBy(xpath = "//div[@class='list-group']")
	List<WebElement> allMenuOptions;
	
	public Object  selectOptionFromMenu(RightMenu menu) {
		for (WebElement opt : allMenuOptions) {
			if (opt.getText().trim().equalsIgnoreCase(menu.getValue())) {
				opt.click();
				
				switch (menu) {
				  case MYACC:
					return new  AccountPage() ;
					
				  case EDIT:
					  return new EditPage();
					  
				  case PWD:
					  return new PasswordPage();
				
				 
				  case ADDBOOK:
					  return new AddressPage();
					  
					  
				  case WISHLIST:
					  return new WishListPage();
					  
				  case ORDERHISTORY:
					  return new OrderPage();
					    
				  case DOWNLOAD:
					  return new DownloadPage();
					  
					  
				  case RECURRINGPAYMENT:
					  return new RecurringPage();
					  
					  
				  case REWARDS:
					  return new RewardsPage();
					  
				  case RETURN:
					  return new ReturnPage();
					  
				  case TRANSACTION:
					  return new TransactionPage();
					  
				  case NEWSLETTER:
					  return new NewsLetterPage();
					  
				  default:
	                    throw new IllegalArgumentException("Invalid menu option");
				  
					
				}
			}
		}
		throw new RuntimeException("Menu option not found: " + menu);
	}

	public String getTextOfMyAccountPage() {
		return myAccText.getText();
	}

	public EditPage clickOnEditAccount() {
		editAccInfo.click();
		return new EditPage();
	}

	public String getTextOfSucessMsg() {
		return successMsgOnUpdatingInfo.getText();
	}

	public AccountLogoutPage clickOnLogout() {
		logoutBtn.click();
		return new AccountLogoutPage();

	}
	
	public PasswordPage clickOnPassword() {
		passwordChange.click();
		return new PasswordPage();
	}
	
	public String getTextOfSuccessMsgOnChangingThePwd() {
		return sucessMsgOnChangingPassword.getText();
	}
	
	public ReturnPage clickOnReturns() {
		returns.click();
		return new ReturnPage();
	}
	
	public NewsLetterPage clickOnNewsLetter() {
		newsLetter.click();
		return new NewsLetterPage();
		
	}
	
	public String getTextOfSuccessMsgOnUpdatingTheSubscription() {
		return successMsgOnUpdatingSubscription.getText();
		
	}
	
	public OrderPage getOrderHistory() {
		myAccount.click();
		orderHistoryText.click();
		return new OrderPage();
		
		}
	
	public void clickOnDesktopElement() {
		desktopElement.click();
		
		
		
	}
	
	public CategoryPage clickOnShowAllItems() {
		showAllDesktopsElement.click();
		return new CategoryPage();
	}
	
	public AddressPage clickOnAddressBook() {
		addressBook.click();
		return new AddressPage();
	}

}
