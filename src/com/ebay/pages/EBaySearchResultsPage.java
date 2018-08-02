package com.ebay.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helpers.Locators;

public class EBaySearchResultsPage {
WebDriver driver;
	
	public EBaySearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//Elements
	WebElement maxPriceTxt; // id='e1-14'
	WebElement conditionNewCbx; // //input[@aria-label='Nuevo']
	
	@FindBy(how = How.ID, using = Locators.RESULTS_TBL_ID)
	WebElement resultsTbl; // id='Results'
	
	WebElement articleLbl; // //li[@class = 'sresult lvresult clearfix li shic']
	WebElement articlePriceLbl; // //li[@class='lvprice prc']/span[contains(., '37.40')]
	
	//Methods
	public boolean containsAllElements() {
		return false;
	}
	
	/**Looks for an article name inside the results section
	 * @param article
	 * 			The name of the article
	 * @return	
	 * 		TRUE if the article is found
	 * 		FALSE if the article is not found
	 */
	public boolean isArticleFound(String article) {
		List<WebElement> weArticle = resultsTbl.
				findElements(By.xpath
						(".//h3[contains(text(), '" + article + "')]"));
		if (weArticle.size() > 0)
			return true;
		else
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
