package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;



public class TC_Amazon_002 extends TestBase{


	@Test(dataProvider="getData")
	public void searchItem(String Category, String ItemName) throws IOException {
		

		AmazonOR.getCategory().selectByVisibleText(Category); // 1st field --> Category
		AmazonOR.getSearchTxtField().clear();
		AmazonOR.getSearchTxtField().sendKeys(ItemName); // 2nd field --> Item Name
		AmazonOR.getMagnifierBtn().click();

		// what is the title needs an extra time to be generated.
		
		
		expWait.until(ExpectedConditions.titleContains(ItemName)); // Wait till the title has the value max for 40 seconds
		
		
		boolean contains = driver.getTitle().contains(ItemName);

		if(contains) {
			Reporter.log("The title of page has search term",true);
			//Assert.assertTrue(contains);
			sAssert.assertTrue(contains);
		}else {
			captureScreenshot(driver,"searchItem");
			Reporter.log("The title of the page do not have search term",true);
			//Assert.assertTrue(contains);
			sAssert.assertTrue(contains);
		}
		List<WebElement> getallItems = AmazonOR.getallItems();

		System.out.println("Total no. of items loaded are : " + getallItems.size());
		for(WebElement item:getallItems) {
			Reporter.log(item.getText(),true);
		}
		
		sAssert.assertAll();
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String xFile="D:\\Selenium Training\\Virtusa\\TestAutomation.LPIATBATCH71\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName="Sheet1";
		
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
