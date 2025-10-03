package com.qa.seleniumframework.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.seleniumframework.base.BaseTest;
import io.qameta.allure.*;

public class LoginPageTest extends BaseTest {
	
	@DataProvider
	public Object[][] getCreds() {
			return new Object[][]{
				{"march2024@open.com","Selenium@12345"}
			};
	}
	
	@Test
	public void loginPageTitleTest() {
		String pageTitle = loginPage.getPageTitle();
		Assert.assertEquals(pageTitle, "Account Login");
	}
	
	@Description("Login test")
	@Test(dataProvider = "getCreds")
	public void validateLogin(String userName,String password) {
		accountPage = loginPage.doLogin(userName,password);
		Assert.assertTrue(loginPage.isLogoutBtnExist());
	}
	
	@Description("Url validation")
	public void urlValidation() {
		loginPage.verifyPageUrl();
	}
}
