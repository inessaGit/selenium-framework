package demo.priceless.temp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestWaits {

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void testSetUp() {
        //workaround for bug https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testImplicitWait() {
        baseUrl = "https://www.priceless.com/";
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.get(baseUrl);
        //Implicit wait |WebDriver will wait for a maximum of 30 seconds before moving ahead with the interaction with the element.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void testExplicitWait() {
        baseUrl = "https://google.com/ncr";
        driver.get(baseUrl);
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
// Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstResult = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
// Print the first result
        System.out.println(firstResult.getText());

    }

    @Test
    public void testFluentWait(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        //			.ignoring(NoSuchElementException.class);
        baseUrl = "https://www.priceless.com/";
        driver.get(baseUrl);

        //<span class="title">Log in</span>   | span[text()='Log in']
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //accept cookies

        //<span class="title">Log in</span> ; We use the . notation.
        WebElement loginBtnTopNav = driver.findElement(By.xpath("//span[text()='Log in']"));
        loginBtnTopNav.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgot-password")));
    }
    //    @AfterTest runs once after all of the @Test methods have run
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
