package com.naveenautomation.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductDetailsPage;
import com.naveenautomation.pages.ProductSearchPage;
import com.naveenautomation.pages.SuccessPage;
import com.naveenautomation.testbase.TestBase;

public class HomePageTest extends TestBase {

	private LoginPage login;
	private AccountPage accountPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkOutPage;
	private HomePage homePage;
	private SuccessPage successPage;
	

	@BeforeMethod
	public void launch() {
		initialization();
		homePage = new HomePage();
	}

	@Test
	public void validateUserIsAbleToSearchforSpecificProduct() {
		productSearchPage = homePage.enterProductNameInSearchBar("HP");
		String expectedProductText = "HP LP3065";
		softassert.assertEquals(productSearchPage.getTextHPLaptop(), expectedProductText,
				"There is no product that matches the search criteria.");
		System.out.println("This step will be executed");
		softassert.assertAll();

	}

	@Test
	public void validateUserIsAbleToPlaceOrder() {
		productSearchPage = homePage.enterProductNameInSearchBar("HP");
		productDetailsPage = productSearchPage.clickOnProduct();
		productDetailsPage.enterDeliveryDate("2026-04-04");
		productDetailsPage.clickOnAddtoCart();
		productDetailsPage.clickOnCartBtn();
		checkOutPage = productDetailsPage.clickOnCheckoutBtn();
		checkOutPage.clickOnLoginForCheckOut("chaudharyruchika3@gmail.com", "Sam@ira24");
		checkOutPage.clickOnNewAddressRadioBtn();
		checkOutPage.fillAndSubmitBillingDetails("Ruchi", "Ravish", "LagerFeld Dr", "Brampton", "L7A 5L1", "Canada",
				"Ontario");
		checkOutPage.addDeliveryDetails();
		checkOutPage.selectDeliveryMethod();
		checkOutPage.selectCheckBoxForPaymentMethod();
		checkOutPage.clickOnContinueBtnForPaymentMethod();
		successPage = checkOutPage.clickOnConfirmButton();

		String expectedTextOnOrderPlaced = "Your order has been placed!";
		softassert.assertEquals(successPage.textOnOrderPlaced(), expectedTextOnOrderPlaced, "Order Not Placed");
		softassert.assertAll();

	}

}
