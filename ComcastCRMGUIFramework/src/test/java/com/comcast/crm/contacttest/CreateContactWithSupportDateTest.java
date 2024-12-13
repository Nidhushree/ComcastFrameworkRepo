package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//read common data from excel
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String u = fLib.getDataFromPropertiesFile("url");
		String us = fLib.getDataFromPropertiesFile("username");
		String ps = fLib.getDataFromPropertiesFile("password");
		
		
		
		// read testscript data from Excel
		
		 String orgname = eLib.getDataFromExcel("productOrg", 4, 1)+jLib.getRandomNumber();
		 String lastname = eLib.getDataFromExcel("productOrg", 4, 2)+jLib.getRandomNumber();
		 
		 WebDriver driver=null;
			if(BROWSER.equals("Chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("firfox"))
			{
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equals("Edge"))
			{
				driver=new EdgeDriver();
			}
			
			wLib.waitForPageToLoad(driver);
			Thread.sleep(2000);
			driver.get(u);
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp("admin", "admin");
			
			
			// step2: navigate to organization module
			ContactPage cp=new ContactPage(driver);
			cp.getContactlink().click();
			
			
			//step3: click on create organization Button
			cp.getCreatecontactbtn().click();
			//driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			
			//step4: enter all the detail create new contact
			String startDate = jLib.getSystemDateYYYYDDMM();
			String endDate = jLib.getRequiredDateYYYYDDMM(20);
			
			CreateNewContactPage ccp=new CreateNewContactPage(driver);
			ccp.createContact(lastname, startDate, endDate);
			ContactInformationPage cip=new ContactInformationPage(driver);
			  String actSuptStartDate = cip.getActualStartDateinCnt();
			System.out.println(actSuptStartDate);
			 if(actSuptStartDate.equals(startDate))
			 {
				 System.out.println(startDate+" start date verified and pass");
			 }
			 else
			 {
				 System.out.println(startDate+ "start date verified and fail");
			 }
			 
			//step6: verify the support end Date
			 
			  String actSupprtEndDate = cip.getActualStartEndDateinCnt();
			 System.out.println(actSupprtEndDate);
			 if(actSupprtEndDate.equals(endDate))
			 {
				 System.out.println(endDate + " end Date verified and pass");
			 }
			 else
			 {
				 System.out.println(endDate+ "end Date verified and Fail");
			 }
			 
			 
			 
			 
			 
			
	}

}
