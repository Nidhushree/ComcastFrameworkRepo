package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//read common data from excel
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String u = fLib.getDataFromPropertiesFile("url");
		String us = fLib.getDataFromPropertiesFile("username");
		String ps = fLib.getDataFromPropertiesFile("password");
		
		
		
		
		// read testscript data from Excel
		
		 String orgname=eLib.getDataFromExcel("productOrg", 4, 2)+jLib.getRandomNumber();
		 String industries=eLib.getDataFromExcel("productOrg", 4, 3);
		 String type=eLib.getDataFromExcel("productOrg", 4, 4);
		 
		 //crossbroser testing
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
			
			//step 1: login to app
			wLib.waitForPageToLoad(driver);
			
			Thread.sleep(2000);
			driver.get(u);
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp("admin", "admin");
			
			// step2: navigate to organization module
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			
			//step3: click on create organization Button
			OrganizationsPage op=new OrganizationsPage(driver);
			 op.getCreateNewOrgBtn().click();
			
			//step4: enter all the details & create new organization
			 CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			 cnop.createOrg(orgname);
			 
			
			
			//step4: in industrity dpodown select any one of option
			 cnop.createOrgNameWithIndustryandType(orgname, industries, type);
			
			 
			//verify the dropdown industries and type info
			 OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			 String actin = oip.getactIndustriesText();
			 if(actin.contains(industries)) { 
				 System.out.println(industries+"is created==PASS"); 
				 } 
			 else { 
				 System.out.println(industries+"is not created==FAIL"); 
				 }
			
			
			//verify the dropdown industries and type info
			
			  String actType = oip.getActTypetext();
			  if(actType.contains(type))
			    {
				 System.out.println(type +"is created==PASS"); 
				 }
			 else { 
				 System.out.println(type +"is not created==FAIL"); 
				 }
			 
			 
		

	}

}
