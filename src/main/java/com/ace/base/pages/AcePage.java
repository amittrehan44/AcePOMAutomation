package com.ace.base.pages;

import com.ace.web.WebConnector;

public interface AcePage {
	
	//normal browser functions
	AcePage openBrowser(String browser);
	 void quit();
	 void getTotalWindows();
	// AceTestSession getSession();
	 void wait(int time);
	 void waitForPageToLoad();
	
	//Zoho based normal Functions
	 AcePage goToLoginPage();
	 WebConnector validator(boolean stopExecution);
	
	// session based functions
	 void logout();
	// ZohoPage validateIntermediatePageOptions();
	 //Header getHeader();
	 
	 //reports
	 void log(String message);
	 

}
