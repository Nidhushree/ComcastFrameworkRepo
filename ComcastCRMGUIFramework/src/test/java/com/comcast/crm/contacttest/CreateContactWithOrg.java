package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		String orgname = eLib.getDataFromExcel("productContact", 7, 2) + jLib.getRandomNumber();
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3);
		
		
		
		//System.out.println(data);
		
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
		driver.findElement(By.name("user_name")).sendKeys(us);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(ps);
		driver.findElement(By.id("submitButton")).click();
		
		// step2: navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3: click on create organization Button
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		//step4: enter all the details & create new organization
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//step5: verify header mesg expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(headerinfo.contains(orgname))
		{
			System.out.println(orgname + "is created===PASS");
		}
		else
		{
			System.out.println(orgname +"is not created==FAIL");
		}
		//step6: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//step3: click on create organization Button
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//stp4:enter all the details & create new Organization
		driver.findElement(By.name("lastname")).sendKeys(ContactlastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		wLib.switchNewBrowserTabBasedonUrl(driver, "module=Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		Thread.sleep(1000);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();  //Dynamic Xpath
		
		
		//switch to parent window
		wLib.swithToTabOnTitle(driver, "module=Contacts");
		
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
		//verify Header info Expected Result
		headerinfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		Thread.sleep(1000);
		if(headerinfo.contains(ContactlastName))
		{
			System.out.println(ContactlastName + "header verified ===PASS");
		}
		else
		{
			System.out.println(ContactlastName +"header verified is not verified==FAIL");
		}
		
		//verify Header OrgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if(actOrgName.trim().equals(orgname))
		
			
			{
				System.out.println(orgname + "is created===PASS");
			}
			else
			{
				System.out.println(orgname +"is not created==FAIL");
			}
		driver.quit();
			
		}
		
		
		

	}

		

	
