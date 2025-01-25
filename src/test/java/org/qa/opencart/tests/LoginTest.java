package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyLoginPageTitle() {
		
		String title = lp.getLoginPageTitle();
		
		Assert.assertEquals(title, "Account Login");
		ChainTestListener.log("verifying login page title");
	}
	
	@Test
	public void verifyLoginPageUrl() {
		
		Assert.assertEquals(lp.getLoginPageUrl(), "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		ChainTestListener.log("verifying login page url");
	}
	
	@Test(priority = 2)
	public void verifyLoginFunctionality() {
		accPage = lp.doLogin("aman@opencart.com", "12345");
		Assert.assertEquals(accPage.getAccountPageTitle(), "My Account");
		ChainTestListener.log("verifying user is loggedin to the application");
	}


}
