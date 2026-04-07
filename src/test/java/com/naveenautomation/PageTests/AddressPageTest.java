package com.naveenautomation.PageTests;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddAddressPage;
import com.naveenautomation.pages.AddressPage;
import com.naveenautomation.pages.CategoryPage;
import com.naveenautomation.pages.EditPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsLetterPage;
import com.naveenautomation.pages.PasswordPage;
import com.naveenautomation.pages.ReturnPage;
import com.naveenautomation.pages.RightMenu;
import com.naveenautomation.pages.WishListPage;
import com.naveenautomation.testbase.TestBase;

public class AddressPageTest extends TestBase{
	

		private LoginPage login;
		private AccountPage accountPage;
		private EditPage editPage;
		private PasswordPage passwordPage;
		private ReturnPage returnPage;
		private NewsLetterPage newsLetterPage;
		private CategoryPage categoryPage;
		private WishListPage wishListPage;
		private AddressPage addressPage;
		private AddAddressPage addAddresspage;
		
		

		@BeforeMethod
		public void launch() {
			initialization();
			login = new LoginPage();
			
			
		}
		
		@Test
		public void validateUserIsAbleToAddNewAddress() {
			accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
			addressPage=accountPage.clickOnAddressBook();
			addAddresspage=addressPage.clickOnNewAddress();
			addressPage=addAddresspage.addAddressDetails("Sam", "Singh", "104", "Burlington", "L7A 5L3", "Canada", "Alberta");
			String expectedMsg= "Your address has been successfully added";
			softassert.assertEquals(addressPage.getTextOnAddressAdded(), expectedMsg, "Address not added");
			softassert.assertAll();
			
			
			
			
		}
		
		
	
	
	
	@Test
	public void validateUserIsAbleToRemoveAddress() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		addressPage=accountPage.clickOnAddressBook();
		addressPage.clickOnDeleteBtn();
		wd.switchTo().alert().accept();
		String expectedMsgOnDeletingAddress = "Your address has been successfully deleted";
		softassert.assertEquals(addressPage.getTextOnRemovingAddress(), expectedMsgOnDeletingAddress, "Address not deleted");
		softassert.assertAll();
		
		
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
