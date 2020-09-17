package com.ace.suite.testcase.manager;

import org.testng.annotations.Test;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ace.base.pages.AcePage;
import com.ace.base.pages.Constants;
import com.ace.dataprovider.TestDataProvider;
import com.ace.pages.normal.LaunchPage;
import com.ace.test.base.TestBase;
import com.ace.util.DataUtil;

public class UpdatePropertyTest extends TestBase{
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
	public void updateProertyTest(Hashtable<String,String> data) {
		session.log(data.toString());
		if(!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			// skip in extent rep
			session.skipTest("Skipping the test as Runmode was NO");
			//skip - testng
			throw new SkipException("Skipping the test as Runmode was NO");
		}
		
		new LaunchPage()
	    .openBrowser("chrome")
	    .goToLoginPage()
	    .gotoHomePage(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASWD)
	    .goToViewProperty("ABC St")
	    .goToEditProperty()
	    .editProperty(data);
	    
		
		session.end();
	}

}
