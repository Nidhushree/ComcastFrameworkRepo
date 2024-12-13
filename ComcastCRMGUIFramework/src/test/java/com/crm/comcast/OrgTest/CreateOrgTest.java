package com.crm.comcast.OrgTest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import junit.framework.Assert;

public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		// read testscript data from Excel
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		// create organization
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization page");
		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create new organization" +orgname);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step6: verify header mesg expected result
		UtilityClassObject.getTest().log(Status.INFO,"verfing organization");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname) );
		
			System.out.println(orgname + "is verified and pass");
		

	}

	@Test

	public void createOrgWithIndustris() throws EncryptedDocumentException, IOException {
		// read testscript data from Excel
		
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel file");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		String industries = eLib.getDataFromExcel("productOrg", 4, 3);
		String type = eLib.getDataFromExcel("productOrg", 4, 4);

		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3: click on create organization Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step4: in industrity dpodown select any one of option
		UtilityClassObject.getTest().log(Status.INFO,"create organization with industry " +industries);
		cnop.createOrgNameWithIndustryandType(orgname, industries, type);

		// verify the dropdown industries and type info
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actin = oip.getactIndustriesText();
		Assert.assertEquals(true,actin.contains(industries));
		
			System.out.println(industries + "is created==PASS");
		
		

		// verify the dropdown industries and type info

		String actType = oip.getActTypetext();
		Assert.assertEquals(true,actType.contains(type));
		 
			System.out.println(type + "is created==PASS");
		

	}

	@Test

	public void createOrgWithMobileNumber() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		String MobilNo = eLib.getDataFromExcel("productOrg", 4, 5);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3: click on create organization Button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);

		// step5:enter the mobile number
		UtilityClassObject.getTest().log(Status.INFO, "create organization with "+MobilNo);
		cnop.getPhoneNumberedt().sendKeys(MobilNo);
		cnop.getSavebtn();
		// driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// step6: verify the mobileNumber
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actMobile = oip.getActPhoneNum();
		Assert.assertEquals(true,actMobile.contains(MobilNo));
		
			System.out.println(MobilNo + " is displayed ==== PASS");
		

	}

	@Test
	public void createOrgPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException {
		// read testscript data from Excel
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		// create organization
		UtilityClassObject.getTest().log(Status.INFO, "create organization page");
		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create new organization" +orgname);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step6: verify header mesg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
		
			System.out.println(orgname + "is verified and pass");
		
	}

	/*@Test

	public void deleteOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {

		// read testscript data from Excel
		String orgname = eLib.getDataFromExcel("productOrg", 10, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step6: verify header mesg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + "is verified and pass");
		} else {
			System.out.println(orgname + "is not verified and FAIL");
		}

		// go back to Organization Page

		hp.getOrgLink().click();

		// search for Organization Page

		// op.getCreateNewOrgBtn().click();

		op.getSearchEdt().sendKeys(orgname);
		wLib.selectByText(op.getSearchDropDown(), "Organization Name");
		op.getSearchNowBtn().click();
		// In dynamic webtable select and delete org
		// driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		System.out.println(orgname + "deleted");

		// logout
		// hp.logout();
		wLib.waitForPageToLoad(driver);
		// driver.quit();
	}*/

}
