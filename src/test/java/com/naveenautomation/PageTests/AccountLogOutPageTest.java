package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLogoutPage;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.testbase.TestBase;

public class AccountLogOutPageTest extends TestBase {

	private LoginPage login;
	private AccountPage accountPage;
	private AccountLogoutPage accountLogoutPage;
	private HomePage homePage;

	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void userIsAbleToLogout() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		accountLogoutPage = accountPage.clickOnLogout();
		Assert.assertEquals(accountLogoutPage.getTextOfMsgAfterLogout(),
				"You have been logged off your account. It is now safe to leave the computer.", "User not logged Out");

	}

	@Test
	public void userIsAbleToLandOnHomePage() {
		userIsAbleToLogout();
		homePage = accountLogoutPage.clickContineBtn();
		Assert.assertEquals(homePage.getHomePageText(), "Desktops", "Not Landed");

	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
