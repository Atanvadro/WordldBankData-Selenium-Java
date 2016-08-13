package com.ok.selenium.util;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class AssertUtil {
	
	 @Rule
	 public ErrorCollector collector = new ErrorCollector();


	 public static void assertEquals(String message, String expected, String actual){
		 if (expected.equals(actual)){
			 Logger.logSUCCESS(message + " - passed");
		 }else{
			 Logger.logFAIL(message + " - failed");
			 Logger.logFAIL("Expected: " + expected + " Actual: " + actual);
		 }
	}

}
