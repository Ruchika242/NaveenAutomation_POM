package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.PasswordPage;
import com.naveenautomation.testbase.TestBase;

public class AccountPageTest extends TestBase {

	LoginPage login;
	AccountPage accountPage;
	EditPage editPage;
	PasswordPage passwordPage;

	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void validateUserIsAbleToUpdatePersonalInfo() {

		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		editPage = accountPage.clickOnEditAccount();
		editPage.enterFirstName("Ruchika");
		accountPage = editPage.clickOnContinuebtn();

		Assert.assertEquals(accountPage.getTextOfSucessMsg(), "Success: Your account has been successfully updated.",
				"User is not able to update the personal info");

	}
	
	
	@Test
	public void validateUserIsAbleToChangePassword() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Ravish@94");
		passwordPage= accountPage.clickOnPassword();
		passwordPage.enterNewPassword("Sam@ira24", "Sam@ira24");
		accountPage=passwordPage.clickOnBtnPwdPage();
		Assert.assertEquals(accountPage.getTextOfSuccessMsgOnChangingThePwd(), "Success: Your password has been successfully updated.", "Not able to change Password");
		
		
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
