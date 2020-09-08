package com.ace.testcases;

import org.testng.annotations.Test;

import com.ace.base.pages.AcePage;
import com.ace.pages.normal.LaunchPage;
import com.ace.session.AceTestSession;



public class LoginTest {

	@Test
	public void testCase1() {
	AceTestSession session= new AceTestSession();
	AcePage page = session.init()
					.openBrowser("Chrome")
					.goToLoginPage();
	
	} 
			 
			 

}
