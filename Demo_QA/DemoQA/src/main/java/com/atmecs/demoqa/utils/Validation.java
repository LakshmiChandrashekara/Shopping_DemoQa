package com.atmecs.demoqa.utils;

import org.testng.Assert;

public class Validation {

	GenerateLoggerReport generateLog = new GenerateLoggerReport();
	
	public void validateTitle(String actualTitle, String expectedTitle, String message) {
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			generateLog.printLog("PASSED: "+ message +" EXPECTED: "+ expectedTitle + " ACTUAL: "+ actualTitle);
		} catch (AssertionError assertionError) {
			generateLog.printLog("FAILED: "+ message +" EXPECTED: "+ expectedTitle + " ACTUAL: "+ actualTitle);
		  }
	}
	
	
	public void validateData(boolean isTrue, String message) {
		try {
			Assert.assertTrue(isTrue, message);
			generateLog.printLog("TEST PASSED");
		} catch(AssertionError assertionError) {
			generateLog.printLog("FAILED: "+ message);
		}		
	}
}
