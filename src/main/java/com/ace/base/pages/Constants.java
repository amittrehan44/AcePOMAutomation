package com.ace.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

public class Constants {
	

	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";
	
	public static final String DEFAULT_USERNAME="amit.trehan44@outlook.com";
	public static final String DEFAULT_PASWD="Password1234";
	
	public static final String SAVE_RIBBON="//div[@id='toast-container']/div";
	public static final By SAVE_RIBBON_LOCATOR=By.xpath(SAVE_RIBBON);
	
	public static final String APPROVE_INSPECTION_MESSAGE_XPATH="//div[@class='modal-body']/p";
	public static final By APPROVE_INSPECTION_MESSAGE_LOCATOR=By.xpath(APPROVE_INSPECTION_MESSAGE_XPATH);
	
	public static final String LOGIN_ID = "login_id";
	public static final By LOGIN_ID_LOCATOR=By.id(LOGIN_ID);
	
	public static final String ALLPROPTAB_LINK = "/html/body/app-root/app-manager-home/div[1]/a[1]";
	public static final By ALLPROPTAB_LINK_LOCATOR=By.xpath(ALLPROPTAB_LINK);
	
		// report path
		public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
		public static final How CSS_SEL = How.CSS;
		
		/// data
		public static final String[] intermediatePageOptions= {"Books","Connect","Mail","WorkDrive","Calendar","CRM","Meeting","Writer","Campaigns","Desk","Sheet","Cliq","Invoice","Show"};
		
		// sheet names
		public static final String TEST_STATUS_SHEET = "Test Status";
		
		//col names
		public static final Object COL_SUBJECT = "Subject";
		public static final Object COL_DATE = "Date";
		public static final String TCID = "TCID";
		public static final String RUNMODE = "Runmode";
	
}
