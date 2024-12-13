package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public ContactPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@title=\"Create Contact...\"]")
	private WebElement createcontactbtn;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headerContactName;

	public WebElement getHeaderContactName() {
		return headerContactName;
	}

	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	

}
