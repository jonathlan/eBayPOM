package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayHomePage {
	WebDriver driver;
	
	public EBayHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	WebElement seachTxt; // //input[contains(@class, 'gh-tb ui-autocomplete-input')]
	WebElement searchBtn; // //input[@class= 'btn btn-prim gh-spr']	
	
	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	public void searchArticle(String article) {
		
	}

}
