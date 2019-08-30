package com.atmecs.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.demoqa.helpers.ProductPageHelper;
import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadExcel;

public class ProductPage {
	
	Object[][] data;
	LoadExcel loadExcel = new LoadExcel();
	ProductPageHelper productPagehelper = new ProductPageHelper();
	
	{
		data = loadExcel.getData(Constants.FILTER_PRODUCTS_XLSX, "Sheet1");
	}
	
	public void filterTheProductsToBeSelected(WebDriver driver, String productColor, String productMessage) {
		productPagehelper.navigateToFilterPage(driver);
		productPagehelper.selectProductColor(driver, productColor, productMessage);
		
	}
	
	public Object[][] getProductData() {
		return data;
	}
}
