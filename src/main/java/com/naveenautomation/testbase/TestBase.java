package com.naveenautomation.testbase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Utils.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	public WebDriverWait wait;
	private final String defaultBrowser = "CHROME";
	private final String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static  Logger logger = LogManager.getLogger(TestBase.class);
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;
	
	

	protected SoftAssert softassert = new SoftAssert();

	@BeforeClass
	// We have initialized logger and every logger has a standard format like you
	// want to see in console or you want to save in file and see.
	// File should have name, location where saved,Max size of file, max no. of
	// files you need as backup,pattern of layout of file, what kind of pattern
	// timing for logging.
	// like year//month/day//hour//second.
	

	public void initialization() {
		switch (defaultBrowser) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false); // disable address popup
			wd = new ChromeDriver(options);

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
		
		e_driver = new EventFiringWebDriver(wd);
		

		// Events which needs to be captured from WebdriverEvents Class
		events = new WebdriverEvents();
		e_driver.register((WebDriverEventListener) events);

		// Assigning back the value to Web driver;
		wd = e_driver;
		wd.get(url);
		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	public void teardown() {
		wd.quit();
	}

	// I have created this method as static because it is not related to instance of
	// the class because this is a util method and we can call it again and again
	public static void failedTestScreenshot(String testMethodName) {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestCasesScreenshot\\" + "_" + testMethodName + ".jpg"));

		} catch (IOException e) {
			System.out.println("************The IO Exception is ************ " + e);
			e.printStackTrace();
		}
	}

	

	

	
}

//Where do we configure the Listener class?
//Ans..We configured inside testNG.xml..under the suite tag, we just create the Listeners Tag.
//Note: If we  run individual test cases....then you will not get the logs with all details you will get only basic logs in console...because e_driver is not configured inside testNG.xml...
//we are doing it with the webdriver directly... because anhything that will executed by testNG.xml... file will invoke the listener class otherwise it will not

//
