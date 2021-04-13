package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By login = By.id("cmdSiginLink");
	By email = By.id("_email");
	By password = By.id("_password");
	By btnLoging = By.id("cmdSignin");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void doLogin(String username, String key) {
		driver.findElement(login).click();
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(key);
		driver.findElement(btnLoging).click();
	}
}
