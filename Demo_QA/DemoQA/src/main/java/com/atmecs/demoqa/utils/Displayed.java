package com.atmecs.demoqa.utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Displayed {

	boolean isDisplayed;
	
	public boolean isPropertyDisplayed(WebDriver driver, String productXpath) {
		
		isDisplayed = driver.findElement(By.xpath(productXpath)).isDisplayed();
		
		System.out.println("xpath for the product is: "+productXpath);
		if(isDisplayed)
			return true;
		else
			return false;
	}
	
}
