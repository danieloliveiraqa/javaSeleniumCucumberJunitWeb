package pages;

import bean.enums.Web;
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

    @FindBy(xpath = "//div[2]/div/div[1]/form/div/a[2]")
    private WebElement mediafire;

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    private WebElement pesquisarGoogle;

    @FindBy(xpath = "(//input[@name='btnK'])[1]")
    private WebElement pesquisarGoogle2;


    public WebElement getPesquisarGoogle2() {
        return pesquisarGoogle2;
    }

    @FindBy(xpath = "(//h3[.='Hyundai Motor Brasil'])[1]")
    private WebElement linkHyundai;


    public WebElement getLinkHyundai() {
        return linkHyundai;
    }

    public WebElement getPesquisarGoogle() {
        return pesquisarGoogle;
    }

    public WebElement getCampoPesquisa() {
        return campoPesquisa;
    }

    public WebElement getMediafire() {
        return mediafire;
    }

    public WebElement getBotaoOK() {
        return botaoOK;
    }

    public WebElement getSpanfas2t2mine() {
        return spanfas2t2mine;
    }

    @FindBy(xpath = "//a[.='Alimentos']")
    private WebElement botaoMetas;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/button")
    private WebElement acceptCookie;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")
    private WebElement botaoEntrar;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement campoEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement campoSenha;

    @FindBy(xpath = "//button//span[.='Entrar']")
    private WebElement botaoLogin;

    @FindBy(xpath = "//span[.='Entrar']")
    private WebElement spanEntrar;

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement campoUserName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement campoPassword;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div[1]/div/div/div[2]/div/div[5]")
    private WebElement corDoBotao;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement checkbox;

    @FindBy(xpath = "//iframe[@id='singleframe']")
    private WebElement iframe;

    @FindBy(xpath = "//iframe[@id='the-kitchen-table']")
    private WebElement iframe2;

    @FindBy(xpath = "//button[@id='column-button-name']")
    private WebElement textDoIframe;

    public WebElement getIframe2() {
        return iframe2;
    }

    public WebElement getTextDoIframe() {
        return textDoIframe;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public WebElement getCampoUserName() {
        return campoUserName;
    }

    public WebElement getCampoPassword() {
        return campoPassword;
    }

    public WebElement getBotaoEntrar() {
        return botaoEntrar;
    }

    public WebElement getCampoEmail() {
        return campoEmail;
    }

    public WebElement getCampoSenha() {
        return campoSenha;
    }

    public WebElement getBotaoLogin() {
        return botaoLogin;
    }

    public WebElement getSpanEntrar() {
        return spanEntrar;
    }

    public WebElement getAcceptCookie() {
        return acceptCookie;
    }

    public WebElement getBotaoMetas() {
        return botaoMetas;
    }

    public WebElement getCorDoBotao() {
        return corDoBotao;
    }
}
