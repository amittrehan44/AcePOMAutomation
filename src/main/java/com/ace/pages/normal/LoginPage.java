package com.ace.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ace.base.pages.AceBasePage;
import com.ace.base.pages.AcePage;
import com.ace.base.pages.Constants;
import com.ace.pages.manager.AllPropertiesPage;


public class LoginPage extends AceBasePage {
	@FindBy (xpath="/html/body/app-root/app-login/body/form/button[2]")
	WebElement emailLoginButton;
	
	@FindBy (xpath="//button[@class='btn btn-secondary newUser']")
	WebElement newUser;
	
	@FindBy (id="inputEmail")
	WebElement inputEmail;
	
	@FindBy (id="inputPassword")
	WebElement inputPassword;
	
	@FindBy (xpath="//*[@id='collapseExample']/div/button")
	WebElement siginBtn;
	
	
	
	public AcePage gotoHomePage(String userName, String password) {
	
		//newUser.click();
		log("Login with username and password:- "+userName+" / "+password);
		emailLoginButton.click();
		inputEmail.sendKeys(userName);
		inputPassword.sendKeys(password);
		siginBtn.click();
		
		
		return new AllPropertiesPage();
		
	}

}
