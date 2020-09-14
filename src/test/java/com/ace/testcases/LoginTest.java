package com.ace.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ace.base.pages.AcePage;
import com.ace.base.pages.Constants;
import com.ace.pages.manager.AllPropertiesPage;
import com.ace.pages.normal.LaunchPage;
import com.ace.pages.normal.LoginPage;
import com.ace.session.AceTestSession;
import com.ace.test.base.TestBase;
import com.ace.util.DataUtil;
import com.ace.dataprovider.TestDataProvider;




public class LoginTest extends TestBase{
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
	public void loginTest(Hashtable<String,String> data) {
		session.log(data.toString());
		if(!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			// skip in extent rep
			session.skipTest("Skipping the test as Runmode was NO");
			//skip - testng
			throw new SkipException("Skipping the test as Runmode was NO");
		}
		
		String username = data.get("Username");
		String password=data.get("Password");
		String userNameValid=data.get("UsernameValid");

		AcePage page=	new LaunchPage()
						.openBrowser("Chrome")
						.goToLoginPage()
						.gotoHomePage(username,password);
		
		boolean allPropLink =  page.validator(false).isElementPresent(Constants.ALLPROPTAB_LINK_LOCATOR);	
		
		 if(!allPropLink & userNameValid.equals("Y")) {
		    	// failure
		    	page.validator(true).fail("Cannot Login "+ userNameValid);
		    }
		 else if(allPropLink ) {
		    	if(userNameValid.equals("N")) {
		    	// failure
		    		
		    			page.validator(true).fail("Able to enter and submit with invalid username as userNameValid field is  "+ userNameValid);
		    	}else {
		    		//proceed with password entry and login
		    		page.validator(false).validateText(Constants.ALLPROPTAB_LINK_LOCATOR, "All Properties");
		    		session.log("Password submitted");
		    	}
		    }
		 else if(!allPropLink & userNameValid.equals("N") ) {
			 session.log("Cannot proceed with innvalid username/password");
		 }
					
		//calling assertAll
		session.end();
	
	}
			 
//	@AfterMethod
//	public void end() {
//		session.getCon().getCurrentDriver().quit();
//		session.genrateReport();
//		
//	}
			 
	
}
