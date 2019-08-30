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
public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.cssSelector("a#account-menu>span.account-name ");
	
	By contactsMainTab = By.id("nav-primary-contacts-branch");
	By conatctsChildTab = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}

	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	}

	public boolean verifyLoggedInAcoountName() {
		return elementUtil.isElementDisplayed(accountName);
	}

	public String getLoggedInAcoountName() {
		return elementUtil.doGetText(accountName);
	}
	
	private void clickOnContacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(conatctsChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
	

}
