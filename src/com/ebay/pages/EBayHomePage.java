package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helpers.Locators;

public class EBayHomePage {
	WebDriver driver;
	
	public EBayHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//Elements
	@FindBy (how = How.XPATH, using = Locators.SEARCH_TXT_XPATH)
	WebElement searchTxt;
	
	@FindBy (how = How.XPATH, using = Locators.SEARCH_BTN_XPATH)
	WebElement searchBtn;	
	
	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	public void searchArticle(String article) {
		searchTxt.clear();
		searchTxt.sendKeys(article);
		
		searchBtn.click();
		System.out.println("Article '" + article + "' sent.");
	}

}
