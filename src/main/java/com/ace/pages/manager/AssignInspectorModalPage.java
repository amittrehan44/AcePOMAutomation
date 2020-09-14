package com.ace.pages.manager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class AssignInspectorModalPage extends AceBasePage {
	@FindBy (id="viewPropertyLink")
	WebElement viewPropertyBtn;
	
	@FindBy (id="insoectionRemindersLink")
	WebElement inspectioReminderLink;
	
	public AcePage assignInspector() {
		//selectFirstOption(viewPropertyBtn);
		return new InspectionRemindersPage();
		
	}

}
