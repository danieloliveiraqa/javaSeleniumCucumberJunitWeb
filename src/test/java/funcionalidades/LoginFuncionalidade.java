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

        } else if (Site.equals("Myfitnesspal")) {
            common.acessaSite("https://www.myfitnesspal.com/pt");

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);
        } else if (Site.equals("saucedemo")) {
            common.acessaSite("https://www.saucedemo.com/");
        } else if (Site.equals("Mediafire")) {
            common.acessaSite("https://www.mediafire.com/file/osfs66plrpkbku0/test.txt/file");
        } else if (Site.equals("hyundai")) {
            common.acessaSite("https://www.hyundai.com.br/");
        } else if (Site.equals("Checkbox")) {
            common.acessaSite("http://the-internet.herokuapp.com/checkboxes");
        } else if (Site.equals("iframe")) {
            //common.acessaSite("https://demo.automationtesting.in/Frames.html");
            common.acessaSite("https://kitchen.applitools.com/ingredients/iframe");
        }
    }

    public void fazerConexao() {

    }

}


;