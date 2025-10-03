package com.qa.seleniumframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.seleniumframework.utils.ElementUtils;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtils = new ElementUtils(driver);
	}

	private final By searchInSubCategories = By.xpath("//input[@name = 'sub_category']");
	
	public boolean verifyUserLandedOnSearchPage() {
		boolean isElementDisplayed = eleUtils.verifyIfElementDisplayed(searchInSubCategories);
		return isElementDisplayed;
	}

}
