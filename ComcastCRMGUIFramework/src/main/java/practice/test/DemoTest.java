package practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(threadPoolSize = 2, invocationCount = 2)
	
	public void m1()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		System.out.println("welcome to google");
		
	}

}
