package demo.priceless.temp;

import demo.priceless.BaseTest;
import demo.priceless.webdriver.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


 @Listeners({ demo.priceless.utils.SummaryReport.class })

         public class AllureScreenshotTest extends BaseTest {
   private  WebDriver driver;
    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    private byte[] allureScreenshot(WebDriver driver) {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        return screenshotDriver.getScreenshotAs(OutputType.BYTES);
    }
    @Test(description = "Screenshot taken in Step")
    public void screenshotInStepTest() {
        driver = DriverManager.getWebDriver();
        driver.get("https://www.priceless.com/shopping");
        step1();
        step2();
    }

    @Step("Step 1")
    public void step1(){
        System.out.println("step 1");
    }
    @Step("Step 2 with screenshot")
    public void step2(){
        System.out.println("step 2");
        allureScreenshot(driver);
    }
}
