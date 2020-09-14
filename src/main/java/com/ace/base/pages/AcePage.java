package com.ace.base.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;

import com.ace.web.WebConnector;

public interface AcePage {
	
	//normal browser functions
	AcePage openBrowser(String browser);
	 void quit();
	 void getTotalWindows();
	// AceTestSession getSession();
	 void wait(int time);
	 void waitForPageToLoad();
	 void select(WebElement e, String textToSelect);
	
	//Ace based normal Functions
	 AcePage goToLoginPage();
	 AcePage gotoHomePage(String userName, String password);
	 WebConnector validator(boolean stopExecution);
	
	 //Manager Functions
	 AcePage goToAddPropertyPage();
	 AcePage goToViewProperty(String address);
	 AcePage goToEditProperty();
	 AcePage goToInspectionRemindersPage();
	 AcePage addProperty(Hashtable<String,String> data);
	 AcePage editProperty(Hashtable<String,String> data);
	 AcePage bookInspection();
	 AcePage editInspector();
	 AcePage assignInspector();
	 AcePage openAssignInsoectorModalPage(String address);
	 AcePage goToViewEditInspection();
	 AcePage editInspection();
	 AcePage approveInspection();
	 
	
	 void logout();
	// ZohoPage validateIntermediatePageOptions();
	 //Header getHeader();
	 
	 //reports
	 void log(String message);
	 

}
