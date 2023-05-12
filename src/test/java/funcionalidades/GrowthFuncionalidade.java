package funcionalidades;

import commons.BaseTest;
import org.junit.Assert;
import pages.GrowthPage;
import pages.LoginPage;
import report.ReportPDF;
import screenshots.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GrowthFuncionalidade extends BaseTest {

    GrowthPage growthPage
            = new GrowthPage(webDriver);

    public void insiroNoCampoOValor(String campo, String valor) throws InterruptedException, IOException {
        if (campo.equals("Encontre Suplementos")) {
            growthPage.getCampoEncontreSuplementos().sendKeys(valor);


            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);
            growthPage.getImgBuscar().click();
        }
    }

    public void selecionarOproduto(String produto) throws IOException, InterruptedException {
        if (produto.equals("Creatina (250g) (Creapure®) - Growth Supplements")) {

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);

            Thread.sleep(5000);
            growthPage.getCreatina().click();

        }
    }

    public void visualizoProduto(String status) throws IOException {
        if (status.equals("Indisponivel")) {
            growthPage.getProdutoindisponivel().isDisplayed();

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);

        }
    }

}
