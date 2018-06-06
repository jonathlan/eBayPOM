package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBaySearchResultsPage {
WebDriver driver;
	
	public EBaySearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	WebElement maxPriceTxt; // id='e1-14'
	WebElement conditionNewCbx; // //input[@aria-label='Nuevo']
	WebElement resultsTbl; // id='Results'
	WebElement articleLbl; // //li[@class = 'sresult lvresult clearfix li shic']
	WebElement articlePriceLbl; // //li[@class='lvprice prc']/span[contains(., '37.40')]
	
	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	public void addMaxPriceFilter(int price) {
		
	}
	
	public void setArticleState(String state) {
		
	}
	
	public void findBestPrice(String article, int price) {
		
	}
	
	public void selectArticle(String article, int price) {
		
	}

}
