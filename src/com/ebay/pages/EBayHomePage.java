package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Locators;

public class EBayHomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public EBayHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver, 15);
	}
	
	//Elements
	@FindBy (how = How.XPATH, using = Locators.SEARCH_TXT_XPATH)
	WebElement searchTxt;
	
	@FindBy (how = How.XPATH, using = Locators.SEARCH_BTN_XPATH)
	WebElement searchBtn;	
		
	
	@FindBy (how = How.XPATH, using = Locators.GEO_LINK_XPATH)
	WebElement geoLink;
	
	@FindBy (how = How.XPATH, using = Locators.CURR_LANGUAGE_XPATH)
	WebElement currLangLink;
	
	@FindBy(how = How.XPATH, using = Locators.EN_LINK_XPATH)
	WebElement enLink;
	
	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	/**Inserts an article name in the search box and hits enter
	 * @param article
	 * 		The article name
	 */
	public void searchArticle(String article) {
		searchTxt.clear();
		searchTxt.sendKeys(article);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();		
		System.out.println("Article '" + article + "' sent.");
	}
	
	/**Only sets EBay language to English if not already set
	 * 
	 */
	public void setLanguage() {
		//For now only English is supported
		String cLang = currLangLink.getText();
		if(!cLang.contains("English")) {
			Actions action = new Actions(driver);
			action.moveToElement(geoLink).build().perform();			
			wait.until(ExpectedConditions.elementToBeClickable(enLink)).click();
			searchTxt.click();
		}				
	}

}
