package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithMobileNumberTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// create Object
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		// read common data from excel

		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String u = fLib.getDataFromPropertiesFile("url");
		String us = fLib.getDataFromPropertiesFile("username");
		String ps = fLib.getDataFromPropertiesFile("password");

		// read testscript data from Excel
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		String MobilNo = eLib.getDataFromExcel("productOrg", 4, 5);

		WebDriver driver = null;
		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firfox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}

		wLib.waitForPageToLoad(driver);
		Thread.sleep(2000);
		driver.get(u);
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("admin", "admin");

		// step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3: click on create organization Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);

		// step5:enter the mobile number
		cnop.getPhoneNumberedt().sendKeys(MobilNo);
		cnop.getSavebtn();
		// driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// step6: verify the mobileNumber
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actMobile = oip.getActPhoneNum();
		Assert.assertEquals(actMobile,MobilNo) ;
		System.out.println(MobilNo + " is displayed ==== PASS");
	

	}

}
