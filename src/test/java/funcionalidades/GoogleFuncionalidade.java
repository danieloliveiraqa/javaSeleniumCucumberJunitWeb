package funcionalidades;

import commons.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class GoogleFuncionalidade extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    public void digitarNoCampo() throws InterruptedException {
        loginPage.getCampoPesquisa().sendKeys("Gustavo Lima");
    }

    public void clicarNoBotao() throws InterruptedException {
        loginPage.getBotaoOK().click();
    }

    public void clicarNoBotao2() throws InterruptedException {
        loginPage.getBotaoOK();
    }

    public void visualizarResultado(){
        Assert.assertTrue(loginPage.getSpanGustavoLima().isDisplayed());
    }


}
