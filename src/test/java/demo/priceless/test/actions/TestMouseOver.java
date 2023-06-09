package demo.priceless.test.actions;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestMouseOver extends BaseTest {

	@Test
	public void testMouseOver() throws InterruptedException {

		// create the WebDriver object
		WebDriver driver = DriverManager.getWebDriver();

		// open the web URL
		driver.get("https://www.priceless.com");

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

		// Scroll down to the bottom of the page
		jsDriver.executeScript("document.getElementById('mouseover').scrollIntoViewIfNeeded()");

		WebElement source = driver.findElement(By.id("mouseover"));
		Actions action = new Actions(driver);
		action.moveToElement(source).build().perform();

		Assert.assertTrue("Hover Over Text".equalsIgnoreCase(source.getAttribute("title")));

		// adding sleep to see the mouse over text
		Thread.sleep(5000);

	}
}
