package com.atmecs.demoqa.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.demoqa.helpers.HomePageHelper;
import com.atmecs.demoqa.testbase.Base;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadExcel;
import com.atmecs.demoqa.utils.LoadProperties;
import com.atmecs.demoqa.utils.Validation;

public class HomePage {

	Validation validation = new Validation();
	HomePageHelper homePageHelper = new HomePageHelper();
	Base base = new Base();
	LoadProperties loadProperties = new LoadProperties();
	LoadExcel loadExcel = new LoadExcel();
	Properties properties = new Properties();
	Object[][] productData;
	//WebDriver driver;
	boolean isDisplayed, isValid;
//	
//	{
//		driver = base.getDriver();
//		System.out.println("Driver in home page: "+driver);
//	}
	
//	{
//		System.out.println("Driver is: "+driver);
//	}
	
	
	public void isLogoDisplayed(WebDriver driver) {
		
		isDisplayed = homePageHelper.isLogoDisplayed(driver);
		validation.validateData(isDisplayed, "Logo is not displayed");
	}
	
	

	
	public void isProductDisplayed(WebDriver driver,String productImageLink, String productDiscrption, String productPrice, String productRatings) {
		isDisplayed = homePageHelper.isProductImageDisplayed(driver, productImageLink);
		validation.validateData(isDisplayed, "Image is not displayed");
		
		
		
		isDisplayed = homePageHelper.isProductDiscriptionDisplayed(driver, productDiscrption);
		validation.validateData(isDisplayed, "Disption is not displayed");
		if(isDisplayed) {
			isValid = homePageHelper.isProductDiscriptionValid(driver, productDiscrption);
			validation.validateData(isValid, "Invalid Product!!!!");
		}
		
		System.out.println("####################################################>>>>>>>>>>>>>>>>>>>>>>>>>>>>calling homepage !!!!!!!");
		//isDisplayed = homePageHelper.isProductPriceDisplayed(driver, productPrice);
		isDisplayed = homePageHelper.isProductPriceDisplayed(driver);
		validation.validateData(isDisplayed, "price is not displayed");
		if(isDisplayed) {
			//isValid = homePageHelper.isProductDiscriptionValid(driver, productPrice);
			isValid = homePageHelper.isProductPriceValid(driver, productPrice);
			validation.validateData(isValid, "Invalid Price!!!!");
		}
		
		
		isDisplayed = homePageHelper.isProductRatingDisplayed(driver, productRatings);
		validation.validateData(isDisplayed, "rating is not displayed");
		
		
	}
	
	public Object[][] getProductData() {
		productData = homePageHelper.getProductData();
		return productData;
	}
	
//	public int getTotalProducts(WebDriver driver) {
//		By elementsPresent = totalElements.getTotalWebElementsPresent(totalWebElementsPath,"totalCaseStudiesWebElements");
//		List<WebElement> links = driver.findElements(elementsPresent);
//		int count = links.size() ;
//		return count;
//	}
//	
}
