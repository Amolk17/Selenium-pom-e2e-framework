package com.qa.seleniumframework.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.seleniumframework.waitutils.WaitUtils;

public class ElementUtils {
	
	private WebDriver driver;
	
	public ElementUtils (WebDriver driver) {
		this.driver = driver;
	}
	
	public String waitForTitleIs(String expectedTitleValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleIs(expectedTitleValue));
		
		return driver.getTitle();
	}

	public String waitForURLContains(String fractionURLValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.urlContains(fractionURLValue));
		}catch(Exception e) {
			System.out.println("Expected value of : "+fractionURLValue+" not present");
		}
		return driver.getCurrentUrl();
	}
	
	public WebElement getElement(By locator) {
		WebElement ele = null;
		try {
			ele = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element not displayed on the page " + locator);
		}
		return ele;
	}
	
	public void doClick(By locator) {
		WaitUtils.waitForVisibilityOfElement(driver, locator);
		try {
			getElement(locator).click();
		} catch (NoSuchElementException e) {
			WaitUtils.waitForVisibilityOfElement(driver, locator);
			getElement(locator).click();
		}
	}
	
	public void fillInTextField(By locator, CharSequence... value) {
		WebElement ele = null;
		try {
			WaitUtils.waitForVisibilityOfElement(driver, locator);
			ele = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		ele.sendKeys(value);
	}
	
	public boolean verifyIfElementDisplayed(By locator) {
		WebElement ele = null;
		try {
			ele = driver.findElement(locator);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		WaitUtils.waitForVisibilityOfElement(driver, locator);
		return ele.isDisplayed();
		
	}
	

}
