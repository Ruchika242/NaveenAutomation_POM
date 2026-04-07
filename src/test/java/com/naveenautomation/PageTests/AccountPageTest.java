package com.naveenautomation.PageTests;

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


public class AccountPageTest extends TestBase {

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

	@Test(priority = 2)
	public void validateUserIsAbleToUpdatePersonalInfo() {

		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		editPage = accountPage.clickOnEditAccount();
		editPage.enterFirstName("Ruchi");
		accountPage = editPage.clickOnContinuebtn();
		String expectedMsgOnUpdatingInfo = "Success: Your account has been successfully updated.";
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(accountPage.getTextOfSucessMsg(), expectedMsgOnUpdatingInfo,
				"User is not able to update the personal info");
		System.out.println("This step will be executed");
		softassert.assertAll();

	}

	@Test(enabled = false)
	public void validateUserIsAbleToChangePassword() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		passwordPage = accountPage.clickOnPassword();
		passwordPage.enterNewPassword("Sam@ira24", "Sam@ira24");
		accountPage = passwordPage.clickOnBtnPwdPage();
		String expectedMsg = "Success: your password has been successfully updated.";
		Assert.assertEquals(accountPage.getTextOfSuccessMsgOnChangingThePwd(), expectedMsg,
				"Not able to change Password");

	}

	@Test(priority = 1)
	public void validateUserIsAbleToViewReturns() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		returnPage = accountPage.clickOnReturns();
		Assert.assertEquals(returnPage.messageForNoReturns(), "You have not made any previous returns!",
				"Not able to view the returns");

	}

	@Test(priority = 3)
	public void validateUserIsAbleToSubscribe() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		newsLetterPage = accountPage.clickOnNewsLetter();
		accountPage = newsLetterPage.clickOnYesRadioButton();
		String expectedMsgOnUpdatingSubscription = "Success: Your newsletter subscription has been successfully updated!";
		Assert.assertEquals(accountPage.getTextOfSuccessMsgOnUpdatingTheSubscription(),
				expectedMsgOnUpdatingSubscription, "Not able to update the subscription");
		System.out.println("This line will not be executed");

	}
	
	@Test
	public void userIsAbleToCheckOrderHistory() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		accountPage.getOrderHistory();
		
	}
	
	@Test
	public void validateUserIsAbleToAddProductInWishList() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		accountPage.clickOnDesktopElement();
		categoryPage=accountPage.clickOnShowAllItems();
		categoryPage.clickOnProductWishlistButton();
		String expectedMsg = "Success: You have added Apple Cinema 30\" to your wish list!";
		softassert.assertEquals(categoryPage.getTextMsgOnAddingProductInWishList(), expectedMsg, "Product Not Added in Wishlist");
		softassert.assertAll();
		
	}
	
	@Test
	public void validateUserIsAbleToRemoveProductInWishList() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		accountPage.clickOnDesktopElement();
		categoryPage=accountPage.clickOnShowAllItems();
		categoryPage.clickOnProductWishlistButton();
		wishListPage = categoryPage.clickOnWishListButton();
		wishListPage.clickOnRemoveBtn();
		//SString expectedMsg= "Success: You have modified your wish list!";
		//softassert.assertEquals(wishListPage.getTextMsgOnRemovingProductFromWishlist(), expectedMsg, "Product not removed from wishlist");
		accountPage=wishListPage.clickOnContinueBtnOnWishListPage();
		
		
		
	}
	
	
	

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
