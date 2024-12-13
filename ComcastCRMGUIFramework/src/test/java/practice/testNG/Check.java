package practice.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Check {
	@Test
	public void checking() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
	}
}
