package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_Amazon_001 {
	
//	1. Open the browser
//	2. Launch URL
//	3. Select Books as category
//	4. Type Da vinci code in search input field
//	5. click the magnifier button
//	6. get all the items loaded relevant to search item
//	7. close the browser.



	public static void main(String[] args) throws InterruptedException {
		// 1. Open the browser
		
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		
		// 2. Launch URL
		driver.get("http://www.amazon.in/"); // Amazon page will be loaded.
		
		
		// 3. Select Books as category
		
		WebElement ele = driver.findElement(By.id("searchDropdownBox"));
		Select Category = new Select(ele);
		Category.selectByVisibleText("Books");
		
		
		// 4. Type Da vinci code in search input field
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Da Vinci Code");
		
		//5. click the magnifier button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(5000);
		
		boolean contains = driver.getTitle().contains("Da Vinci Code");
		
		if(contains) {
			System.out.println("The title of page has search term");
		}else {
			System.out.println("The title of the page do not have search term");
		}
		
		
		List<WebElement> allItems = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Total no. of items loaded are : " + allItems.size());
		
		for(WebElement item : allItems) {
			System.out.println(item.getText());
		}
		
		driver.close();
		
		

	}

}
