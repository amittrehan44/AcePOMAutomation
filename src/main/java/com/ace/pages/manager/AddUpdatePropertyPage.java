package com.ace.pages.manager;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;

public class AddUpdatePropertyPage extends AceBasePage {
	@FindBy (id="tenantName")
	WebElement tenantName;
	
	@FindBy (id="tenantPhone")
	WebElement tenantPhone;
	
	@FindBy (id="tenantEmail")
	WebElement tenantEmail;
	
	@FindBy (id="streetAddress1")
	WebElement streetAddress1;
	
	@FindBy (id="streetAddress2")
	WebElement streetAddress2;
	
	@FindBy (id="city")
	WebElement city;
	
	@FindBy (id="postalCode")
	WebElement postalCode;
	
	@FindBy (id="selectPropertyType")
	WebElement selectPropertyType;
	
	@FindBy (id="saveBtn")
	WebElement saveBtn;
	
	@FindBy (xpath="//[@id='toast-container']/div")
	WebElement saveRibbon;
	
	
	public AcePage addProperty(Hashtable<String,String> data) {
		tenantName.sendKeys(data.get("TenantName"));
		tenantPhone.sendKeys(data.get("TenantPhone"));
		tenantEmail.sendKeys(data.get("TenantEmail"));
		streetAddress1.sendKeys(data.get("StreetAddress1"));
		city.sendKeys(data.get("City"));
		postalCode.sendKeys(data.get("PostalCode"));
		select(selectPropertyType, data.get("PropertyType"));
		saveBtn.click();

		
		return new AllPropertiesPage();
	}
	
	public AcePage editProperty(Hashtable<String,String> data) {
		
		tenantName.clear();
		tenantName.sendKeys(data.get("TenantName"));
		tenantPhone.clear();
		tenantPhone.sendKeys(data.get("TenantPhone"));
		tenantEmail.clear();
		tenantEmail.sendKeys(data.get("TenantEmail"));
		streetAddress1.clear();
		streetAddress1.sendKeys(data.get("StreetAddress1"));
		city.clear();
		city.sendKeys(data.get("City"));
		postalCode.clear();
		postalCode.sendKeys(data.get("PostalCode"));
		select(selectPropertyType, data.get("PropertyType"));
		saveBtn.click();
		return new AllPropertiesPage();
	}
	
	public AcePage bookInspection() {
		return new AssignInspectorModalPage();
	}

}
