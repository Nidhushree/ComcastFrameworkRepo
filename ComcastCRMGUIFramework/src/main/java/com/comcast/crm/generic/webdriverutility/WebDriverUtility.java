package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//methods to handle current window
	public void switchNewBrowserTabBasedonUrl(WebDriver driver, String partailURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
		String windowId = it.next();	
		driver.switchTo().window(windowId);
		
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(partailURL))
        {
		break;
		}
		}
	}
		//methods to handle partial windows
		public void swithToTabOnTitle(WebDriver driver, String partailTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext())
			{
			String windowId = it.next();	
			driver.switchTo().window(windowId);
			
			String actUrl=driver.getTitle();
			if(actUrl.contains(partailTitle))
	        {
			break;
			}
			}
	}
		// methods to handle frames
		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		public void switchtoFrame(WebDriver driver, String nameID) {
			driver.switchTo().frame(nameID);
		}
		
		public void switchtoFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		//methods to handle AlertPopup
		
		public void switchtoAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		public void switchtoAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		//methods to handle dropdown
		public void selectByText(WebElement element, String text)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}
		
		public void selectByIndex(WebElement element, int index)
		{
			Select sel=new Select(element);
			sel.deselectByIndex(index);
		}
		
		public void selectByValue(WebElement element, String text)
		{
			Select sel=new Select(element);
			sel.selectByValue(text);
		}
		
		public void deSelectByValue(WebElement element, String text)
		{
			Select sel=new Select(element);
			sel.deselectByValue(text);
		}
		public void deSelectByIndex(WebElement element, int index)
		{
			Select sel=new Select(element);
			sel.deselectByIndex(index);
		}
		public void deSelectByVisibleText(WebElement element, String text)
		{
			Select sel=new Select(element);
			sel.deselectByVisibleText(text);
		}
		public void deSelectByAll(WebElement element)
		{
			Select sel=new Select(element);
			sel.deselectAll();
		}
		
		//methods to handle MouseOver
		public void mousemoveOnElement(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).click().perform();
		}
		
		public void doubleclick(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void clickAndHold(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.clickAndHold().perform();
		}
		public void keyDown(WebDriver driver, String key)
		{
			Actions act=new Actions(driver);
			act.keyDown(key).perform();
		}
		public void dragAndDrop(WebDriver driver, WebElement src,WebElement dest)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src,dest).perform();
		}
		
		public void dragAndDropBy(WebDriver driver, WebElement src,int x,int y)
		{
			Actions act=new Actions(driver);
			act.dragAndDropBy(src,x,y).perform();
		}
		
		public void scrollToElement(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.scrollToElement(element).perform();
		}
		
		public void rightClickOnWebPage(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.contextClick();
			
		}
		
		public void rightClickOnWebElement(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		public void doubleClickOnWebElement(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element);
		}
		
		public void doubleClickOnWebPage(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.doubleClick();
		}
		
		public void waitForPageToLoadimplicitWait(WebDriver driver)
		{
			driver.manage().timeouts().getImplicitWaitTimeout();
		}
		
		public void implicitWaitofDays(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofDays(1));
		}
		
		public void implicitWaitofHours(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofHours(6));
		}
		public void implicitWaitofMinutes(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		}
		public void implicitWaitofMillis(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		}
		public void implicitWaitofSeconds(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
		public void waitForElementExplicitly(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
		
		public void waitForElementExplicitlyClikable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitForExplicitElementinvisibilityofAllElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOfAllElements(element));
		}
		
		public void waitForElementExplicitstalenessOf(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.stalenessOf(element));
		}
		public void waitForElementExpliciturlContains(WebDriver driver, String data)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.urlContains(data));
		}
		
		public void waitForElementExplicittitleContains(WebDriver driver, String data)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(data));
		}
		
		
}
