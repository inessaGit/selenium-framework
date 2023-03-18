package demo.priceless.temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void testSetUp(){

        //workaround for bug https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver  = new ChromeDriver(options);


        baseUrl = "https://www.priceless.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLoadPage(){

      driver.get(baseUrl);
      driver.quit();
    }
}
