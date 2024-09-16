package commons;

import interfaces.WebApplication;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver webDriver;
    protected static WebDriverWait wait;


    protected void initializeWebApplication(WebApplication webApplication) {
        Dimension resolution = new Dimension(1920, 1080);
        webDriver = webApplication.getDriver();
        webDriver.manage().window().setSize(resolution);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
    }

    protected static void closeWeb() {
        webDriver.close();
        webDriver.quit();
    }


}
