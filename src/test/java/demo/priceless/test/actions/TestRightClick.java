package demo.priceless.test.actions;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestRightClick extends BaseTest {

	@Test
	public void testRightClick() throws InterruptedException {

		// create a WebDriver object
		WebDriver driver = DriverManager.getWebDriver();

		// Open the web URL
		driver.get("https://www.priceless.com");

		WebElement source = driver.findElement(By.id("prompt"));
		Actions actions = new Actions(driver);

		actions.contextClick(source).build().perform();

		// adding sleep explicitly to let users see the context menu that appears on
		// right click. Otherwise, it is not required
		Thread.sleep(2000);
	}
}
