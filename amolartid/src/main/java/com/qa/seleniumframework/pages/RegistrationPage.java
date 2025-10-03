package com.qa.seleniumframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.seleniumframework.constants.AppConstants;
import com.qa.seleniumframework.utils.ElementUtils;
import com.qa.seleniumframework.waitutils.WaitUtils;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtils = new ElementUtils(driver);
	}

	private By firstname = By.xpath("//input[@name='firstname']");
	private By lastname = By.xpath("//input[@name='lastname']");
	private By email = By.xpath("//input[@name='email']");
	private By telephone = By.xpath("//input[@name='telephone']");
	private By password = By .xpath("//input[@name='password']");
	private By confirmPassword = By.xpath("//input[@name='confirm']");
	private By subscribedYesBtn = By.xpath("(//label[@class = 'radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribedNoBtn = By.xpath("(//label[@class = 'radio-inline'])[position()=2]/input[@type='radio']");
	private By agreeCheckBox = By.name("agree");
	private By ContinueBtn = By.xpath("//input[@type = 'submit']");
	private By successMessage = By.cssSelector("div#content h1");
	
	

	public boolean userRegister(String firstName, String lastName, String email, String telephone, String password,String confirmPass,String subscribed) {
		eleUtils.fillInTextField(this.firstname, firstName);
		eleUtils.fillInTextField(lastname, lastName);
		eleUtils.fillInTextField(this.email, email);
		eleUtils.fillInTextField(this.telephone, telephone);
		eleUtils.fillInTextField(this.password, password);
		eleUtils.fillInTextField(confirmPassword, confirmPass);
		
		if(subscribed.equalsIgnoreCase("yes")) {
			eleUtils.doClick(subscribedYesBtn);
		}else {
			eleUtils.doClick(subscribedNoBtn);
		}
		
		eleUtils.doClick(agreeCheckBox);
		eleUtils.doClick(ContinueBtn);
		
		WaitUtils.waitForVisibilityOfElement(driver, successMessage);
		String successMessage = eleUtils.getElement(this.successMessage).getText();
		
		if(successMessage.contains(AppConstants.USER_REGISTRATION_SUCCESS_MESSAGE)) {
			return true;
		}else{
			return false;
		}
		
	}
}
