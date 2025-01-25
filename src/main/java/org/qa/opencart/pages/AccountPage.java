package org.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

public class AccountPage {
	
private WebDriver driver;
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}

}
