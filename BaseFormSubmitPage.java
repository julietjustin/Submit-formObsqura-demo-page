package com.obsqura.TestNGAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseFormSubmitPage {
	public WebDriver driver;
	@BeforeTest
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\TestNGAssignment\\src\\main\\java\\Resourse\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
