package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_Amazon_005 extends TestBase{
	
	
	@Test(dataProvider="getData")
	public void userReg(String name, String emailid) throws InterruptedException {
		
		WebElement ele = AmazonOR.getAccountsandList();
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		
		AmazonOR.getStartHereLink().click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Thread.sleep(3000);
		Assert.assertEquals(title, "Amazon Registration");
		
		AmazonOR.getFirstNameTxtField().sendKeys(name);
		AmazonOR.getemailIdTxtField().sendKeys(emailid);
		Thread.sleep(3000);
		driver.navigate().back();
		
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		
		String xFile="D:\\Selenium Training\\Virtusa\\TestAutomation.LPIATBATCH71\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName="Sheet2";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount ;i++) {
			for(int j=0; j<cellCount; j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		
		return data;
		
	}

}
