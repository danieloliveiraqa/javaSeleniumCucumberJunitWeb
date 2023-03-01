package bean.enums;

import interfaces.WebApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public enum Web implements WebApplication {


    CHROME {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\Documents\\FrameWork\\chromedriver.exe");
            ChromeOptions capability = new ChromeOptions();
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            capability.setExperimentalOption("useAutomationExtension", false);
            return new ChromeDriver(capability);
        }
    },


    CHROME_MAC {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver","chromedriver");
            return new ChromeDriver();
        }
    }

}
