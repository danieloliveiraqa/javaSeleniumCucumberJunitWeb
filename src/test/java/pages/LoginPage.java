package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement campoPesquisa;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")
    private WebElement botaoOK;

    @FindBy(xpath = "//span[.='Gusttavo Lima']")
    private WebElement spanGustavoLima;

    public WebElement getCampoPesquisa() {
        return campoPesquisa;
    }

    public WebElement getBotaoOK() {
        return botaoOK;
    }

    public WebElement getSpanGustavoLima() {
        return spanGustavoLima;
    }
}
