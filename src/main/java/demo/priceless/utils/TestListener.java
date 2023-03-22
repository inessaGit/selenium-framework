package demo.priceless.utils;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

/*
 * TO USE THIS CLASS:
 *Option 1: put this annotation before you class where you define your test methods
 * @Listeners({ demo.priceless.utils.TestListener.class }
 * Option 2: create a testng.xml and add listeners tag in XML.
 *
 * public class TestListener extends BaseTest implements ITestListener {
 */
public class TestListener implements ITestListener {
    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    //png attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
    @Override //it is already included in BaseTest;
    public void onTestFailure(ITestResult iTestResult) {
        LOG.info(getTestMethodName(iTestResult) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
       // WebDriver driver = ((BaseTest) testClass).getDriver();
        WebDriver driver = DriverManager.getWebDriver();
        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        LOG.info("I am in onStart method " + iTestContext.getName());
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        LOG.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info(getTestMethodName(iTestResult) + " test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info(getTestMethodName(iTestResult) + " test is succeed.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.info(getTestMethodName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOG.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}