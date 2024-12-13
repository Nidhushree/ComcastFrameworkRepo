package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
/**
 * @author Nidhushree
 * contains Login page elements & business lib like login()
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;



public class LoginPage {// Rule-1 create a separate java class
	                    //Rule-2 Oject Creation
	                    //Rule3: Object Initialization inside constructor
   
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule4 : object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to application based on username, password
	 * @param username
	 * @param password
	 */
	
	//run5: provide Action //Business Library-specific to business
	public void loginToapp(String username, String password)
	{
		//waitForPageToLoad(driver);
		//driver.get(url);
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}
	
	
	
	

}
