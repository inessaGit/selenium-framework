package demo.priceless.test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BrokenLinks {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;
   private HttpURLConnection huc = null;
  private  int respCode = 200;
private String url;
    @BeforeMethod
    public void testSetUp() {
        //workaround for bug https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testLoadPage() {
        baseUrl = "https://www.priceless.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //if displayed
        WebElement acceptCookiesBtn = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesBtn.click();

        // Iterator<WebElement> it = links.iterator();
        System.out.println ("Link number="+links.size());
        for (WebElement link : links) {
            url = link.getAttribute("href");
            verifyLinks(url);
        }

    }
            //@AfterTest runs once after all of the @Test methods have run
            @AfterMethod
            public void tearDown() {
            driver.quit();
        }
    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
}
}