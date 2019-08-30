package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;
/**
 * 
 * @author NaveenKhunteta
 *
 */
public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;

	//define locators / OR - with By locator (NPF pattern):
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	
	//constructor of page class:
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page actions:
	public String getLoginPageTitle(){
		return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	
	public HomePage doLogin(String username, String pwd){
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new HomePage(driver);
	}
	
	
}
