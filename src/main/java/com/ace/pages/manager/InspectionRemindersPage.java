package com.ace.pages.manager;

import org.openqa.selenium.By;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class InspectionRemindersPage extends AceBasePage {
	
	
	public AcePage openAssignInsoectorModalPage(String address) {
			log("Click Assign Inspector Button next to address that contains:- "+address);
			System.out.println(address);
			String assignInspectorBtnXpath = "//td[contains(text(),'"+address+"')]/../td/a[@id='assignInspectorLink']";
			System.out.println(assignInspectorBtnXpath);
			getCurrentDriver().findElement(By.xpath(assignInspectorBtnXpath)).click();

			return new AssignInspectorModalPage();		
		}

	
	}
