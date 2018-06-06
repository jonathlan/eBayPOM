package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayArticlePage {
	WebDriver driver;
	
	public EBayArticlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	WebElement articleLbl; // id='itemTitle'
	WebElement conditionLbl; // //*[@class = 'u-flL condText  ']
	WebElement convertedPriceLbl; // id='convbidPrice'  // //*[@id = 'convbidPrice' and contains(., '37.40')]
	WebElement addToCartBtn; // id='isCartBtn_btn'

	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	public void isValidArticle(String article, int price) {
		
	}
	
	public void addToCart(String article, int price) {
		
	}

}
