package practice.testNG;

//import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	
	@Test
	
	public void amazonTest() throws IOException
	 {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//step1: create an object to EventFiring WebDriver
		//EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//step2: use getScreenshotAs method to get the file type of screenshot
		//File src = edriver.getScreenshotAs(OutputType.FILE);
		
		
		//step3:store screenshot in local drive
		//FileUtils.copyFile(src, new File("./Screenshot/test.png"));
		
		

}
}
