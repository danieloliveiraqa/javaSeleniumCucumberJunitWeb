package funcionalidades;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class GoogleFuncionalidade extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    public void digitarNoCampo() throws InterruptedException {
        loginPage.getCampoPesquisa().sendKeys("uiuiui");
    }

}
