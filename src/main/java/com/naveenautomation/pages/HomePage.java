package com.naveenautomation.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class HomePage extends TestBase{
	
	public  HomePage()  {
		PageFactory.initElements(wd, this);

	}
	
	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement homePageText;
	
	
	public String getHomePageText() {
		return homePageText.getText();
	}
	
	
	
	
	
	

}
