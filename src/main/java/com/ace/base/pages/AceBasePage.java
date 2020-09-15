package com.ace.base.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ace.session.AceTestSession;
import com.ace.web.WebConnector;


public class AceBasePage implements AcePage {
	
	public AceBasePage() {
		PageFactory.initElements(getCurrentDriver(), this);
		getSession().setCurrentPage(this);
	}
	public EventFiringWebDriver getCurrentDriver() {
		
		return getSession().getCon().getCurrentDriver();
	}
	
	public void select(WebElement e, String textToSelect) {
		Select s = new Select(e);
		s.selectByVisibleText(textToSelect);
	}
	public void selectFirstOption(WebElement e) {
		Select s = new Select(e);
		s.selectByIndex(2);
	}
	
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
		getSession().getCon().setStopExecution(stopExecution);
		
		return getSession().getCon();
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public void log(String message) {
		getSession().log(message);
		
	}
	
	public AceTestSession getSession() {
		return (AceTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	public AcePage gotoHomePage(String u, String p) {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage goToAddPropertyPage() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage addProperty(Hashtable<String,String> data) {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage editProperty(Hashtable<String,String> data) {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage bookInspection() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage editInspector() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage assignInspector() {
		// TODO Auto-generated method stub
		return null;
	}
	public  AcePage openAssignInsoectorModalPage(String address)  {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage goToViewEditInspection() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage editInspection() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage approveInspection() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage goToViewProperty(String address) {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage goToEditProperty() {
		// TODO Auto-generated method stub
		return null;
	}
	public AcePage goToInspectionRemindersPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
