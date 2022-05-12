package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase{

	// Total no items present in the category list box.

	@Test(priority=1)
	public void getCategoryList() {

		Select category = AmazonOR.getCategory();
		List<WebElement> allItems = category.getOptions();
		System.out.println("Total no. of items present in the category list are : " +  allItems.size());
		Assert.assertEquals(allItems.size(), 45);
	}

	@Test(priority=2,dependsOnMethods="getCategoryList")
	public void getAllItems() {
		Select category = AmazonOR.getCategory();
		List<WebElement> allItems = category.getOptions();
		for(WebElement item:allItems) {
			Reporter.log(item.getText(),true);
		}
	}

}
