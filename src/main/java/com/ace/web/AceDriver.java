package com.ace.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class AceDriver implements WebConnector {
	 WebDriver driver;

	public void openBrowser(String browser) {
		//log("Opening Brwsercinside class ZohoDriver > openBrowser: "+browser);
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "/Users/amit/Documents/Selenium/chromedriver");
		driver = new  ChromeDriver();
		//driver.register(new ZohoEventListner());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	public void navigate(String url) {
		driver.get(url);
		
	}

}
