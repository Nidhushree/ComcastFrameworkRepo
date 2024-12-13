package practice.testNG;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class AssertValidateinScripts extends BaseClass {
	
	@Test
	
	public void createMobileNoWithAssert() throws EncryptedDocumentException, IOException
	{
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();
		String MobilNo = eLib.getDataFromExcel("productOrg", 4, 5);

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
