package com.ace.session;

import org.testng.Reporter;

import com.ace.base.pages.AcePage;
import com.ace.pages.normal.LaunchPage;
import com.ace.web.AceDriver;
import com.ace.web.WebConnector;


public class AceTestSession {
	WebConnector con;
	
	public AceTestSession() {
		con = new AceDriver();
	}
	
	public AcePage init() {
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		//init reports
		//reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		//test = reports.createTest(TestName);
		
		AcePage page = new LaunchPage();
		return page;
	}
	
	public WebConnector getCon() {
		return con;
	}

}
