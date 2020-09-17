package com.ace.suite.testcase.manager;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ace.base.pages.Constants;
import com.ace.dataprovider.TestDataProvider;
import com.ace.pages.normal.LaunchPage;
import com.ace.test.base.TestBase;
import com.ace.util.DataUtil;

public class UpdateInspectionTest extends TestBase{
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
	public void updateInspectionTest(Hashtable<String,String> data) {
		
		try {
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
			    .goToOngoingInspectionPage()
			    .goToViewEditInspection("ABC St")
				.clickEditInspoection()
				.editInspection(data)
			    .validator(true).validateElementPresent(Constants.SAVE_RIBBON_LOCATOR);
			    
				
				session.end();
			}
		catch(Exception e) {
				//Convert exception stacktrace to string and print it in reports
				 StringWriter sw = new StringWriter();
		         e.printStackTrace(new PrintWriter(sw));
		         String exceptionAsString = sw.toString();
		            
				Assert.fail(exceptionAsString);
			
			}
	}

}
