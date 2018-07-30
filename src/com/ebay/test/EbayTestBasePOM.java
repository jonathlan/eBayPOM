package com.ebay.test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ebay.pages.EBayArticlePage;
import com.ebay.pages.EBayHomePage;
import com.ebay.pages.EBaySearchResultsPage;
import com.eclipsesource.json.JsonObject;

import helpers.CustomProperties;

public class EbayTestBasePOM {	
	protected WebDriver driver = null;
	protected EBayArticlePage eArticlesPage;
	protected EBayHomePage eHomePage;
	protected EBaySearchResultsPage eSearchResultsPage;
	protected CustomProperties properties = new CustomProperties();
	protected Properties eProp;
	protected JsonObject jProp;

	@Before
	public void setUpPhase1() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		/*Load Properties*/
		//eProp = properties.LoadProperties("./data/properties.xml");
		jProp = properties.loadFromJSon("./data/config.json");
	}
	
	protected void setUpPhase2(String browser, String url) {
		/*Driver setup*/
		assertTrue("There was a problem with driver initialization", driverSetup(browser));
		
		/*Open URL*/
		assertTrue("There was a problem opening the URL", openUrl(url));
		
		/*Pages setup*/
		eArticlesPage = new EBayArticlePage(driver);
		eHomePage = new EBayHomePage(driver);
		eSearchResultsPage = new EBaySearchResultsPage(driver);
	}
	
	private boolean driverSetup (String browser) {		
		switch (browser){
			case "Chrome":
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--disable-notifications");
				System.setProperty(jProp.get("CHROME_DRIVER_NAME").asString(), 
						jProp.get("GENERIC_DRIVER_LOCATION").asString() + jProp.get("CHROME_DRIVER_EXE").asString());
				driver = new ChromeDriver(ops);				
			    break;
			case "Firefox":
				System.setProperty(jProp.get("FIREFOX_DRIVER_NAME").asString(), 
						jProp.get("GENERIC_DRIVER_LOCATION").asString() + jProp.get("FIREFOX_DRIVER_EXE").asString());
		        driver = new FirefoxDriver();
		        break;
			default:
				System.out.println("Driver cannot be initialized");
				driver = null;
				return false;		
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return true;
	}
	
	private boolean openUrl (String url) {
		if (driver != null) {			
			if (!url.isEmpty()) {
				driver.get(url);
				return true;
			}else {
				System.out.println("URL cannot be empty");
				return false;			
			}
		}else {
			System.out.println("Driver is not initialized");
			return false;
		}
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}		
	}
}
