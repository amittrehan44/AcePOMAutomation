package com.ace.pages.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class AllPropertiesPage extends AceBasePage {
	
	
	@FindBy (xpath="//button[@routerLink='/propertyInput/0']")
	WebElement addPropertyBtn;
	
	@FindBy (id="viewPropertyLink")
	WebElement viewPropertyBtn;
	
	@FindBy (id="insoectionRemindersLink")
	WebElement inspectioReminderLink;
	
	@FindBy (id="ongoingInsoectionsLink")
	WebElement ongoingInspectionLink;
	
	public AcePage goToAddPropertyPage() {
		log("Click Add Property Button");
		addPropertyBtn.click();

		return new AddUpdatePropertyPage();		
	}
	
	public AcePage goToViewProperty(String address) {
		log("Click View Property Button");
		System.out.println(address);
		String viewPropertyBtnXpath = "//td[contains(text(),'"+address+"')]/../td[1]/a";
		System.out.println(viewPropertyBtnXpath);
		getCurrentDriver().findElement(By.xpath(viewPropertyBtnXpath)).click();

		return new ViewPropertyPage();		
	}
	
	public AcePage goToInspectionRemindersPage() {
		log("Click Inspection Reminders Link");
		inspectioReminderLink.click();
		return new InspectionRemindersPage();
	}
	
	public AcePage goToOngoingInspectionPage() {
		log("Click Ongoing Inspection Link");
		ongoingInspectionLink.click();
		return new OngoingInspectionsPage();
	}


}
