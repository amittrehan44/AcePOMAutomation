package com.ace.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.ace.base.pages.AcePage;
import com.ace.base.pages.Constants;
import com.ace.pages.normal.LaunchPage;
import com.ace.reports.ExtentManager;
import com.ace.web.AceDriver;
import com.ace.web.WebConnector;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;




public class AceTestSession {
	WebConnector con;
	AcePage currentPage;
	ExtentReports reports;
	ExtentTest test;
	boolean executeListener = true;
	
	public AceTestSession() {
		con = new AceDriver();
	}
	
	public void init(String testName) {
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		//init reports
		reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		test = reports.createTest(testName);
		
		AcePage page = new LaunchPage();
		//return page;
	}
	
	public WebConnector getCon() {
		return con;
	}

	
	public AcePage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(AcePage currentPage) {
		this.currentPage = currentPage;
	}
	
	public void end() {
		
		 getCon().assertAll();
		 takeScreenShot();
		 
		 
	}
	
	/********Reporting Functions***********/
	public void log(String message) {
		test.log(Status.INFO, message);
	}
	
	public void genrateReport() {
		if(reports != null) {
			reports.flush();
		}
		
	}
	
	public void failTest(String failMessage) {
		//take screenshot of failure
		takeScreenShot();
		//fail in extent report
		test.log(Status.FAIL, failMessage);
		
	}
	
	// first take screenshot and then add it to reports
		public void takeScreenShot() {
			// fileName of the screenshot
					Date d=new Date();
					String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
					// take screenshot
					File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
					try {
						// get the dynamic folder name
						FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
						//put screenshot file in reports
						test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		
		public void skipTest(String message) {
			test.log(Status.SKIP, message);
		}
		
		public boolean isExecuteListener() {
			return executeListener;
		}

		public void setExecuteListener(boolean executeListener) {
			this.executeListener = executeListener;
		}
}
