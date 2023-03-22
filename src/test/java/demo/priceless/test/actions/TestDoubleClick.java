package demo.priceless.test.actions;
import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestDoubleClick extends BaseTest {

	@Test
	public void testDoubleClick() {

		// Create a WebDriver object
		WebDriver driver = DriverManager.getWebDriver();
		driver.get("https://www.priceless.com/");
		// scroll to the end of the page
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("document.getElementById('dbl-click').scrollIntoViewIfNeeded()");

		// Find the element and perform an operation
		WebElement source = driver.findElement(By.id("dbl-click"));

		Actions actions = new Actions(driver);
		actions.doubleClick(source).build().perform();

		// Wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertNotNull(alert, "alert on double-click did not appear");
		alert.accept();

	}
}
