package com.atmecs.demoqa.extendreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.demoqa.utils.Constants;
import com.atmecs.demoqa.utils.LoadExcel;

public class Demo {

	static int i = 4;
	
		LoadExcel excel = new LoadExcel();
		Object[][] data;
		//WebDriver driver;
		//System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVE_EXE);
		//driver = new ChromeDriver();
		//driver.get("http://shop.demoqa.com/");
		//String value = "("+"//span[@class='woocommerce-Price-amount amount'])"+"["+i+"]";
		//String price = driver.findElement(By.xpath(("//span[@class='woocommerce-Price-amount amount'])"+"["+i+"]"))).getText();
		//System.out.println("price is: "+value);
		
		@DataProvider
		public Object[][] test1() {
			data = excel.getData("C:\\Users\\Lakshmi.RC\\Assessment-2\\DemoQA\\resources\\testdata\\Demo2.xlsx", "Sheet1");
			return data;
		}
		
		@Test(dataProvider="test1")
		public void test(String number, String number1, String number2) {
			System.out.println("String data"+number);
			System.out.println("int data"+number1);
			System.out.println("double data"+number2);
		}
		
	}
	
	
	

