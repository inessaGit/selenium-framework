package demo.priceless.test.actions;

import java.awt.AWTException;
import java.awt.Robot;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class TestDragAndDrop extends BaseTest {
	@Test
	public void testDragAndDrop() throws AWTException {
		// Create a WebDriver object
		WebDriver driver = DriverManager.getWebDriver();
		// open the web url
		driver.get("https://www.priceless.com/");
		// scroll to the end of the page
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("document.getElementById('logInBtn').scrollIntoViewIfNeeded()");

		WebElement source = driver.findElement(By.id("top-logo"));
		//relative xpath
	//	WebElement emailField = driver.findElement(By.xpath("//input[@type = 'email']"));

		WebElement homeLogo = driver.findElement(By.xpath("//img[@alt='Priceless Homepage']"));
				 //exact text
				// driver.findElement(By.xpath("//*[text() = 'foobar']"));
		//driver.findElement(By.xpath("//*[contains(@title,'foobar') or contains(.,'foobar')]"));
		WebElement target = driver.findElement(By.xpath("//p[text() = 'Interests']"));

// using Robot, move the mouse pointer to the target element
// This is required, as the drop happens onto the location where the move
// pointer is currently placed
				Robot robot = new Robot();

// get co-ordinates to the center of the target element

		Long height = (Long) jsDriver.executeScript("return window.innerHeight");
		System.out.println();

		System.out.println(ReflectionToStringBuilder.toString(driver.manage().window().getSize()));
		System.out.println(ReflectionToStringBuilder.toString(target.getLocation()));
		System.out.println(ReflectionToStringBuilder.toString(target.getRect()));

		int x = target.getLocation().getX() + target.getRect().getWidth() / 2;
		int y = target.getLocation().getY() + target.getRect().getHeight() - height.intValue();

// move the mouse pointer to the co-ordinates
		robot.mouseMove(x, y);

// perform drag-drop
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();



	}

}
