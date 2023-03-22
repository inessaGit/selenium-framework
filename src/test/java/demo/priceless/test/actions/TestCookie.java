package demo.priceless.test.actions;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCookie extends BaseTest {

	@Test
	public void testACookie() {
		// Create Webdriver instance
		WebDriver driver = DriverManager.getWebDriver();
		driver.get("https://www.priceless.com/");
		// Create and add a new cookie
		Cookie addCookie = new Cookie("newCookie", "pricelessCookie");
		driver.manage().addCookie(addCookie);
		// Get the already set cookie name
		String getCookieValue = driver.manage().getCookieNamed("newCookie").getValue();
		LOG.info("Cookie Value: " + getCookieValue);
		Assert.assertEquals(getCookieValue, "pricelessCookie");
		driver.manage().deleteCookieNamed("newCookie");

	}
}
