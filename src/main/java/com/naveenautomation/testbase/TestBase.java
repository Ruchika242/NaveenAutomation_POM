package com.naveenautomation.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class TestBase {

	public static WebDriver wd;
	private final String defaultBrowser = "CHROME";
	private final String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;

	@BeforeClass
	// We have initialized logger and every logger has a standard format like you
	// want to see in console or you want to save in file and see.
	// File should have name, location where saved,Max size of file, max no. of
	// files you need as backup,pattern of layout of file, what kind of pattern
	// timing for logging.
	// like year//month/day//hour//second.
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);// initialization
		PropertyConfigurator.configure("C:\\Users\\Deepak\\EC\\NaveenAutomation1\\log4j.properties");// Configured
		BasicConfigurator.configure();// Everything looks good, good to go
		logger.setLevel(Level.INFO);// set the level for which you want log, it has diff levels.
	}

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
		// Warp the instance
		e_driver = new EventFiringWebDriver(wd);

		// Events which needs to be captured from WebdriverEvents Class
		events = new WebdriverEvents();
		e_driver.register(events);

		// Assigning back the value to Web driver;
		wd = e_driver;

		wd.get(url);
		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void teardown() {
		wd.quit();
	}
	
	
	//I have created this method as static because it is not related to instance of the class because this is a util method and we can call it again and again
	public static void failedTestScreenshot(String testMethodName) {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshotFile, new File("./FailedTestCasesScreenshot\\" + "_" + testMethodName + ".jpg"));
			
		} catch (IOException e) {
			System.out.println("************The IO Exception is ************ " +e);
			e.printStackTrace();
		}
	}
}


//Where do we configure the Listener class?
//Ans..We configured inside testNG.xml..under the suite tag, we just create the Listeners Tag.
//Note: If we  run individual test cases....then you will not get the logs with all details you will get only basic logs in console...because e_driver is not configured inside testNG.xml...
//we are doing it with the webdriver directly... because anhything that will executed by testNG.xml... file will invoke the listener class otherwise it will not
  
//
