package practice.testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;


public class InvoiceTest extends BaseClass {
	@Test//(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListnerImp.class)
	
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	
	@Test
	
	public void createInvoicewithContactTest()
	{
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}

}
