package com.ace.pages.manager;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;
import com.ace.base.pages.Constants;

public class ViewEditInspectionPage extends AceBasePage{
	@FindBy (id="editBtn")
	WebElement editBtn;
	
	@FindBy (name="status")
	WebElement inspectionStatus;
	
	@FindBy (id="selectType")
	WebElement selectType;
	
	@FindBy (id="inspectionDate")
	WebElement inspectionDate;
	
	@FindBy (id="inputFile")
	WebElement inputFile;
	
	@FindBy (id="managerNotes")
	WebElement managerNotes;
	
	@FindBy (id="saveBtn")
	WebElement saveBtn;
	
	@FindBy (xpath="//*[@id='existingReportLink']/../button")
	WebElement deleteFileBtn;
	
	@FindBy (xpath="//*[@class='modal-footer']/button[1]")
	WebElement deleteConfirmationBtn;
	
	@FindBy (id="approveBtn")
	WebElement approveBtn;
	
	@FindBy (id="approvalYesBtn")
	WebElement approvalYesBtn;
	
	
	
	
	public AcePage clickEditInspoection() {
		editBtn.click();
		return this;
		
	}
	public AcePage editInspection(Hashtable<String,String> data) {
		select(selectType, data.get("InspectionType"));
		managerNotes.clear();
		managerNotes.sendKeys(data.get("ManagerNotes"));
		inspectionDate.clear();
		inspectionDate.sendKeys(data.get("InspectionDate"));
		saveBtn.click();
		return new OngoingInspectionsPage();
		
	}
	
	public AcePage attachReport(Hashtable<String,String> data) {
		//if there is no report attached already
		if(getSession().getCon().isElementPresent(By.id("inputFile"))) {
			inputFile.sendKeys("/Users/amit/Downloads/test.jpg");
			saveBtn.click();
		}
		//if there is  report attached already, the delete and attach again
		else if(getSession().getCon().isElementPresent(By.id("existingReportLink"))) {
			deleteFileBtn.click();
			deleteConfirmationBtn.click();
			inputFile.sendKeys("/Users/amit/Downloads/test.jpg");
			wait(5);
			saveBtn.click();
			
		}
		else {
			getSession().getCon().fail("not on correct page");
		}
		return this;
	}
	
	public AcePage approveInspection(Hashtable<String,String> data) {
		
		//check if inspection is scheduled
		if(getSession().getCon().isElementPresent(By.xpath("//*[contains(text(),' Not Scheduled')]"))) {
			//Enter schedule date before approving
			System.out.println("Inspection Not Schudled");
			getSession().log("Inspection Not Schudled, so need to edit inspection and save Inspection date first ");
			clickEditInspoection();
			editInspection(data).goToViewEditInspection("ABC St");
		}
		else {
			System.out.println("We can approve this");
			//String getDate = getSession().getCon().getCurrentDriver().findElement(By.xpath("//div[@id='InspectionDateTime']/div[2]")).getText();
			//System.out.println(getDate);
			
		}
		approveBtn.click();
		wait(1);
		validator(true).validateText(Constants.APPROVE_INSPECTION_MESSAGE_LOCATOR, "Are you sure you want to Approve Inspection?");
		approvalYesBtn.click();
		return new OngoingInspectionsPage();
			
		}
}
