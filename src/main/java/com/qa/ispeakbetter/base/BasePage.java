package com.qa.ispeakbetter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties properties;
	
	public WebDriver initialize_driver() {
		properties = initialize_properties();
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("driver not found");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
		return driver;
	}
	public Properties initialize_properties() {
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream("/Users/user/eclipse-workspace/IspeakBetter2021/src/main/java/com/qa/ispeakbetter/config/config.properties");
			properties.load(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		}
		catch (IOException e) {
			System.out.println("File Not Found!!!");
		}
		return properties;
	}
}
