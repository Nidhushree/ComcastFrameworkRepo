package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class createdOrgdeleted extends BaseClass {
	@Test
	
	public void deleteOrgTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
	
	
			
			
			// read testscript data from Excel
			String orgname=eLib.getDataFromExcel("productOrg", 10, 2)+jLib.getRandomNumber();
			
			
			
			// step2: navigate to organization module
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			
			Thread.sleep(2000);
			
			 OrganizationsPage op=new OrganizationsPage(driver);
			 op.getCreateNewOrgBtn().click();
			 
			
			//step4: enter all the details & create new organization
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			 cnop.createOrg(orgname);
			
			
			//step6: verify header mesg expected result
			 OrganizationInformationPage  oip=new OrganizationInformationPage(driver);
			 String actOrgName=oip.getHeaderMsg().getText();
			 Assert.assertEquals(orgname,actOrgName);
			 
				 System.out.println(actOrgName+"is verified and pass");
			 
			 
			 //go back to Organization Page
			
				hp.getOrgLink().click();
			
			 //search for Organization Page
			
			 //op.getCreateNewOrgBtn().click();
			 
			 op.getSearchEdt().sendKeys(orgname);
			 wLib.selectByText(op.getSearchDropDown(), "Organization Name");
			 op.getSearchNowBtn().click();
			//In dynamic webtable select and delete org
			 //driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
			 System.out.println(orgname+"deleted");
			 
			 
			 
			 // logout
			 //hp.logout();
			 wLib.waitForPageToLoad(driver);
			//driver.quit();
}

}
