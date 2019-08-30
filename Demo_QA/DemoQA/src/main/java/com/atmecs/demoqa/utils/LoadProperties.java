package com.atmecs.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public Properties loadPropertiesFile(String path) {
		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(path);
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
