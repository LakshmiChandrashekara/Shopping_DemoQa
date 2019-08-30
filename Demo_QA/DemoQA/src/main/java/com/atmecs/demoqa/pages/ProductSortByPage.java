package com.atmecs.demoqa.pages;

import java.util.Properties;

import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.GenerateLoggerReport;
import com.atmecs.demoqa.utils.LoadExcel;
import com.atmecs.demoqa.utils.LoadProperties;
import com.atmecs.demoqa.utils.SelectDropDownProperty;
import com.atmecs.demoqa.utils.Validation;

public class ProductSortByPage {
	
	
	
	String actualTitle, expectedTitle;
	LoadProperties loadProperties = new LoadProperties();
	LoadExcel loadExcel = new LoadExcel();
	Properties properties;
	Object[][] productData;
	Validation validation = new Validation();
	SelectDropDownProperty selectProperty = new SelectDropDownProperty();
	GenerateLoggerReport logger = new GenerateLoggerReport();
	
	{
		//properties = loadProperties.loadPropertiesFile(Constants.PRODUCT_SORT);
		productData = loadExcel.getData(Constants.PRODUCT_SORT, "Sheet1");
	}
	
	public Object[][] getSortData() {
		return productData;
		
	}

}
