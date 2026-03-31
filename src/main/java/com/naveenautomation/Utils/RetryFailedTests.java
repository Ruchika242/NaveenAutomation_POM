package com.naveenautomation.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.testbase.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
	
	int count=1;
	int maxCount= 2;

	@Override
	//this method will invoke by TestNg whenver test will fail
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test +" +result.getMethod().getMethodName()+ 	"for" +count);
		
		if(count<maxCount) {
			count++;
			return true;
		}
		
		return false;
	}

}
