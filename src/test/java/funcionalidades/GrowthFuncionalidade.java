package funcionalidades;

import commons.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.GrowthPage;
import pages.LoginPage;
import report.ReportPDF;
import screenshots.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static funcionalidades.GoogleFuncionalidade.GeradorSenhaNumerica.validarRequisitos;


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
        if (produto.equals("Creatina (250g)")) {

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);

            Thread.sleep(5000);
            // growthPage.getCreatina().click();

            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", growthPage.getCreatina());

        }
    }

    public void visualizoProduto(String status) throws IOException, InterruptedException {
        if (status.equals("Indisponivel")) {
            Thread.sleep(5000);
            growthPage.getProdutoindisponivel().isDisplayed();

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);

        } else if (status.equals("Disponivel")) {
            // Thread.sleep(5000);
            growthPage.getProdutoDisponivel().isDisplayed();

            BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
            String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
            File screenshotFile = new File(screenshotFilename);
            ImageIO.write(screenshot, "png", screenshotFile);
            ReportPDF.addScreenshot(screenshotFilename);

        }
    }


    public static class GeradorSenhaNumerica {
        private static final int TAMANHO_SENHA = 6;
        private static final int MAX_TENTATIVAS = 1000;

        public static String gerarSenhaNumerica(String cpf) {
            List<Integer> cpfDigits = new ArrayList<>();
            for (char c : cpf.toCharArray()) {
                cpfDigits.add(Character.getNumericValue(c));
            }

            List<Integer> senhaDigits = new ArrayList<>();
            Random random = new Random();

            int tentativas = 0;

            while (senhaDigits.size() < TAMANHO_SENHA && tentativas < MAX_TENTATIVAS) {
                int randomDigit = random.nextInt(10);
                if (validarRequisitos(senhaDigits, randomDigit, cpfDigits)) {
                    senhaDigits.add(randomDigit);
                    tentativas++; // Mover a incrementação para aqui
                }

                // Verificação para interromper tentativas após o limite
                if (tentativas >= MAX_TENTATIVAS) {
                    System.out.println("Limite máximo de tentativas atingido");
                    break;
                }
            }

            StringBuilder senha = new StringBuilder();
            for (int digit : senhaDigits) {
                senha.append(digit);
            }

            return senha.toString();
        }

        // Restante do código (validarRequisitos e main) permanece igual

        public static void main(String[] args) {
            String cpf = "473807233011";
            String senha = gerarSenhaNumerica(cpf);
            System.out.println("Senha gerada: " + senha);
        }
    }
}
