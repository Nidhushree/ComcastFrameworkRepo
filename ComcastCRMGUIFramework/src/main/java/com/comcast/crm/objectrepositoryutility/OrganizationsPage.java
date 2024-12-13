package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement SearchDropDown;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDropDown() {
		return SearchDropDown;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
	
	
	 
}
