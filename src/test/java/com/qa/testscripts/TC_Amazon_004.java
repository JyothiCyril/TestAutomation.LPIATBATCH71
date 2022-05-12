package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_004 extends TestBase{

	// Search Text field is present or not on the home page
	
	@Test	
	public void checkFieldExists() {			
				
	//	expWait.until(ExpectedConditions.presenceOfElementLocated(By.id(""));
		boolean displayed = AmazonOR.getSearchTxtField().isDisplayed();
		
		if(displayed) {
			Reporter.log("Search text field is present on the page",true);
			Assert.assertTrue(displayed);
		}else {
			Reporter.log("Search text field is not present on the page",true);
			Assert.assertTrue(displayed);
		}
		
	}

}
