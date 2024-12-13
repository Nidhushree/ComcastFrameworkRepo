package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	//WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement contactlastNameEdt;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateEdt;
	
	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public WebElement getSupportStrtDateEdt() {
		return supportStrtDateEdt;
	}

	@FindBy(name="support_start_date")
	private WebElement supportStrtDateEdt;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name=\"account_id\"]/parent::td[@class=\"dvtCellInfo\"]/child::img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement contactOrgBtn;
	
	@FindBy(xpath="//input[@id=\"title\"]")
	private WebElement titleEdt;
	
	@FindBy(xpath="//input[@name=\"department\"]")
	private WebElement departName;
	
	public WebElement getDepartName() {
		return departName;
	}
	
	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getContactOrgBtn() {
		return contactOrgBtn;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	public void createContactwithOrg(String lastname)
	{
		contactlastNameEdt.sendKeys(lastname);
		contactOrgBtn.click();
	}
	public void createContactNew(String lastname)
	{
		contactlastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createTitle(String lastname, String TitleName)
	{
		contactlastNameEdt.sendKeys(lastname);
		titleEdt.sendKeys(TitleName);
		saveBtn.click();
	}
	
	public void createDepart(String lastname, String departName)
	{
		contactlastNameEdt.sendKeys(lastname);
		titleEdt.sendKeys(departName);
		saveBtn.click();
	}
	
	public void createContact(String lastname, String startDate, String endDate)
	{
		contactlastNameEdt.sendKeys(lastname);
		supportStrtDateEdt.clear();
		supportStrtDateEdt.sendKeys(startDate);
		supportEndDateEdt.clear();
		supportEndDateEdt.sendKeys(endDate);
		saveBtn.click();
		
		
	}

}
