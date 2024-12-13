package practice.testNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;

import junit.framework.Assert;

public class SampleReportTest  {

	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "wndows-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@AfterSuite

	public void configAS() 
	{
		report.flush();
	}

	/*@Test

	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "wndows-10");
		report.setSystemInfo("BROWSER", "CHROME");
		//ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest("createContactTest");
		// with the help of test we are going generate the status intead of println
		// statement
		// we are using test.log i will never ever use sop statement in real time

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		//report.flush(); // logs will saved

		
	}*/

	
	@Test
	
	public void createWithOrg()
	{
		 WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot t=(TakesScreenshot)driver;
		String filePath = t.getScreenshotAs(OutputType.BASE64);
		
		
		//ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest("createWithOrg1");
		// with the help of test we are going generate the status intead of println
		// statement
		// we are using test.log i will never ever use sop statement in real time

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		Assert.assertFalse(false);
		//Assert.assertEquals("HDFC","H");
			test.log(Status.FAIL, "contact is not created");
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		//} else {
			//test.log(Status.FAIL, "contact is not created");
			//test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		//report.flush(); // logs will saved

		//driver.close();
	}


