package practice.testNG;
/**
 * Test class for contact Module
 * @author Nidhushree
 * 
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario: login()==>navigateContact==>createContact()==verify
	 */
		@Test
	public void searchcontactTest()
	{ 
			/* step 1: login to app*/
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp("admin", "admin");
	}
	

}
