package com.ace.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.ace.base.pages.AcePage;
import com.ace.session.AceTestSession;


public interface WebConnector {
	
	void openBrowser(String browser);
	void navigate(String url);
	public void quitDriver();
//	void logout();
//	void validateLogin();
	AceTestSession getSession();
	boolean isStopExecution();
	void assertAll();
	SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void log(String message);
	void fail(String message);
	EventFiringWebDriver getCurrentDriver();
	void setStopExecution(boolean stopExecution);
	
	//Validation Funcitions

	AcePage validateTitle(String expectedTitle);
	AcePage validateText(By locator, String expectedTitle);
	AcePage validateElementPresent(By locator);
	boolean isElementPresent(By locator);


}
