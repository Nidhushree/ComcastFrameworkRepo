package com.comcast.crm.oportunitytest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOportunityPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OportunityPage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildWindow;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOportunityTest extends BaseClass {

	@Test

	public void createOportunity() throws EncryptedDocumentException, IOException, InterruptedException {

		// read testscript data from Excel
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		// create organization
		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateNewOrgBtn().click();

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


		String oportunityname = eLib.getDataFromExcel("productOportunity", 1, 2) + jLib.getRandomNumber();
		//String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		System.out.println(oportunityname);
		// String relatedTo = eLib.getDataFromExcel("Contact", 1, 3);

		//LoginPage lp = new LoginPage(driver);
		//lp.loginToapp("http://localhost:8888/", "admin", "admin");

		// click on oportunity link

		OportunityPage orp = new OportunityPage(driver);
		orp.oportunitylLink();

		// create new oportunity
		CreateNewOportunityPage cno = new CreateNewOportunityPage(driver);
		cno.CreateOportinity(oportunityname);
        //System.out.println(oportunityname+"oportunity created");
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
		
	}

}
