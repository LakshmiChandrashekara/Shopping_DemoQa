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

public class ProductPageHelper {

	String actualTitle, expectedTitle;
	LoadProperties loadProperties = new LoadProperties();
	LoadExcel loadExcel = new LoadExcel();
	Properties properties;
	Object[][] productData;
	Validation validation = new Validation();
	SelectDropDownProperty selectProperty = new SelectDropDownProperty();
	GenerateLoggerReport logger = new GenerateLoggerReport();
	
	{
		properties = loadProperties.loadPropertiesFile(Constants.PRODUCTS_PAGE_PROPERTIES);
	}
	
	
	public void navigateToFilterPage(WebDriver driver) {
		driver.findElement(By.xpath(properties.getProperty("3"))).click();
		actualTitle = driver.getTitle();
		expectedTitle = "Products – Page 3 – ToolsQA Demo Site";
		validation.validateTitle(actualTitle, expectedTitle, "invalid page!!!!");

	}

	public void selectProductColor(WebDriver driver,String productColor,String productMessage) {
		selectProperty.selectDropDownText(driver, properties.getProperty("selectFromDropDown"), productColor);
		actualTitle = driver.getTitle();
		expectedTitle = "Page not found – ToolsQA Demo Site";
		validation.validateTitle(actualTitle, expectedTitle, "invalid page!!!!");
		String message = driver.findElement(By.xpath(properties.getProperty("getErrorText"))).getText();
		if(productMessage.equalsIgnoreCase(message))
			logger.printLog("Currently produts are unavailable!!!!!!");
			validation.validateData(true,"filtered failed!!!!");
		
	}
	
}
