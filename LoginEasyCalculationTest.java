package com.Framework.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.pages.BaseClass;
import com.Framework.pages.LoginPage;

import utility.ExcelDataProvider;
import utility.Helper;

public class LoginEasyCalculationTest extends BaseClass {
	
	
	@Test
	public void LoginTest() throws Exception {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		excel.getStringData("sheet1", 0, 0);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.LoginEasyCalculation(excel.getStringData("sheet1", 0, 0),excel.getStringData("sheet1", 0, 1));
		Thread.sleep(10000);
	
	}
	

}

