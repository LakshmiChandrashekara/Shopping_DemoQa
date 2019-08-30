package com.atmecs.demoqa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownProperty {

	public void selectDropDownText(WebDriver driver,String dropDownXpath, String dropDownText) {
		Select dropdown = new Select(driver.findElement(By.xpath(dropDownXpath)));  
		dropdown.selectByVisibleText(dropDownText); 
		
	}
}		
		
		
		
//		driver.findElement(By.xpath(dropDownXpath)).click();
//		WebElement testDropDown = driver.findElement(By.id("testingDropdown"));  
//		Select dropdown = new Select(testDropDown);
//		dropdown.selectByVisibleText(dropDownText); 


