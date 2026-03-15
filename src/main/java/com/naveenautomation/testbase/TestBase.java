package com.naveenautomation.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//POM design pattern says that every webpage that exist on your application there will be corresponding
	//page class where you will identify all the elements and you will methods to perform actions over those webelements.
	//For each page class that resides in your project there will be coressponding test class where test cases will be written
	// and assertion will be performed.In this, we do some kind of abstraction between elements and test cases.

	public static WebDriver wd;
	private final String defaultBrowser = "CHROME";
	private final String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	public void initialization() {
		switch (defaultBrowser) {
		case "CHROME":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "FIREFOX":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new IllegalArgumentException();

		}
		wd.get(url);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void teardown() {
		wd.quit();
	}
}
