package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OportunityPage {
	
	//WebDriver driver;
	public OportunityPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Opportunities")
	private WebElement Oportunitylink;
	
	@FindBy(xpath="//img[@alt=\"Create Opportunity...\"]")
	private WebElement createNewOportunitybtn;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement oportunitySavebtn;
	
	
	
	public WebElement getCreateNewOportunitybtn() {
		return createNewOportunitybtn;
	}

	public WebElement getOportunitylink() {
		return Oportunitylink;
	}
	
	public void oportunitylLink()
	{
		Oportunitylink.click();
		createNewOportunitybtn.click();
		
	}
	
	

	
	
	
	

}
