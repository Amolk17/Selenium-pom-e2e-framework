package com.qa.seleniumframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.seleniumframework.base.BaseTest;

public class AccoutPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test
	public void verifyAccountLinkExist() {
		Assert.assertTrue(accountPage.verifyLogoutLink());
	}
	
	@Test
	public void sendSearchText() {
		accountPage.searchContent();
	}
}
