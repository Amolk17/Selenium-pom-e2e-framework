package com.qa.seleniumframework.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.seleniumframework.factory.DriverFactory;
import com.qa.seleniumframework.listener.TestAllureListner;
import com.qa.seleniumframework.pages.AccountPage;
import com.qa.seleniumframework.pages.LoginPage;
import com.qa.seleniumframework.pages.RegistrationPage;
import com.qa.seleniumframework.pages.SearchResultPage;
import com.qa.seleniumframework.tests.AccoutPageTest;

@Listeners({TestAllureListner.class})
public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory driverfactory;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected SearchResultPage searchResultPageObj;
	protected Properties prop;
	protected RegistrationPage registrationPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(@Optional String browserName) {
		driverfactory = new DriverFactory();
		prop = driverfactory.initialiseProp();
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		driver = driverfactory.initDriver(prop); 
		loginPage = new LoginPage(driver);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
