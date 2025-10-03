package com.qa.seleniumframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.seleniumframework.constants.AppConstants;
import com.qa.seleniumframework.utils.ElementUtils;
import com.qa.seleniumframework.waitutils.WaitUtils;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils elementUtilObj;
	//private WaitUtils waitUtils;
	
	
	private final By emailId = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value = 'Login']");
	private final By forgottonLink = By.linkText("Forgotten Password");
	private final By LOGOUT_BTN = By.linkText("Logout");
	private final By REGISTER_LINK = By.linkText("Register");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtilObj = new ElementUtils(driver);
		//waitUtils = new WaitUtils();
	}

	public String getPageTitle() {
		String title = elementUtilObj.waitForTitleIs(AppConstants.LOGIN_PAGE_TITEL, AppConstants.DEFAULT_SHORT_WAIT);
		System.out.println("Login page title "+title);
		return title;
 	}
	
	public String verifyPageUrl() {
		return elementUtilObj.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_WAIT);
	}

	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgottonLink).isDisplayed();
	}
	
	public boolean isLogoutBtnExist() {
		return driver.findElement(LOGOUT_BTN).isDisplayed();
	}
	
	
	//WHENEVER METHOD CAUSES TO LAND ON NEW PAGE, THAT METHOD SHOLD RETURN NEW PAGE'S OBJECT
	public AccountPage doLogin(String appUsername, String appPassword) {
		elementUtilObj.getElement(emailId).sendKeys(appUsername);
		elementUtilObj.getElement(password).sendKeys(appPassword);
		elementUtilObj.getElement(loginBtn).click();
		return new AccountPage(driver);
	}
	
	public RegistrationPage navigateToRegisterPage() {
		WaitUtils.waitForVisibilityOfElement(driver, REGISTER_LINK);
		elementUtilObj.getElement(REGISTER_LINK).click();;
		return new RegistrationPage(driver);
	}
}
