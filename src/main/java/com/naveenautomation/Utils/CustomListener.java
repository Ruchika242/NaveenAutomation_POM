package com.naveenautomation.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.naveenautomation.testbase.TestBase;

public class CustomListener extends TestBase implements ITestListener{
	
	
	// result is the object where the result of test cases will be available after ruining the test
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(">>>>>>>>> Test Case Started  " +result.getMethod().getMethodName()+ ">>>>>>>>>>>>");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("*********Test Case Passed  " +result.getMethod().getMethodName()+ "*********Taking Screenshot*******");
	}

	@Override 
	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!Test Case Failed  " +result.getMethod().getMethodName()+ "!!!!!!!!!!");
		TestBase.failedTestScreenshot(result.getMethod().getMethodName());
	}

	@Override 
	 public void onTestSkipped(ITestResult result) {
		logger.info("???????????????????Test Case Skipped  " +result.getMethod().getMethodName()+ "???????????????????");
	}
	  
	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	  public void onStart(ITestContext context) {
	}

	@Override
	  public void onFinish(ITestContext context) {
	}

	

}
