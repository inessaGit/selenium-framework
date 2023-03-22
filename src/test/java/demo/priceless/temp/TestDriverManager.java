package demo.priceless.temp;

import demo.priceless.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDriverManager {
    @Test(priority = 1)
    public void createDriver(){
        // Create a WebDriver object
        WebDriver driver = DriverManager.getWebDriver();
        driver.get("https://www.priceless.com/entertainment");
    }
   // @Test(priority = 2)
    public void closeDriver(){
        DriverManager.closeDriver();
    }
}
