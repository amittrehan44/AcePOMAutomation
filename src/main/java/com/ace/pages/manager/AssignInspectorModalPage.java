package com.ace.pages.manager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class AssignInspectorModalPage extends AceBasePage {
	@FindBy (id="selectInspector")
	WebElement selectInspector;
	
	@FindBy (id="saveBtn")
	WebElement saveBtn;
	
	public AcePage assignInspector() {
		log("Select Inspector from dropdownlist");
		//selectFirstOption(selectInspector);
		select(selectInspector,"Amit - 7787792744");
		saveBtn.click();
		return new InspectionRemindersPage();
		
	}

}
