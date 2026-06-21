package com.Framework.Pages;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utility.BrowserFactory;
import utility.ConfigureDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public utility.ExcelDataProvider excel;
	public ConfigureDataProvider config;
	
	@BeforeSuite
	public void Setup() throws FileNotFoundException {
		excel = new ExcelDataProvider();
		config = new ConfigureDataProvider();
	}
	@BeforeClass
	public void BrowserTest() {
		driver = BrowserFactory.BrowserOptions(driver, config.getBrowser(), config.getAppUrl());	
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.EndBrowser(driver);
		
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.capturedScreenShot(driver);
		}
	}
	
}
