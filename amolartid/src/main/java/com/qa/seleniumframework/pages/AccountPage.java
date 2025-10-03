package com.qa.seleniumframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.seleniumframework.utils.ElementUtils;
import com.qa.seleniumframework.waitutils.WaitUtils;

public class AccountPage {
	
	WebDriver driver;
	ElementUtils elementUtilsObj;
	
	private final By logoutLink = By.linkText("Logout");
	private final By searchInputBox = By.xpath("//div[@id = 'search']/input");
	private final By searchInputBoxButton = By.xpath("//div[@id = 'search']//span/button");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtilsObj = new ElementUtils(driver);
	}
	
	public boolean verifyLogoutLink() {
		return driver.findElement(logoutLink).isDisplayed();
	}

	public SearchResultPage searchContent() {
		WaitUtils.waitForVisibilityOfElement(driver, searchInputBox);
		elementUtilsObj.fillInTextField(searchInputBox, "Macbook");
		elementUtilsObj.doClick(searchInputBoxButton);
		return new SearchResultPage(driver);
	}
}
