package com.ace.base.pages;

import org.testng.Reporter;

import com.ace.session.AceTestSession;
import com.ace.web.WebConnector;


public class AceBasePage implements AcePage {

	public AcePage openBrowser(String browser) {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub
		
	}

	public void wait(int time) {
		// TODO Auto-generated method stub
		
	}

	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		
	}

	public AcePage goToLoginPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebConnector validator(boolean stopExecution) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public void log(String message) {
		// TODO Auto-generated method stub
		
	}
	
	public AceTestSession getSession() {
		return (AceTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

}
