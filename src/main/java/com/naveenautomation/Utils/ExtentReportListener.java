package com.naveenautomation.Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.collections.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.naveenautomation.testbase.TestBase;

public class ExtentReportListener extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onStart(ITestContext testContext) {

	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String reportName = "My Account Portal" + "--------" + timestamp + ".html";
	
	sparkReporter=new ExtentSparkReporter("C:\\Users\\Deepak\\EC\\NaveenAutomation1\\Extent Reports\\" +
	reportName);
	try {
		sparkReporter.loadXMLConfig("C:\\Users\\Deepak\\EC\\NaveenAutomation1\\extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sparkReporter.config().setTheme(Theme.STANDARD);
	sparkReporter.config().setDocumentTitle("Extent Report");
	sparkReporter.config().setTimelineEnabled(true);
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	}

	@Override
	  public void onTestSuccess(ITestResult tr) {
		 test=extent.createTest(tr.getName());
		  test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

		
	   
	  }

	@Override
	  public void onTestFailure(ITestResult tr) {
		  test=extent.createTest(tr.getName());
		  test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  
	   
	  }

	@Override
	  public void onTestSkipped(ITestResult tr) {
		  test=extent.createTest(tr.getName());
		  test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	   
	  }

	@Override
	  public void onFinish(ITestContext testContext) {
	  extent.flush();//It will print the complete generated report
	  
  }

}

//It will helps in configuring the diff components of html report like where does the pie chart will display, what color 
// it have, where exactly test case will display. All this configuration you can
// do with this object.
// This object will build the report by picking up of all above info.
// Based on the result of test cases, we will mark this test object weather it
// was passed, suceess, failed.Then will assign some color code.

//