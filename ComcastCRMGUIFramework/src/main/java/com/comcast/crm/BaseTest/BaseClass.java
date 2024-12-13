package com.comcast.crm.BaseTest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();

	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException {
		System.out.println("===connect to DB, Report Config===");
		dbLib.getDbconnection();
		
		
	}
    
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {
		
		System.out.println("===launch browser");
		
         String BROWSER=fLib.getDataFromPropertiesFile("Browser");
         System.out.println("Browser:"+BROWSER);
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		//temprary Variable
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wLib.waitForPageToLoad(driver);
		String url=fLib.getDataFromPropertiesFile("url");
		driver.get(url);
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		
		//String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		System.out.println("driver:"+driver);
		lp.loginToapp(USERNAME, PASSWORD);
		System.out.println("=Login=");
	}

	@AfterMethod(alwaysRun = true)
	public void congigAM() {
		System.out.println("===logout=");
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("===Close Browser===\"");
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException {
		System.out.println("===Close DB, Report Config===");
		dbLib.closeDbconnection();
		
	}
}
