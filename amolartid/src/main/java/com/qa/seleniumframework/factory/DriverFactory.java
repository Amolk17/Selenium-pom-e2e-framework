package com.qa.seleniumframework.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.seleniumframework.errors.AppErrors;
import com.qa.seleniumframework.exceptions.FrameworkException;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	public OptionManager optionManager;

	
	public WebDriver initDriver(Properties prop) {
		String browser = prop.getProperty("browser");
	//	System.out.println("The browser name is " + browser);
		log.info("browser name: "+browser);
		optionManager = new OptionManager(prop);
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionManager.getChromeOption()));
			break;
		case "firefox":
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			break;
		default:
			//System.out.println(AppErrors.INVALID_BROWSER_MESSAGE);
			log.error(AppErrors.INVALID_BROWSER_MESSAGE);
			throw new FrameworkException("==== INVALID BROWSER======" + browser);
		}

//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("url"));

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		// return driver;
		return getDriver();
	}

	/**
	 * this method is used to get the local copy of the driver
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initialiseProp() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		return srcFile;
	}
}
