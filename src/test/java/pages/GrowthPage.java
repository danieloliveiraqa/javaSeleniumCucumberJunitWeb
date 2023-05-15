package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrowthPage {

    public GrowthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Encontre Suplementos']")
    private WebElement campoEncontreSuplementos;

    public WebElement getCampoEncontreSuplementos() {
        return campoEncontreSuplementos;
    }

    @FindBy(xpath = "/html/body/main/article/section[5]/div/div[2]/div[2]/div/div/div[1]/div[1]/a/img")
    private WebElement creatina;

    public WebElement getCreatina() {
        return creatina;
    }

    @FindBy(xpath = "//div[@class='botao-de-compra']//button[@class='btIndisponivel']")
    private WebElement produtoindisponivel;

    public WebElement getProdutoindisponivel() {
        return produtoindisponivel;
    }

    @FindBy(xpath = "//img[@src='https://www.gsuplementos.com.br/tema/growth/img/svgs/search-ab.svg']")
    private WebElement  imgBuscar;

    public WebElement getImgBuscar() {
        return imgBuscar;
    }

    @FindBy(xpath = "//div[@class='botao-de-compra']//button[@class='botaoComprar']")
    private WebElement produtoDisponivel;

    public WebElement getProdutoDisponivel() {
        return produtoDisponivel;
    }
}

