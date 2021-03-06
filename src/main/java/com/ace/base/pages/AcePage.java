package com.ace.base.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;

import com.ace.web.WebConnector;

public interface AcePage {
	
	//normal browser functions
	AcePage openBrowser(String browser);
	 void quit();
	 void getTotalWindows();
	 
	
	 void wait(int time);
	 void waitForPageToLoad();
	 
	 //common used functions
	 void select(WebElement e, String textToSelect);
	 void selectFirstOption(WebElement e);
	
	//Ace based normal Functions
	 AcePage goToLoginPage();
	 AcePage gotoHomePage(String userName, String password);
	 WebConnector validator(boolean stopExecution);
	
	 //Manager Functions
	 AcePage goToAddPropertyPage();
	 AcePage goToViewProperty(String address);
	 AcePage goToEditProperty();
	 AcePage goToInspectionRemindersPage();
	 AcePage goToOngoingInspectionPage();
	 AcePage addProperty(Hashtable<String,String> data);
	 AcePage editProperty(Hashtable<String,String> data);
	 AcePage bookInspection();
	 AcePage editInspector();
	 AcePage assignInspector();
	 AcePage openAssignInsoectorModalPage(String address);
	 AcePage goToViewEditInspection(String address);
	 AcePage editInspection(Hashtable<String,String> data);
	 AcePage attachReport(Hashtable<String,String> data);
	 AcePage approveInspection(Hashtable<String,String> data);
	 AcePage clickEditInspoection();
	 
	
	 void logout();
	// ZohoPage validateIntermediatePageOptions();
	 //Header getHeader();
	 
	 //reports
	 void log(String message);
	 

}
