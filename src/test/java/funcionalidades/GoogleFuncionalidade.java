package funcionalidades;

import commons.BaseTest;
import org.junit.Assert;
import pages.LoginPage;
import report.ReportPDF;
import screenshots.Screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GoogleFuncionalidade extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    public void digitarNoCampo(String nome) throws InterruptedException, IOException {
        loginPage.getCampoPesquisa().sendKeys(nome);
        //BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //ReportPDF.addScreenshot(screenshot);

        BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
        File screenshotFile = new File(screenshotFilename);
        ImageIO.write(screenshot, "png", screenshotFile);
        ReportPDF.addScreenshot(screenshotFilename);
    }

    public void clicarNoBotao() throws InterruptedException, AWTException, IOException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        //BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //ReportPDF.addScreenshot(screenshot);

        //   BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //  String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
        // File screenshotFile = new File(screenshotFilename);
        //   ImageIO.write(screenshot, "png", screenshotFile);
        //   ReportPDF.addScreenshot(screenshotFilename);
    }

    public void clicarNoBotao2() throws InterruptedException {
        loginPage.getBotaoOK();
    }

    public void visualizarResultado() throws IOException {
        Assert.assertTrue(loginPage.getSpanfas2t2mine().isDisplayed());
        //BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //ReportPDF.addScreenshot(screenshot);

        BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
        File screenshotFile = new File(screenshotFilename);
        ImageIO.write(screenshot, "png", screenshotFile);
        ReportPDF.addScreenshot(screenshotFilename);
    }

}
