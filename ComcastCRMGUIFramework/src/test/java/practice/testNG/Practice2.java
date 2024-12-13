package practice.testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildWindow;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class Practice2 extends BaseClass {

	@Test

	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		// read testscript data from Excel
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
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

		// String orgname1 = eLib.getDataFromExcel("productContact", 7,
		// 2)+jLib.getRandomNumber();
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		// step2: navigate to contact module
		ContactPage cp = new ContactPage(driver);
		cp.getContactlink().click();

		// step3: click on create contact Button
		cp.getCreatecontactbtn().click();

		// step4: create new Contact with Organization
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

		String headerinfo = cp.getHeaderContactName().getText();
		if (headerinfo.contains(ContactlastName)) {

			System.out.println(ContactlastName + "header verified ===PASS");
		} else {
			System.out.println(ContactlastName + "header verified is not verified==FAIL");
		}
		
		String actualOrgName = cnop.getActualOrgName().getText();
		if(actualOrgName.contains(orgname))
		{
			System.out.println(orgname+"is verified===PASS");
		}
		else
		{
			System.out.println(orgname+"is not verified===FAIL");
		}

		
	}

}
