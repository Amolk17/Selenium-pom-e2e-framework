package com.qa.seleniumframework.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionManager {
	
	private Properties prop;
	private ChromeOptions co;
	
	public OptionManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		return co;
		
	}
}
