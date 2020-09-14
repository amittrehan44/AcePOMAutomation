package com.ace.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ace.listener.AceEventListener;



public class AceDriver extends AceValidationDriver  {


	public void openBrowser(String browser) {
		log("Opening the browser "+browser );
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "/Users/amit/Documents/Selenium/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver());
		
		
		driver.register(new AceEventListener());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}

	public void navigate(String url) {
		driver.get(url);
		
	}
	
	public void quitDriver() {
		if(driver!=null)
		   driver.quit();
		
	}

	public EventFiringWebDriver getCurrentDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}
