package practice.testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentationClass.class)
public class DebugPractice extends BaseClass {
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

}
