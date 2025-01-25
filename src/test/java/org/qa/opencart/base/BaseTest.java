package org.qa.opencart.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage lp;
	protected AccountPage accPage;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		lp = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	  @AfterMethod 
	  public void getScreenshot(ITestResult result) throws IOException {
	  
		  if(ITestResult.SUCCESS==result.getStatus()) {
			  String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			  byte[] decodedScreenshot = Base64.getDecoder().decode(screenshot);
			  File screenshotFile = new File("screenshot_" + result.getName() + ".jpeg");
	            try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
	                fos.write(decodedScreenshot);
	            }
			  ChainTestListener.embed(screenshotFile, "image/jpeg");
		  }
	  
	}
	 

}
