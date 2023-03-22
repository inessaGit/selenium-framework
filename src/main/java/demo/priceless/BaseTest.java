package demo.priceless;

import static demo.priceless.webdriver.DriverFactory.createInstance;
import static demo.priceless.webdriver.DriverManager.getWebDriver;
import static demo.priceless.webdriver.DriverManager.setWebDriver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import demo.priceless.utils.ConfigurationManager;
import demo.priceless.webdriver.DriverFactory;
import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import demo.priceless.utils.ConfigurationManager;
import demo.priceless.webdriver.DriverManager;

import io.qameta.allure.Attachment;

/**
 * This is the super class of all TestClasses
 */
public abstract class BaseTest {
	private static final String DEFAULT_BROWSER = ConfigurationManager.getInstance().getProperty("browser");
	protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

	@BeforeMethod
	public void setUp(Method method) {
		if (DriverManager.getWebDriver() == null) {
			boolean isMobile = method.getName().toLowerCase().contains("mobile")
					|| method.getDeclaringClass().getName().toLowerCase().contains("mobile");
			DriverManager.setWebDriver(DriverFactory.createInstance(DEFAULT_BROWSER, isMobile));
		}
	}

	@AfterMethod
	public void closeDriver(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
			takeScreenshot(DriverManager.getWebDriver(), getScreenshotFileName(result));
			//attach screenshot to allure report on test failure
		}
		DriverManager.closeDriver();
	}

	private String getScreenshotFileName(ITestResult result) {
		return String.format("%s_%s.png", result.getTestClass().getRealClass().getSimpleName(),
				result.getMethod().getMethodName())
				.toLowerCase();
	}

	private void takeScreenshot(WebDriver driver, String file) {
		if (driver != null) {
			byte[] bytes = getScreenshot(driver);
			Path path = Paths.get(ConfigurationManager.getInstance().getProperty("screenshot_directory"), file);
			if (!path.toFile().getParentFile().exists()) {
				path.toFile().getParentFile().mkdirs();
			}
			try {
				Files.write(path, bytes);
				LOG.info("saving screenshot to {}", path.toAbsolutePath().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
	private byte[] getScreenshot(WebDriver driver) {
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
		return screenshotDriver.getScreenshotAs(OutputType.BYTES);
	}

}