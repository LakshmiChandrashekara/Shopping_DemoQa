package com.atmecs.demoqa.testscrpits;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.demoqa.helpers.ProductSortHelper;
import com.atmecs.demoqa.pages.ProductPage;

import com.atmecs.demoqa.testbase.Base;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadProperties;

public class ProductColorAndRangeFilterTest extends Base {
	
	ProductSortHelper sortHelper = new ProductSortHelper();
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
		//productData = sortHelper.getSortData();
		return productData;
	}

	@Test(dataProvider = "getProductData")
	public void navigateAndFilterBasedOnRange(String productColor, String sortProductBy) {
		sortHelper.filterTheProductsToBeSelected(driver, productColor, sortProductBy);
	}

}
