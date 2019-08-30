package com.atmecs.demoqa.helpers;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.GenerateLoggerReport;
import com.atmecs.demoqa.utils.LoadExcel;
import com.atmecs.demoqa.utils.LoadProperties;
import com.atmecs.demoqa.utils.SelectDropDownProperty;
import com.atmecs.demoqa.utils.Validation;

public class ProductSortHelper {

	String actualTitle, expectedTitle;
	Validation validation = new Validation();
	LoadProperties loadProperties = new LoadProperties();
	LoadExcel loadExcel = new LoadExcel();
	Properties properties;
	
	{
		properties = loadProperties.loadPropertiesFile(Constants.PRODUCT_SORT_BY_RANGE);
	}
	
	
	public void navigateToFilterPage(WebDriver driver) {
		driver.findElement(By.xpath(properties.getProperty("3"))).click();
		actualTitle = driver.getTitle();
		expectedTitle = "Products – Page 3 – ToolsQA Demo Site";
		validation.validateTitle(actualTitle, expectedTitle, "invalid page!!!!");

	}

	
	
	public void filterTheProductsToBeSelected(WebDriver driver, String productColor, String sortProductBy) {
		
		
		
	}
}
