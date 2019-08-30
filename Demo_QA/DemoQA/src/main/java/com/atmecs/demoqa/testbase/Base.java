package com.atmecs.demoqa.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadProperties;
import com.atmecs.demoqa.utils.Validation;

public class Base {

	public WebDriver driver;
	public Properties properties;
	public String actual, expected;
	LoadProperties loadProperties = new LoadProperties();
	Validation validation = new Validation();
	
	/**
	 * This method will launch the required browser.
	 */
	public void launchBrowser() {
		properties = loadProperties.loadPropertiesFile(Constants.CONFIG_PROPERTIES);
		
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVE_EXE);
			driver = new ChromeDriver();
		} 
		
		else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_EXE);
			driver = new FirefoxDriver();
		}

		else if (properties.getProperty("browser").equalsIgnoreCase("internetExplorer")) {
			System.setProperty("webdriver.ie.driver",Constants.IE_DRIVER_EXE);
			driver = new InternetExplorerDriver();
		}
		
	}
	
	/**
	 * This method will open the specified URL in the browser.
	 */
	
	public void openURL(String url) {
		launchBrowser();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		System.out.println("driver in base class ie. openURl "+driver);
		actual = driver.getTitle();
		expected = actual;
		System.out.println("Page title is: "+actual);
		validation.validateTitle(actual, expected, "Not an specified page!!!!");
	}
	
	/**
	 * This method will quit the browser launched.
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
}
