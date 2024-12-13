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
import org.testng.annotations.Test;

import com.comcast.crm.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BasebClass {
	
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public WebDriver driver=null;
	
	@BeforeSuite
	public void configBS() throws SQLException
	{
		System.out.println("===connect to DB, Report Config===");
		dbLib.getDbconnection();
	}
	
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("===launch browser");
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wLib.waitForPageToLoad(driver);
		
		
	}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		System.out.println("driver:"+driver);
		lp.loginToapp(USERNAME, PASSWORD);
		System.out.println("=Login=");
		
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("===logout=");
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("===Close Browser===\"");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===Close DB, Report Config===");
		dbLib.closeDbconnection();
	}
	
	@Test
	public void display() {
		System.out.println("HIIIIIIIII");
	}
	}
	
	


