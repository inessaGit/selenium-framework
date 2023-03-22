package demo.priceless.test.actions;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestTitle extends BaseTest {

	@Test
	public void testTitle() {
		// Create a WebDriver object
		WebDriver driver = DriverManager.getWebDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver.get("https://www.priceless.com/sports");
		// Click the element to activate the alert
		driver.findElement(By.xpath("//span[text()='FILTER']\")")).click();
		// Wait for the alert to be displayed and switch to the alert popup
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Sports category"));

	}
}
