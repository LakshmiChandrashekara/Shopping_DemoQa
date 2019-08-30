package com.atmecs.demoqa.utils;

import java.io.File;

public class Constants {

	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir") + File.separator;

	public final static String LIBRARY_HOME = PROJECT_BASE_PATH + "lib" + File.separator ;
	public final static String RESOURCES_HOME = PROJECT_BASE_PATH + "resources" + File.separator;
	public final static String LOCATERS_HOME = RESOURCES_HOME + "locaters" + File.separator;
	public final static String LOG4J_HOME = RESOURCES_HOME + "log4j" + File.separator;
	public final static String SUITES_HOME = RESOURCES_HOME + "suites" + File.separator;
	public final static String TEST_DATA_HOME = RESOURCES_HOME + "testdata" + File.separator;
	
	public final static String CONFIG_PROPERTIES = RESOURCES_HOME + "config.properties";
	public final static String LOG4J_PROPERTIES = LOG4J_HOME + "log4j.properties";
	
	public final static String CHROME_DRIVE_EXE = LIBRARY_HOME + "chromedriver.exe";
	public final static String FIREFOX_DRIVER_EXE = LIBRARY_HOME + "geckodriver.exe";
	public final static String IE_DRIVER_EXE =  LIBRARY_HOME + "IEDriverServer.exe";
	
	public final static String PRODUCTS_DATA_XLSX = TEST_DATA_HOME + "ProductsData.xlsx";
	public final static String CHECKOUT_FORM_DATA_XLSX = TEST_DATA_HOME + "CheckoutFormData.xlsx";
	
	public final static String PRODUCT_HOME_PAGE_PROPERTIES = LOCATERS_HOME + "productsInHomePage.properties";
	
	public final static String PRODUCTS_PAGE_PROPERTIES = LOCATERS_HOME + "productsPage.properties";
	
	public final static String PRODUCT_SORT_BY_RANGE = LOCATERS_HOME + "ProductSortByRange.properties";
	public final static String FILTER_PRODUCTS_XLSX = TEST_DATA_HOME + "FilterProducts.xlsx";
	public final static String PRODUCT_SORT = TEST_DATA_HOME + "ColorAndSort.xlsx";
	
	public final static long PAGE_LODE_TIMEOUT = 30;
	public final static long IMPLICIT_WAIT = 20;
	
	
}
