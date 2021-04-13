package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.page.LoginPage;

public class LoginPageTest extends BasePage{
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPage;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver= basePage.initialize_driver();
		loginPage= new LoginPage(driver);
//		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority = 1, description = "this test verifies main page title", groups = {"main_page"})
	public void verifyMainPageTitle() throws InterruptedException {
		String actualTitle = loginPage.getPageTitle();
		String expectedTitle = "Learn English with Online Teachers - Get your Free Live English Class Now.";
//		Thread.sleep(1000);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test (priority = 2, description = "this test is for login function", groups = {"home_page"})
	public void loginTest() throws InterruptedException {
		loginPage.doLogin("t_komurcu@hotmail.com", "deneme12345");
		Thread.sleep(2000);
		String expectedURL = "https://onlinestudent.ispeakbetter.com/onlinestudent.php";
		String actualURL = driver.getCurrentUrl();
		Thread.sleep(1000);
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	@Test (priority = 3, description = "this test is checks if the welcome message for user is right", groups = {"home_page"})
	public void verifyWelcomeMessage() throws InterruptedException {
		loginPage.doLogin("t_komurcu@hotmail.com", "deneme12345");
//		Thread.sleep(2000);
		String expectedMessage = "Good Afternoon Talha,";
		String actualMessage = driver.findElement(By.id("dashboard_goodday")).getText();
//		Thread.sleep(1000);
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test (priority = 4, description = "this test is checks if vocablary basket button works", groups = {"home_page"})
	public void verifyLinkVocablaryBasket() throws InterruptedException {
		loginPage.doLogin("t_komurcu@hotmail.com", "deneme12345");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div/center[2]/a")).click();
		String expectedText = " Vocabulary Basket";
		String actualText = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")).getText();
//		Thread.sleep(1000);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (priority = 5, description = "this test is checking if input area in vocablary basket works", groups = {"home_page"})
	public void testSendingKeys() throws InterruptedException {
		loginPage.doLogin("t_komurcu@hotmail.com", "deneme12345");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div/center[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("Testing this part");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/button")).click();
		String expectedText = " Search Result";
		String actualText = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")).getText();
//		Thread.sleep(1000);
		Assert.assertEquals(actualText, expectedText);
	}
	@Test (priority =6, description = "this test checks if we are in correct page", groups = {"main_page"})
	public void verifyMainPageURL() throws InterruptedException {

		String expectedURL = "https://ispeakbetter.com/?lang=en";
		String actualURL = driver.getCurrentUrl();
//		Thread.sleep(1000);
		Assert.assertEquals(actualURL, expectedURL);
	}
	@Test (priority =7, description = "this test checks if try for free button works", groups = {"main_page"})
	public void testTryforFreeSection() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"btnFree\"]/span[1]")).click();
		Boolean signUp = driver.findElement(By.id("cmdSignup")).isDisplayed();
//		Thread.sleep(1000);
		Assert.assertTrue(signUp);
	}
	@Test (priority =8, description = "this test checks if terms&conditions section selected", groups = {"main_page"})
	public void verifyTermsandConditions() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"btnFree\"]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"check_term\"]")).click();
		Boolean termsAndConditions = driver.findElement(By.xpath("//*[@id=\"check_term\"]")).isSelected();
//		Thread.sleep(1000);
		Assert.assertTrue(termsAndConditions);
	}
	
	@Test (priority =9, description = "this test checks if user can register with google account", groups = {"main_page"})
	public void verifyGoogleLink() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"btnFree\"]/span[1]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"modal-custom\"]/div/div/div/section[2]/div/div/p[1]/b[2]/a")).click();
		String expectedText = "Über Google anmelden";
		String actualText = driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]/div/div[1]/div/div[2]")).getText();
//		Thread.sleep(1000);
		Assert.assertEquals(actualText, expectedText);
	}
	@Test (priority =10, description = "this test checks if turkish language section works properly", groups = {"main_page"})
	public void testLanguageSection() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"langTr\"]")).click();
		String expectedHeader = "Daha İyi İngilizce Konuşmak İster Misiniz?";
		String actualHeader = driver.findElement(By.xpath("//*[@id=\"home-section\"]/div/div/div/div[1]/div/h1")).getText();
//		Thread.sleep(1000);
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
