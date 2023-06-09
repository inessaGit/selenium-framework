package demo.priceless.test.actions;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckBox extends BaseTest {
	@Test
	public void testCheckBox() {
		WebDriver driver = DriverManager.getWebDriver();
		driver.get("https://www.priceless.com/");
		// Create a Javascript executor object.
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		// Scroll down to the element
		jsDriver.executeScript("document.getElementById('checked').scrollIntoViewIfNeeded()");
		WebElement checked = driver.findElement(By.id("checked"));
		// Assert that if it's already selected
		Assert.assertFalse(checked.isSelected());
		// find the element to avoid any Stale element exception before performing
		// any new operation
		checked = driver.findElement(By.id("checked"));
		checked.click();
		// find the element to avoid any Stale element exception before performing
		// any new operation
		checked = driver.findElement(By.id("checked"));
		// Assert the selection
		Assert.assertTrue(checked.isSelected());
	}

}
