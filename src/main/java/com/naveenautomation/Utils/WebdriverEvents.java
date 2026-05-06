package com.naveenautomation.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebdriverEvents implements WebDriverEventListener {

    public static Logger logger = LogManager.getLogger(WebdriverEvents.class);

    // ===== Navigation =====
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Before navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("After navigating to: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {}
    @Override
    public void afterNavigateBack(WebDriver driver) {}

    @Override
    public void beforeNavigateForward(WebDriver driver) {}
    @Override
    public void afterNavigateForward(WebDriver driver) {}

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {}
    @Override
    public void afterNavigateRefresh(WebDriver driver) {}

    // ===== Find Element =====
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Finding element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Element found: " + by);
    }

    // ===== Click =====
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Before clicking on: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("After clicking on: " + element);
    }

    // ===== Alerts =====
    @Override
    public void beforeAlertAccept(WebDriver driver) {}
    @Override
    public void afterAlertAccept(WebDriver driver) {}

    @Override
    public void beforeAlertDismiss(WebDriver driver) {}
    @Override
    public void afterAlertDismiss(WebDriver driver) {}

    // ===== Input / Value Change =====
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {}
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {}

    // ===== Script =====
    @Override
    public void beforeScript(String script, WebDriver driver) {}
    @Override
    public void afterScript(String script, WebDriver driver) {}

    // ===== Exception Handling =====
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.error("Exception occurred: ", throwable);
    }

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
}
