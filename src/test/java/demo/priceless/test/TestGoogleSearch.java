package demo.priceless.test;

import demo.priceless.BaseTest;
import demo.priceless.pages.GoogleSearch;
import demo.priceless.pages.SearchResults;
import demo.priceless.webdriver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGoogleSearch extends BaseTest {

	@Test
	public void testGoogleSearch() {

		GoogleSearch search = new GoogleSearch(DriverManager.getWebDriver()).get();
		SearchResults results = search.search("educative");
		results.nextPage();
	}

	@Test
	public void testGoogleSearchFailure() {

		GoogleSearch search = new GoogleSearch(DriverManager.getWebDriver()).get();
		search.search("educative");
		Assert.fail("failing the test to take screenshot");
	}

}
