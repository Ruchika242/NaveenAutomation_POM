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
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.ComparePage;
import com.naveenautomation.pages.EditPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsLetterPage;
import com.naveenautomation.pages.PasswordPage;
import com.naveenautomation.pages.ProductDetailsPage;
import com.naveenautomation.pages.ProductSearchPage;
import com.naveenautomation.pages.ReturnPage;
import com.naveenautomation.pages.RightMenu;
import com.naveenautomation.pages.SuccessPage;
import com.naveenautomation.pages.WishListPage;
import com.naveenautomation.testbase.TestBase;


public class ComparePageTest extends TestBase {
	private LoginPage login;
	private AccountPage accountPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkOutPage;
	private HomePage homePage;
	private SuccessPage successPage;
	private ComparePage comparePage;
	private CategoryPage categoryPage;
	
	
	@BeforeMethod
	public void launch() {
		initialization();
		homePage = new HomePage();
	}
	
	
	@Test
	public void validateSummaryOfComparedProduct() {
		categoryPage=homePage.clickOnCamerasCategory();
		categoryPage.clickOnCompareIcon();
		comparePage=categoryPage.clickOnProductComparison();
		String actualSummary=comparePage.getTextOfSummaryOfComParedProduct("Summary");
		softassert.assertTrue(actualSummary.contains("Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category"));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
