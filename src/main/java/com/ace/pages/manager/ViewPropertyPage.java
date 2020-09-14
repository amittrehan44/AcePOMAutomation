package com.ace.pages.manager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class ViewPropertyPage extends AceBasePage {
	
	@FindBy (id="editPropertyBtn")
	WebElement editPropertyBtn;
	
	public AcePage goToEditProperty() {
		log("Click Edit Property Button");
		editPropertyBtn.click();
		
		return new AddUpdatePropertyPage();
	}

}
