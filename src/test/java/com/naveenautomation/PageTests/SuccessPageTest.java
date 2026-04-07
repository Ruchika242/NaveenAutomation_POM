package com.naveenautomation.PageTests;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

public class SuccessPageTest extends TestBase  {
	
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
		successPage = new SuccessPage();
	}
	
	
	
	}
	
	
	
	

