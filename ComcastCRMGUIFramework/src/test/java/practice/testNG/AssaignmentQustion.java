package practice.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class AssaignmentQustion {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//span[@class=\"nav-line-2 \"]"));
		wLib.mousemoveOnElement(driver, ele);
		Thread.sleep(1000);
	driver.findElement(By.xpath("//span[@class=\"nav-action-inner\"]")).click();

	}

}
