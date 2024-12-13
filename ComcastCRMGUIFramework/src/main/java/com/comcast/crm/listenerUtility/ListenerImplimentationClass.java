package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplimentationClass implements ITestListener, ISuiteListener {
	
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	//this onStart method comming from ISuiteListener interface and then we implement the report
	//to configure the report instead of base class we are using listener why it will get execute automatically 
	public void onStart(ISuite suite) {
		System.out.println("Report Configaration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "wndows-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"=====START=====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "=======>"+result.getMethod().getMethodName()+"====> STARTED<===");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"=====END=====");
		test.log(Status.PASS, "=======>"+result.getMethod().getMethodName()+"====> Completed<===");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot t=(TakesScreenshot)BaseClass.sdriver;
		String filePath = t.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
	
		test.log(Status.FAIL, "=======>"+result.getMethod().getMethodName()+"====> FAILED<===");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
