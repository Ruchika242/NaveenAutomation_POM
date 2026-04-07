package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductDetailsPage;
import com.naveenautomation.pages.ProductSearchPage;
import com.naveenautomation.testbase.TestBase;

public class LoginPageTest extends TestBase {
	// Page Chaining concept says elements should be initialized immediately when
	// the page loads. If we click on any button and then a new wepage gets open
	// should return an object
	// of the page that is about to load and when that object will be returned
	// ultimately const will be executed. so, elements of next page gets
	// initialized.

	private LoginPage login;
	private AccountPage accountPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkOutPage;
	private HomePage homePage;
	

	@BeforeMethod
	public void launch() {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void validateUserIsAbleToLoginWithValidCred() {

		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Sam@ira24");
		Assert.assertEquals(wd.getTitle(), "My Account", "User not loggedIn");

	}

	@Test
	public void validateUserIsAbleToLoginWithInValidCred() {
		accountPage = login.clickOnlogin("chaudharyruchika3@gmail.com", "Ravish@941");
		Assert.assertEquals(login.getAlertMsgText(), "Warning: No match for E-Mail Address and/or Password.",
				"User is not able to logged in");

	}

	@Test(dataProvider = "UserCredentials")
	public void validateLoginWithMultipleCredentials(String userName, String password) {
		accountPage = login.clickOnlogin(userName, password);
		Assert.assertEquals(wd.getTitle(), "My Account", "User not loggedIn");

	}

	@DataProvider(name = "UserCredentials")
	public String[][] getDataFromExcelSheet() throws Exception {
		logger.info("Reading from DataProvider");
		String fileName = "C:\\Users\\Deepak\\Desktop\\LoginCredentials.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		// System.out.println("Row Count :" + rowCount);

		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		// System.out.println("Cell Count: " +cellCount);

		String cellValue = ExcelUtils.getCellData(fileName, sheetName, rowCount, cellCount);

		// System.out.println(cellValue);

		String[][] virtualSheet = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j);// Populating the array into
																							// virtualsheet....
			}

		}

		return virtualSheet;
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

	
	
	
	
	

}

//HP LP3065
