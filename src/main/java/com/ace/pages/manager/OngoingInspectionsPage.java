package com.ace.pages.manager;

import org.openqa.selenium.By;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class OngoingInspectionsPage extends AceBasePage {
	
	public AcePage goToViewEditInspection(String address){
		log("Click View/Edit Inpection Button next to address that contains:- "+address);
		System.out.println(address);
		//String editInspectionBtnXpath = "//td[contains(text()[preceding-sibling::br],'"+address+"')]/../td/a[@id='viewEditLink']";
		String editInspectionBtnXpath = "//td[contains(text()[preceding-sibling::br],'"+address+"')]/../td[6]/a";
		System.out.println(editInspectionBtnXpath);
		wait(1);
		getCurrentDriver().findElement(By.xpath(editInspectionBtnXpath)).click();
		return new ViewEditInspectionPage();
	}

}
