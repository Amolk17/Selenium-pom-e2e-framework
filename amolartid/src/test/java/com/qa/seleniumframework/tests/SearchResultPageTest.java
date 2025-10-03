package com.qa.seleniumframework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.seleniumframework.base.BaseTest;

public class SearchResultPageTest extends BaseTest {
	
	@BeforeClass
	public void searchSetUp() {
		accountPage = loginPage.doLogin("march2024@open.com","Selenium@12345");
	}
	
	@Test
	public void verifyLandingOnSearchPage_Test() {
		searchResultPageObj = accountPage.searchContent();
		Assert.assertTrue(searchResultPageObj.verifyUserLandedOnSearchPage());
	}
}
