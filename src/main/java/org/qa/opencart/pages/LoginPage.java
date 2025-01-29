package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By email = By.id("input-email");
	private By passwd = By.id("input-password");
	private By lgnBtn = By.xpath("//input[@value='Login']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	//page chaining
	public AccountPage doLogin(String uN, String pwd) {
		driver.findElement(email).sendKeys(uN);
		driver.findElement(passwd).sendKeys(pwd);
		driver.findElement(lgnBtn).click();
		return new AccountPage(driver);
	}

}
