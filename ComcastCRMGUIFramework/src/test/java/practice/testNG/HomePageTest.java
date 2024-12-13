package practice.testNG;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageTest {
	@Test
	
	public void HomePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test start");
		String expecPage="Home Page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(actitle, expecPage);
		System.out.println(mtd.getName()+"Test end");
		
	}
	
@Test
	
	public void VerifyLogoHomePageTest(Method mtd)
	{
	System.out.println(mtd.getName()+"Test start");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	boolean status = driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
	Assert.assertTrue(status);
	
	System.out.println(mtd.getName()+"Test end");
	}
	
	

}
