package com.ace.pages.normal;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;
import com.ace.session.AceTestSession;


public class LaunchPage extends AceBasePage {
	
	public AcePage openBrowser(String Browser) {;
		//log("OpenBrowser in LaunchPage class");
		AceTestSession session = getSession();
		session.getCon().openBrowser(Browser);
		return this;
	}
	
	public AcePage goToLoginPage() {
		log("Go To Home page from Launch Page");
		AceTestSession session = getSession();
		session.getCon().navigate("https://acepropdev.web.app");
		return new LoginPage();
	}

}
