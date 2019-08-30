package com.atmecs.demoqa.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class GenerateLoggerReport {

	Logger log=null;

	public GenerateLoggerReport() {
	log = Logger.getLogger(GenerateLoggerReport.class.getName());
	getloggerConfig();
	}
	
	public void getloggerConfig() {
		PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES);
		}
	
	public void printLog(String message) {
		log.info(message);
	}
}
