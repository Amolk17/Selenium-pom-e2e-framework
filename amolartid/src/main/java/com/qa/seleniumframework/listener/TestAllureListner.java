package com.qa.seleniumframework.listener;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.seleniumframework.factory.DriverFactory;

public class TestAllureListner implements ITestListener {
	
	//Text attachement for allure
	//@Attachment
	public File saveScreenshotPng(WebDriver driver) {
		//return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("On Start function: "+iTestContext.getName());
	}
	
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("On Start function: "+iTestContext.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(iTestResult.getMethod().getMethodName()+" succeed");
	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println(iTestResult.getMethod().getMethodName()+" is failed");
		Object testClass = iTestResult.getInstance();
		if(DriverFactory.getDriver() instanceof WebDriver) {
			System.out.println("Screenshot captured for test case "+iTestResult.getMethod().getMethodName()+" is failed");
			saveScreenshotPng(DriverFactory.getDriver());
		}
	}
	
	
	
	
}
