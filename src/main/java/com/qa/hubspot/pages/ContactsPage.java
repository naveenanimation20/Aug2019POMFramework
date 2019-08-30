package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;
/**
 * 
 * @author NaveenKhunteta
 *
 */
public class ContactsPage {
	WebDriver driver;
	ElementUtil elementUtil;

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
	By email = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName = By.id("uid-ctrl-3");
	By jobTitle = By.id("uid-ctrl-5");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}

	public void createNewContact(String emailID, String FN, String LN, String jobTitleVal) {
		elementUtil.doClick(createContactButton);
		elementUtil.doSendKeys(email, emailID);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.doSendKeys(jobTitle, jobTitleVal);

		elementUtil.doClick(createContactFormButton);
	}

}
