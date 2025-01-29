package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constant.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
	
	@BeforeClass
	public void accLogin() {
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyAccountPageTitle() {
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACC_PAGE_TITLE);
	}

}
