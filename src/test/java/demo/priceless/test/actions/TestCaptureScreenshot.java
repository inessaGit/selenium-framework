package demo.priceless.test.actions;

import java.io.File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;

public class TestCaptureScreenshot extends BaseTest {
	//@Test
	public void testTakeScreenshotOfWholeWindow() {
		WebDriver driver = DriverManager.getWebDriver();
		driver.get("https://www.priceless.com/sports");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("screenshot.png");
		source.renameTo(destination);
		System.out.println("screenshot saved at " + destination.getAbsolutePath());

		Assert.assertTrue(destination.exists(), "screenshot file does not exist");
		Assert.assertTrue(destination.length() > 0, "screenshot file size is zero");
	}

	@Test
	public void testTakeScreenshotOfWebElement() {
		// take screenshot of the WebElement
		WebDriver driver = DriverManager.getWebDriver();
		driver.get("https://www.priceless.com/sports");
		WebElement element = driver.findElement(By.xpath("//h1[text()='Sports']"));
		File source = element.getScreenshotAs(OutputType.FILE);
		File destination = new File("test-output/screenshot.png");
		source.renameTo(destination);

		System.out.println("screenshot saved at " + destination.getAbsolutePath());
		Assert.assertTrue(destination.exists(), "screenshot file does not exist");
		Assert.assertTrue(destination.length() > 0, "screenshot file size is zero");
	}
}
