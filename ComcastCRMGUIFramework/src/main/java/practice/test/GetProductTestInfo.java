package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductTestInfo {
	@Test(dataProvider="getData")
	
	public void getProductInfoTest(String brandName, String productName) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		//search product
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		//String x="//span[text()='Samsung Galaxy S23 Ultra 5G AI Smartphone (Cream, 12GB, 256GB Storage)']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/descendant::span[@class=\"a-price-whole\"]";
		String price = driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
		System.out.println(price);
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eLib=new ExcelUtility();
		int rowcount = eLib.getRowcount("Product");
		Object[][] objArr=new Object[3][2];  //3 indicate number  of times and 2 indicates number of arguments
		for(int i=0;i<rowcount;i++)
		{
		objArr[i][0]=eLib.getDataFromExcel("Product", i+1, 0);
		objArr[i][1]=eLib.getDataFromExcel("Product", i+1, 1);
		
		
		}
		return objArr;
	}
}
