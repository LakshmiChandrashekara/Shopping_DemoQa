package com.atmecs.demoqa.testscrpits;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.demoqa.pages.HomePage;
import com.atmecs.demoqa.testbase.Base;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadProperties;


public class HomePageTest extends Base {

public Properties properties;
	
	LoadProperties loadProperties = new LoadProperties();
	HomePage homePage = new HomePage();
	
	
	Object[][] productData;
	
	@BeforeClass
	public void setUp() {
		
		properties = loadProperties.loadPropertiesFile(Constants.CONFIG_PROPERTIES);
		openURL(properties.getProperty("baseUrl"));
		
	}
	
	
	@DataProvider
	public Object[][] getProductPropertiesData() {
		productData = homePage.getProductData();
		return productData;
	}

	
	@Test(priority=2)
	public void isLogoDisplayedTest() {
		homePage.isLogoDisplayed(driver);
	}
	
	@Test(dataProvider = "getProductPropertiesData", priority=3)
	public void isProductDisplayedTest(String productImageLink, String productDiscrption, String productPrice, String productRatings) {
		homePage.isProductDisplayed(driver,productImageLink, productDiscrption, productPrice, productRatings);
	}
	
//	@AfterClass
//	public void tearDown() {
//		base.closeBrowser();
//	}
	
}
