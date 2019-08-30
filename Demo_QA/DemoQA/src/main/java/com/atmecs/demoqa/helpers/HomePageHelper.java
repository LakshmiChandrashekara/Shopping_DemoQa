package com.atmecs.demoqa.helpers;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.demoqa.testbase.Base;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.Displayed;
import com.atmecs.demoqa.utils.LoadExcel;
import com.atmecs.demoqa.utils.LoadProperties;
import com.atmecs.demoqa.utils.Validation;

public class HomePageHelper {

	
	Validation validation;
	Displayed displayed = new Displayed();
	LoadProperties loadProperties = new LoadProperties();
	LoadExcel loadExcel = new LoadExcel();
	Properties properties = new Properties();
	int[] values = {4,5,6,8,9,11};
	int i=0;
	Object[][] productData;
	boolean isDisplayed;
	String productName;
	String addProductDiscrption = "";
	
	{
		
		properties = loadProperties.loadPropertiesFile(Constants.PRODUCT_HOME_PAGE_PROPERTIES);
		productData = loadExcel.getData(Constants.PRODUCTS_DATA_XLSX, "Sheet1");
	}
	
	
	public boolean isProductImageDisplayed(WebDriver driver, String productImageLink) {
		System.out.println("image displayed......");
		isDisplayed = displayed.isPropertyDisplayed(driver,"(//img[@src='"+productImageLink+"'])[1]");
			
			
		return isDisplayed;
	}
	
	
	public boolean isProductDiscriptionDisplayed(WebDriver driver, String productDiscrption) {
		System.out.println("product discrpition displayed......");
		String product_Discription = productDiscrption;
		String[] addProduct = product_Discription.split(" ");
		
		for(int i=0; i<addProduct.length; i++) {
			addProductDiscrption = addProductDiscrption+"_"+addProduct[i];
		}
		
		String product_path = properties.getProperty(addProductDiscrption);
		
		isDisplayed = displayed.isPropertyDisplayed(driver, product_path);
		
		//isDisplayed = displayed.isPropertyDisplayed(driver, productDiscrption);
		
		return isDisplayed;
	}
	
	
	public boolean isProductPriceDisplayed(WebDriver driver) {
		//public boolean isProductPriceDisplayed(WebDriver driver, String productPrice)
		System.out.println("price in helper calls displayed......");
		isDisplayed = displayed.isPropertyDisplayed(driver, properties.getProperty("PRODUCT_PRICE"));
		
		//isDisplayed = displayed.isPropertyDisplayed(driver, productPrice);
		
		return isDisplayed;
	}
	
	public boolean isProductRatingDisplayed(WebDriver driver, String productRatings) {
		System.out.println("rating displayed......");
		String rating = productRatings;
		String[] productRating = rating.split(" ");
		
		for(int i=0; i<productRating.length; i++) {
			addProductDiscrption = addProductDiscrption+"_"+productRating[i];
		}
		isDisplayed = displayed.isPropertyDisplayed(driver, properties.getProperty(addProductDiscrption));
		
		//isDisplayed = displayed.isPropertyDisplayed(driver, productRatings);
		
		return isDisplayed;
	}
	
	public boolean isProductDiscriptionValid(WebDriver driver,String productDiscrption) {
		System.out.println("valid product discription ");
//		String product_Discription = productDiscrption;
//		String[] addProduct = product_Discription.split(" ");
//		
//		for(int i=0; i<addProduct.length; i++) {
//			addProductDiscrption = addProductDiscrption+"_"+addProduct[i];
//		}
		
		String discription = driver.findElement(By.xpath(properties.getProperty(productDiscrption))).getText();
		
		if(productDiscrption.equalsIgnoreCase(discription))
			return true;
		
		return false;
			
	}
	
	
	
	public boolean isProductPriceValid(WebDriver driver, String price) {
		double product_price = Double.parseDouble(price);
		System.out.println("valid price discription ");
		String a = properties.getProperty("PRODUCT_PRICE")+"["+values[i]+"]";
		String priceValue = driver.findElement(By.xpath(properties.getProperty("PRODUCT_PRICE")+"["+values[i]+"]")).getText();
		
		System.out.println("######################################"+a);
		i++;
		double productPrice = Double.parseDouble(priceValue.substring(1));
		if(product_price==productPrice)
			return true;
		
		return false;
	}
	
	public boolean isLogoDisplayed(WebDriver driver) {
		isDisplayed = displayed.isPropertyDisplayed(driver, properties.getProperty("LOGO"));
		return isDisplayed;
	}

	
	public Object[][] getProductData() {
		return productData;
	}
	
	
//	
//	public boolean isProductPriceValid(WebDriver driver,String productPrice) {
//		double price = Double.parseDouble(productPrice);
//		String produce_price = driver.findElement(By.xpath("")).getText();
//	}
}
