package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationChildWindow {

	
		
		public OrganizationChildWindow(WebDriver driver)
		{
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="search_text")
		private WebElement searchOrgbox;
		
		@FindBy(name="search")
		private WebElement searchOrgSaveBtn;
		
		@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
		private WebElement headerParentwin;
		
		public WebElement getHeaderParentwin() {
			return headerParentwin;
		}

		public WebElement getSearchOrgbox() {
			return searchOrgbox;
		}

		public WebElement getSearchOrgSaveBtn() {
			return searchOrgSaveBtn;
		}
		
		public void verifyOrgNameInContact(String orgname)
		{
			searchOrgbox.sendKeys(orgname);
			searchOrgSaveBtn.click();
			
			
		}
		
		
		
		

	}


