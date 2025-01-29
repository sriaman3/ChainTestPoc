package org.qa.opencart.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.opencart.driverfactory.DriverFactory;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;

@Listeners(ChainTestListener.class)
public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage lp;
	protected AccountPage accPage;
	protected DriverFactory df;
	protected Properties prop;
	
	@BeforeTest
	public void setUp() {
		//ChainPluginService.getInstance().addSystemInfo("Owner Name", "AmanAutomationLabs");
		
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		
		lp = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	 	@AfterMethod
	    public void attachScreenshot(ITestResult result){
	        if(!result.isSuccess()){
	            ChainTestListener.embed(takeScreenshot(), "image/png");
	        }
	    }

	    /**
	     * takescreenshot
	     * @return
	     */

	    public byte[] takeScreenshot(){
	       return ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BYTES);
	    }
	    
	
	
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
