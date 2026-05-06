package com.naveenautomation.PageTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.ForgottenPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductDetailsPage;
import com.naveenautomation.pages.ProductSearchPage;
import com.naveenautomation.pages.SuccessPage;
import com.naveenautomation.testbase.TestBase;

public class ForgottenTestPage extends TestBase {

	private LoginPage login;
	private AccountPage accountPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkOutPage;
	private HomePage homePage;
	private SuccessPage successPage;
	private ForgottenPage forgottenPage;

	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void validateUserIsAbleToChangeThePassword() {

		forgottenPage = login.clickOnForgotPwd("chaudharyruchika3@gmail.com");
		login = forgottenPage.enterEmailAddress("chaudharyruchika3@gmail.com");
		String expectedMsgOnForgotPwd = "An email with a confirmation link has been sent your email address.";
		softassert.assertEquals(login.getMsgTextOnForgotPwd(), expectedMsgOnForgotPwd, "Email Confirmation not sent");
		softassert.assertAll();

	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
