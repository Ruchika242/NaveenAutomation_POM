package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.testbase.TestBase;

public class LoginPageTest extends TestBase{
	//Page Chaining concept says elements should be initialized immediately when the page loads. If we click on any button and then a new wepage gets open should return an object
	//of the page that is about to load and when that object will be returned ultimately const will be executed. so, elements of next page gets initialized.
	
	LoginPage login;
	AccountPage accountPage;
	
	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}
		
	@Test	
    public void validateUserIsAbleToLoginWithValidCred() {
		
    	accountPage =login.clickOnlogin("chaudharyruchika24@gmail.com", "Ravish@94");
    	Assert.assertEquals(wd.getTitle(), "My Account", "User not loggedIn");
    	
    	
    }
		
	
	@Test
	public void validateUserIsAbleToLoginWithInValidCred() {
		login.clickOnlogin("chaudharyruchika24@gmail.com", "Ravish@941");
		Assert.assertEquals(login.getAlertMsgText(), "Warning: No match for E-Mail Address and/or Password.", "User is not able to logged in");
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
