package com.ace.test.base;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.ace.session.AceTestSession;
import com.ace.util.Xls_Reader;


public class TestBase {
	
	public AceTestSession session;
	public String testName=null;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	public void init(ITestResult result) {
		System.out.println("@BeforeMethod");
		testName = result.getMethod().getMethodName().toUpperCase();
		System.out.println(testName);
		session= new AceTestSession();
		session.init(testName);
	}
	
	@AfterMethod
	public void quit() {
		session.genrateReport();
		session.getCon().quitDriver();
		
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") != null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", null);
		
	}
	
}
