package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	@FindBy(id="phone")
	private WebElement phoneNumberedt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actualOrgName;

	public WebElement getActualOrgName() {
		return actualOrgName;
	}

	public WebElement getPhoneNumberedt() {
		return phoneNumberedt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		savebtn.click();
	}
	public void createPhoneNumberedt(String MobilNo)
	{
		phoneNumberedt.sendKeys(MobilNo);
	}
	
	public void createOrgNameWithIndustryandType(String orgName, String industries, String type)
	{
		orgNameEdt.sendKeys(orgName);
		Select s=new Select(industryDropdown);
		s.selectByVisibleText(industries);
		Select s1=new Select(typeDropdown);
		s1.selectByVisibleText(type);
		
		
	}
	

}
