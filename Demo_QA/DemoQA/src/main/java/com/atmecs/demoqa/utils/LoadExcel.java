package com.atmecs.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class LoadExcel {

	Workbook book;
	Sheet sheet;
	Object[][] data;
	
	public  Object[][] getData(String path, String sheetName)
	{
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		
		return data;
	}
}
