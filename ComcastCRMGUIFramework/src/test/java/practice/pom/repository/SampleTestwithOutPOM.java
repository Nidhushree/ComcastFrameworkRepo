package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestwithOutPOM {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		WebElement elem1 = driver.findElement(By.name("user_name"));
		WebElement elem2 = driver.findElement(By.name("user_password"));
		WebElement elem3 = driver.findElement(By.id("submitButton"));
		
		elem1.sendKeys("admin");
		elem2.sendKeys("admin");
		driver.navigate().refresh();
		elem1.sendKeys("admin");
		elem2.sendKeys("admin");
		elem3.click();
	}

}
