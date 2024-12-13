package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDate1 {
	
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
			driver.findElement(By.name("user_name")).sendKeys(us);
			driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(ps);
			driver.findElement(By.id("submitButton")).click();
			
			// step2: navigate to organization module
			driver.findElement(By.linkText("Contacts")).click();
			Thread.sleep(2000);
			//step3: click on create organization Button
			driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			
			//step4: enter all the detail create new contact
			String startDate = jLib.getSystemDateYYYYDDMM();
			String endDate = jLib.getRequiredDateYYYYDDMM(20);
			
			 
			 driver.findElement(By.name("lastname")).sendKeys(lastname);
			 driver.findElement(By.name("support_start_date")).clear();
			 driver.findElement(By.name("support_start_date")).sendKeys(startDate);
			 
			 driver.findElement(By.name("support_end_date")).clear();
			 driver.findElement(By.name("support_end_date")).sendKeys(endDate);
			 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			 
			 //Step5: verify the support start date and support end Date
			  String actSuptStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
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
			  String actSupprtEndDate = driver.findElement(By.xpath("//span[@id=\"dtlview_Support End Date\"]")).getText();
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



