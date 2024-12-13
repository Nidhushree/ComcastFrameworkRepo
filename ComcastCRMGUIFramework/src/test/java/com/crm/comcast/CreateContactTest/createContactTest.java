package com.crm.comcast.CreateContactTest;
/**
 * @author Nidhushree
 * 
 * 
 */

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplimentationClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildWindow;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentationClass.class)
public class createContactTest extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();

		/* step2 : navigate to contact module */
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact Page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contact Page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// step 4: enter all the details & create new Contact
		UtilityClassObject.getTest().log(Status.INFO,"create contact");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactNew(ContactlastName);
		UtilityClassObject.getTest().log(Status.INFO, ContactlastName+"create new contact");
		System.out.println(ContactlastName);

		// verify Header info Expected Result
		String actLastName = cp.getHeaderContactName().getText();
		System.out.println(actLastName);
		//Assert.assertEquals(true,actLastName.contains(ContactlastName);
		Assert.assertEquals(true,actLastName.contains(ContactlastName));
		System.out.println("Info verified and pass");
		

	}

	@Test

	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 1) + jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getContactlink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		cp.getCreatecontactbtn().click();
		// driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		// step4: enter all the detail create new contact
		UtilityClassObject.getTest().log(Status.INFO, "create contact");
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(20);

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(lastname, startDate, endDate);
		UtilityClassObject.getTest().log(Status.INFO, "create contact with"+startDate);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actSuptStartDate = cip.getActualStartDateinCnt();
		System.out.println(actSuptStartDate);
		Assert.assertEquals(true,actSuptStartDate.contains(startDate));
		
			System.out.println(startDate + " start date verified and pass");
		

		// step6: verify the support end Date

		String actSupprtEndDate = cip.getActualStartEndDateinCnt();
		System.out.println(actSupprtEndDate);
		Assert.assertEquals(true,actSupprtEndDate.contains(endDate));
		
			System.out.println(endDate + " end Date verified and pass");
		
	}

	@Test

	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		// read testscript data from Excel
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Homepage");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		// create organization
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create new organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step6: verify header mesg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "create organization with"+orgname);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
		//if (actOrgName.contains(orgname)) {
			System.out.println(orgname + "is verified and pass");
		
		

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		
		// step2: navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact module");
		ContactPage cp = new ContactPage(driver);
		cp.getContactlink().click();

		// step3: click on create contact Button
		cp.getCreatecontactbtn().click();

		// step4: create new Contact with Organization
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactwithOrg(ContactlastName);

		// step5: switch to childwindow
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.switchNewBrowserTabBasedonUrl(driver, "module=Accounts");
		OrganizationChildWindow ocw = new OrganizationChildWindow(driver);
		Thread.sleep(1000);
		ocw.verifyOrgNameInContact(orgname);
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		// parent
		wLib.switchNewBrowserTabBasedonUrl(driver, "module=Contacts");
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.getSaveBtn().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "verify contact with"+orgname);
		String headerinfo = cp.getHeaderContactName().getText();
		Assert.assertEquals(true,headerinfo.contains(ContactlastName));
		//if (headerinfo.contains(ContactlastName)) {

			System.out.println(ContactlastName + "header verified ===PASS");
		
		
        
		String actualOrgName = cnop.getActualOrgName().getText();
		Assert.assertEquals(true,actualOrgName.contains(orgname));
		//if (actualOrgName.contains(orgname)) {
			System.out.println(orgname + "is verified===PASS");
		
		}



	@Test
	public void createContactWithTitle() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		String TitleName = eLib.getDataFromExcel("productContact", 10, 3) + jLib.getRandomNumber();

		// step2 : navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home Page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home Page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// step 4: enter all the details & create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "create contact with title"+TitleName);
		ccp.createTitle(ContactlastName, TitleName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualTitle = cip.getActualTitle().getText();
		Assert.assertEquals(true,actualTitle.contains(TitleName));
		//if (actualTitle.contains(TitleName)) {
			System.out.println(TitleName + "Title is verified and pass");
		
		}
	
	

	@Test

	public void createContactwithDepart() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		String departName = eLib.getDataFromExcel("productContact", 10, 3) + jLib.getRandomNumber();

		// step2 : navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		ContactPage cp = new ContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		cp.getCreatecontactbtn().click();
		// step 4: enter all the details & create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "create contact with department name is"+departName);
		ccp.createTitle(ContactlastName, departName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualTitle = cip.getActualTitle().getText();
		Assert.assertEquals(true,actualTitle.contains(departName));
			System.out.println(departName + "department name is verified and pass");
		
		}
	}

	

