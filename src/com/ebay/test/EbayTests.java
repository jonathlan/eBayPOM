package com.ebay.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class EbayTests extends EbayTestBasePOM {
	
	@Test
	@FileParameters("./data/ebayparams.csv")
	public void test1(String browser, String article) {
		setUpPhase2(browser, jProp.get("MAIN_URL").asString());
		eHomePage.setLanguage();
		eHomePage.searchArticle(article);
		assertTrue("Article not found", eSearchResultsPage.isArticleFound(article));
	}

}
