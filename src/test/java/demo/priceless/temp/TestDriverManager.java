package demo.priceless.temp;

import demo.priceless.webdriver.DriverFactory;
import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDriverManager {

    @Test(priority = 1)
    public void createDriver(){
        // Create a WebDriver object
        String DEFAULT_BROWSER= "chrome";
        boolean isMobile=false;
        DriverManager.setWebDriver(DriverFactory.createInstance(DEFAULT_BROWSER, isMobile));
        WebDriver driver = DriverManager.getWebDriver();
        System.out.println("WebDriver Object : " + driver);
        driver.get("https://www.priceless.com/entertainment");
    }
    @Test(priority = 2)
    public void closeDriver(){
        DriverManager.closeDriver();
    }
}
