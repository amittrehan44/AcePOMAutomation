package com.ace.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ace.base.pages.AcePage;
import com.ace.session.AceTestSession;



public abstract class AceValidationDriver implements WebConnector {
	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}
	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}
	public void assertAll() {
		//take screenshot
		softAssert.assertAll();
	}
	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}
	
	public AcePage validateTitle(String expectedTitle) {
		log("Expedted Title "+ expectedTitle);
		log("Actual Title "+ driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		//System.out.println("validateTitle Status is:- "+ isStopExecution());
		if(!expectedTitle.equals(driver.getTitle())) {
			fail("Titles Do Not Match. EXPECTED: "+expectedTitle+" ACTUAL: "+driver.getTitle());
			
		}
		
		return getSession().getCurrentPage();
		
	}
	
	public AcePage validateText(By locator, String expectedText) {
		//getSession().setExecuteListener(false);
		log("validateText");
		String actualText = driver.findElement(locator).getText();
		log("Actual Text {"+actualText+"}. Expected Text {"+expectedText+"}");
			if(!expectedText.equals(actualText)) {
				fail("Text not matching "+actualText);
			}
		
		
		return getSession().getCurrentPage();
		
	}
	
	public AcePage validateElementPresent(By locator) {
		log("Validating element presence "+ locator);
		if(!isElementPresent(locator))
			fail("Element not found: "+locator);
		
		return getSession().getCurrentPage();
		
	}
	
	//true - present
	//false - not present
	public boolean isElementPresent(By locator) {
			getSession().setExecuteListener(false);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			}catch(TimeoutException e) {
				getSession().setExecuteListener(true);
				log("Element not found "+locator);
				return false;
			}
			getSession().setExecuteListener(true);
			log("Element found success fully "+locator);
			return true;
			
	}
	
	public AceTestSession getSession() {
		return (AceTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public void fail(String message) {
		//fail in reports and 
		//take screenshot
		getSession().failTest(message);
		
		//fail in testng
		softAssert.fail(message);
		
		//decide - if execution stop in testng
		if(stopExecution) {
			assertAll();
		}
		
		
		
	}
	
	public void log(String message) {
		getSession().log(message);
	}




}
