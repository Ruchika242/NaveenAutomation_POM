package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.testbase.TestBase;

public class AccountPageTest extends TestBase {

	LoginPage login;
	AccountPage accountPage;
	EditPage editPage;

	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void validateUserIsAbleToUpdatePersonalInfo() {

		accountPage = login.clickOnlogin("chaudharyruchika24@gmail.com", "Ravish@94");
		editPage = accountPage.clickOnEditAccount();
		editPage.enterFirstName("Ruchi");
		accountPage = editPage.clickOnContinuebtn();

		Assert.assertEquals(accountPage.getTextOfSucessMsg(), "Success: Your account has been successfully updated.",
				"User is not able to update the personal info");

	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
