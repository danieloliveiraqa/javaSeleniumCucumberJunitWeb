package funcionalidades;

import commons.BaseTest;
import report.ReportPDF;
import screenshots.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginFuncionalidade extends BaseTest {


    private CommonFuncionalidade common = new CommonFuncionalidade();

    public LoginFuncionalidade() throws Exception {
    }

    public void loginGoogle(String Site) throws InterruptedException, IOException {
        if (Site.equals("Google")) {
            common.acessaSite("https://www.google.com.br");

        } else if (Site.equals("Growth")) {
            common.acessaSite("https://www.gsuplementos.com.br/");

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);
        }
    }

}


;