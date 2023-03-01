package configuration;

import bean.enums.Web;
import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before(value = "@web")
    public void beforeScenarioWeb() {
        this.inicializeBrowser();
    }

    @After(value = "@web")
    public void afterScenarioWeb() throws InterruptedException {
        closeWeb();
    }

    private void inicializeBrowser() {
        try {
            initializeWebApplication(Web.CHROME);
        } catch (IllegalStateException e) {
            initializeWebApplication(Web.CHROME_MAC);
        }
    }


}
