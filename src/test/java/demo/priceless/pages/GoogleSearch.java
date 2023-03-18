package demo.priceless.pages;

import demo.priceless.pages.AbstractBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class GoogleSearch extends AbstractBasePage<GoogleSearch> {

	private static final String URL = "https://www.google.com";

	public GoogleSearch(WebDriver driver) {
		super(driver, "search-home.properties");
	}

	@Override
	protected void isLoaded() throws Error {
		driver.get(URL);
		super.isLoaded();
	}

	@Step
	public demo.priceless.pages.SearchResults search(String query) {
		LOG.info("searching query '{}'", query);
		driver.findElement(getLocator("search_field")).sendKeys(query, Keys.ENTER);
		return new demo.priceless.pages.SearchResults(driver).get();
	}

}
