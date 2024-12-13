package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	
	public OrganizationInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement actIndustriesText;
	
	@FindBy(id="mouseArea_Type")
	private WebElement actTypeText;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhoneNo;
	
	
	public WebElement getActPhoneNo() {
		return actPhoneNo;
	}


	public WebElement getActIndustriesText() {
		return actIndustriesText;
	}


	public WebElement getActTypeText() {
		return actTypeText;
	}


	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public String getactIndustriesText()
	{
		String data = actIndustriesText.getText();
		return data;
	}
	
	public String getActTypetext()
	{
		String data = actTypeText.getText();
		return data;
	}
	
	public String getActPhoneNum()
	{
		String data = actPhoneNo.getText();
		return data;
	}
	
	

}
