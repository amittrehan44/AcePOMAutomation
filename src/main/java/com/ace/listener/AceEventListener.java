package com.ace.listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ace.session.AceTestSession;
import com.ace.web.WebConnector;


public class AceEventListener extends AbstractWebDriverEventListener {
	
	public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
//		System.out.println("Before finding element "+locator);
//		System.out.println("Before finding element "+element);
//		System.out.println("Before finding element "+driver);
//		
		//System.out.println("isExecuteListener is:-  "+getSession().isExecuteListener());
		if(getSession().isExecuteListener()) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			//wait.unitl(ExpectedConditions.el)
		}
		catch(TimeoutException e) {
			getDriver().fail("Element not foundd:- "+locator);
			System.out.println("Element not foundd:- "+locator+"with Error: "+e);
			getDriver().assertAll();
		}
		catch(NoClassDefFoundError e) {
			getDriver().fail("Element not foundd:- "+locator);
			System.out.println("Element not foundd:- "+locator+"with Error: "+e);
			getDriver().assertAll();
			
		}
		catch(Exception e) {
			System.out.println("Element not foundd and cannot caugh with any specific exception:- "+locator+"with Error: "+e);
			getDriver().fail("Issue with element "+locator+ "  "+e);
			getDriver().assertAll();
		}
		}
	}
	
	public WebConnector getDriver() {
		return getSession().getCon();
	}
	
	public AceTestSession getSession() {
		return (AceTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public void log(String message) {
			getSession().log(message);
	}
		

}
