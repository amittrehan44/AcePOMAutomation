package com.ace.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.ace.session.AceTestSession;

public interface WebConnector {
	
	void openBrowser(String browser);
	void navigate(String url);
//	void quit();
//	void logout();
//	void validateLogin();
//	EventFiringWebDriver getCurrentDriver();
//	AceTestSession getSession();
//	boolean isStopExecution();
//	void setStopExecution(boolean stopExecution);
//	void assertAll();
//	SoftAssert getSoftAssert();
//	void setSoftAssert(SoftAssert softAssert);
//	void log(String message);
//	void fail(String message);

}
