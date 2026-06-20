package com.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver = driver;
}

 @FindBy(id = "log_email")
WebElement email; 

 @FindBy(name = "log_password")
WebElement password;

 @FindBy(xpath = "//input[@name='log_submit']")
WebElement loginbtn;

//Create Method
public void Login_EasyCal(String name, String pass) throws Exception {
	email.sendKeys(name);
	password.sendKeys(pass);
	Thread.sleep(7000);
	loginbtn.click();
}
	

}
