package com.ebay.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ebay.pages.EBayArticlePage;
import com.ebay.pages.EBayHomePage;
import com.ebay.pages.EBaySearchResultsPage;

import helpers.CustomProperties;

public class EbayTestBasePOM {	
	protected WebDriver driver = null;
	protected EBayArticlePage eArticlesPage;
	protected EBayHomePage eHomePage;
	protected EBaySearchResultsPage eSearchResultsPage;
	protected CustomProperties properties = new CustomProperties();
	protected Properties eProp;

	@Before
	public void setUp() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		/*Load Properties*/
		eProp = properties.LoadProperties("./data/properties.xml");
		
		/*Driver setup*/
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications --start-maximized");
		System.setProperty(eProp.getProperty("CHROME_DRIVER_NAME"), 
				eProp.getProperty("GENERIC_DRIVER_LOCATION") + eProp.getProperty("CHROME_DRIVER_EXE"));
		driver = new ChromeDriver(ops);			
		driver.get(eProp.getProperty("MAIN_URL"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/*Pages setup*/
		eArticlesPage = new EBayArticlePage(driver);
		eHomePage = new EBayHomePage(driver);
		eSearchResultsPage = new EBaySearchResultsPage(driver);
	}
}
