package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ComparePage extends TestBase {
	public ComparePage() {
		PageFactory.initElements(wd, this);
		
	}
	
	
	
	public String getTextOfSummaryOfComParedProduct(String headingName) {
		List<WebElement> noOfRows= wd.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr"));
		for (int i = 1; i < noOfRows.size(); i++) {
			 List<WebElement> cols = noOfRows.get(i).findElements(By.tagName("td"));

		        if (cols.size() > 1 && cols.get(0).getText().equalsIgnoreCase(headingName)) {
		            return cols.get(1).getText();
		        }
		    }

		    return null;
			
			
			
		}
		
		
	}
	


