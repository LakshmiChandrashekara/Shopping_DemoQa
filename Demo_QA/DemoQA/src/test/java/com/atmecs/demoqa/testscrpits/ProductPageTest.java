package com.atmecs.demoqa.testscrpits;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.demoqa.pages.ProductPage;
import com.atmecs.demoqa.testbase.Base;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadProperties;

public class ProductPageTest extends Base {

	public LoadProperties loadProperties = new LoadProperties();
	public Properties properties;
	ProductPage productPage = new ProductPage();
	Object[][] productData;
	
	@BeforeClass
	public void setUp() {
		properties = loadProperties.loadPropertiesFile(Constants.CONFIG_PROPERTIES);
		openURL(properties.getProperty("productPageURL"));
		
	}
	
	
	@DataProvider
	public Object[][] getProductData() {
		productData = productPage.getProductData();
		return productData;
	}
	
	@Test(dataProvider = "getProductData")
	public void navigateAndFilter(String productColor, String productMessage) {
		productPage.filterTheProductsToBeSelected(driver, productColor, productMessage);
	}
	
//	@AfterClass
//	public void tearDown() {
//		closeBrowser();
//	}
}
