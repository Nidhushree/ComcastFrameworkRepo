package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	
	public ContactInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actualSupportStartDate;
	
	public WebElement getActualSupportStartDate() {
		return actualSupportStartDate;
	}

	@FindBy(id="dtlview_Support End Date")
	private WebElement actualSupportEndDateinCon;

	public WebElement getActualSupportDateinCon() {
		return actualSupportEndDateinCon;
	}
	
	@FindBy(id="dtlview_Title")
	private WebElement actualTitle;
	
	public WebElement getActualTitle() {
		return actualTitle;
	}
	
	
	

	public String getActualStartEndDateinCnt()
	{
		String data=actualSupportEndDateinCon.getText();
		return data;
	}
	
	public String getActualStartDateinCnt()
	{
		String data=actualSupportStartDate.getText();
		return data;
	}

}
