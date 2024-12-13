package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	
	WebDriverUtility wLib=new WebDriverUtility();

	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	@FindBy(xpath="//td[@class=\"tabUnSelected\"]/parent::tr/descendant::a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement singNout;
	
	public void logout(WebDriver driver)
	{
		adminImg.click();
		wLib.mousemoveOnElement(driver, singNout);
		
	}
	
	
	


}
