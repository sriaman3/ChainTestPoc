package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
	
	@BeforeClass
	public void accLogin() {
		accPage = lp.doLogin("aman@opencart.com", "12345");
	}
	
	@Test
	public void verifyAccountPageTitle() {
		Assert.assertEquals(accPage.getAccountPageTitle(), "My Account");
	}

}
