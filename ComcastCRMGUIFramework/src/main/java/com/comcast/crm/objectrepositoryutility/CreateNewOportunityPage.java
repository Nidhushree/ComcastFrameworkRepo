package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOportunityPage {
	
	
	public CreateNewOportunityPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement oportunityName;
	
	@FindBy(xpath="//img[@alt=\"Select\"]")
	private WebElement NewOprtunityRelatedBtn;
	
	@FindBy(name="search_text")
	private WebElement oportunitySearchEdt;
	
	@FindBy(xpath="//select[@id=\"related_to_type\"]/ancestor::tr[@style=\"height:25px\"]/descendant::img[@title=\"Select\"]")
	private WebElement relatedOrgbtn;
	
	@FindBy(xpath="//a[@id=\"3\"]")
	private WebElement oprOrgName;
	
	public WebElement getOprOrgName() {
		return oprOrgName;
	}

	public WebElement getRelatedOrgbtn() {
		return relatedOrgbtn;
	}

	public WebElement getOportunitySearchEdt() {
		return oportunitySearchEdt;
	}

	public WebElement getNewOprtunityRelatedBtn() {
		return NewOprtunityRelatedBtn;
	}

	public WebElement getOportunityName() {
		return oportunityName;
	}
	
	public void CreateOportinity(String oportunityname )
	{
		oportunityName.sendKeys(oportunityname);
		relatedOrgbtn.click();
		
		
	}
	
	

}
