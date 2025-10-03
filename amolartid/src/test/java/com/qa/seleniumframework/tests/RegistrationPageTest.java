package com.qa.seleniumframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.seleniumframework.base.BaseTest;
import com.qa.seleniumframework.utils.ExcelUtils;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void navigateToRegistrationPage() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegSheetData() {
		return ExcelUtils.getTestData("register");
	}

//	@Test
//	public void registerTest() {
//		Assert.assertTrue(registrationPage.userRegister("tom", "automation", "tom@gamil.com", "9999999999", "tome@123", "tome@123", "yes"));
//	}
	
	@Test(dataProvider = "getRegSheetData")
	public void registerTest(String firstname, String lastname, String email, String phonenumber, String password, String confirmPass, String confirm) {
		Assert.assertTrue(registrationPage.userRegister(firstname, lastname, email, phonenumber, password, confirmPass, confirm));
	}
}

