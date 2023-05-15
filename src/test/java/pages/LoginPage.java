package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement campoPesquisa;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")
    private WebElement botaoOK;

    @FindBy(xpath = "//h3[contains(text(),'Fast2 Mine: Home')]")
    private WebElement spanfas2t2mine;

    public WebElement getCampoPesquisa() {
        return campoPesquisa;
    }

    public WebElement getBotaoOK() {
        return botaoOK;
    }

    public WebElement getSpanfas2t2mine() {
        return spanfas2t2mine;
    }
}
