package funcionalidades;

import commons.BaseTest;
import commons.Utils;
import io.cucumber.datatable.DataTable;
import jdk.jshell.execution.Util;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import report.ReportPDF;
import screenshots.Screenshot;
import utils.UtilsDB;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GoogleFuncionalidade extends BaseTest {


    LoginPage loginPage = new LoginPage(webDriver);

    Utils utils = new Utils(webDriver);

    Robot robot = new Robot();

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public GoogleFuncionalidade() throws AWTException {
    }

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

    public void clicarNoBotao2(String botao) throws InterruptedException {
        if (botao.equals("Entrar")) {
            webDriver.switchTo().frame(webDriver.findElement(By.id("sp_message_iframe_760094")));
            loginPage.getAcceptCookie().click();
            webDriver.switchTo().defaultContent();
            loginPage.getSpanEntrar().click();
        } else if (botao.equals("Baixar")) {
            //loginPage.getMediafire().click();
            // Esperar um tempo razoável para que o download seja iniciado
            // Ajuste esse tempo de espera conforme necessário
            Thread.sleep(5000);
        }
    }

    public void RealizarLoginNoSite() {
        loginPage.getCampoEmail().sendKeys("suporte.blackshotsv@hotmail.com");
        loginPage.getCampoSenha().sendKeys("@Inside2023");
        loginPage.getBotaoEntrar().click();
    }

    public void clicarNoBotaoPagina(String botao) throws InterruptedException {
        if (botao.equals("Alimentos")) {
            Thread.sleep(5000);
            loginPage.getBotaoMetas().click();
        }
    }

    public void visualizarResult() {
        utils.validarQueElementoNaoEstaNaTela(loginPage.getSpanfas2t2mine());
    }

    public void visualizarResultado() throws IOException {
        Assert.assertTrue(loginPage.getSpanfas2t2mine().isDisplayed());
        // Assert.assertEquals(0, webDriver.findElements(By.xpath("//h3[contains(text(),'Gustavo lima')]")).size());
        //BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //ReportPDF.addScreenshot(screenshot);

        //  BufferedImage screenshot = Screenshot.takeScreenshot(webDriver);
        //  String screenshotFilename = "screenshot.png"; // Substitua pelo nome do arquivo apropriado
        // File screenshotFile = new File(screenshotFilename);
        //  ImageIO.write(screenshot, "png", screenshotFile);
        //  ReportPDF.addScreenshot(screenshotFilename);
    }

    public void preencherCampos(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> campos = dataTable.asMaps(String.class, String.class);

        if (campos.size() >= 4) {
            Map<String, String> campo = campos.get(0); // Obtém o primeiro elemento da lista (índice 0)
            String valorCampo = campo.get("Valor");

            campo = campos.get(1); // Obtém o segundo elemento da lista (índice 1)
            String valorPassword = campo.get("Valor");

            campo = campos.get(2); // Obtém o terceiro elemento da lista (índice 2)
            String valorEndereco = campo.get("Valor");

            campo = campos.get(3); // Obtém o quarto elemento da lista (índice 3)
            String valorNumero = campo.get("Valor");

            campo = campos.get(4); // Obtém o quinto elemento da lista (índice 4)
            String valorComplemento = campo.get("Valor");

            campo = campos.get(5); // Obtém o sexto elemento da lista (índice 5)
            String valorBairroPessoal = campo.get("Valor");

            campo = campos.get(6); // Obtém o sétimo elemento da lista (índice 6)
            String valorEstadoPessoal = campo.get("Valor");

            campo = campos.get(7); // Obtém o oitavo elemento da lista (índice 7)
            String valorCidadePessoal = campo.get("Valor");

            loginPage.getCampoUserName().sendKeys(valorCampo);
            loginPage.getCampoPassword().sendKeys(valorPassword);
            loginPage.getCampoUserName().sendKeys(valorEndereco);
            loginPage.getCampoUserName().sendKeys(valorNumero);
            loginPage.getCampoUserName().sendKeys(valorComplemento);
            loginPage.getCampoUserName().sendKeys(valorBairroPessoal);
            loginPage.getCampoUserName().sendKeys(valorEstadoPessoal);
            loginPage.getCampoUserName().sendKeys(valorCidadePessoal);

            Thread.sleep(5000);
        } else {
            System.out.println("A tabela não possui pelo menos oito elementos.");
        }


    }

    public void aguardarQueElementoQueEstaNaTelaSuma() throws InterruptedException {
        // Localize o elemento de loading usando um XPath ou outro localizador adequado
        By loadingLocator = By.xpath("(//input[@name='btnK'])[2]"); // Substitua pelo XPath correto

        // Defina um tempo máximo de espera em milissegundos (50 segundos)
        long timeoutInMilliseconds = 10000; // 50 segundos

        long startTime = System.currentTimeMillis();

        boolean elementStillPresent = true;

        while (System.currentTimeMillis() - startTime < timeoutInMilliseconds) {
            WebElement loadingElement = null;
            try {
                loadingElement = webDriver.findElement(loadingLocator);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // O elemento não foi encontrado, o que é o resultado esperado
                elementStillPresent = false;
                break; // Saia do loop
            }

            if (loadingElement.isDisplayed()) {
                try {
                    Thread.sleep(500); // Aguarde 500 milissegundos antes de verificar novamente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                elementStillPresent = false;
                break; // Saia do loop
            }
        }

        // Se o elemento ainda estiver presente após 50 segundos, declare um erro
        if (elementStillPresent) {
            Assert.fail();
            System.out.println("Erro: Elemento ainda está presente após 50 segundos.");
        } else {
            // O elemento não está mais presente, prossiga com os próximos passos do seu teste
            // Insira o código para os próximos passos do teste aqui
            loginPage.getLinkHyundai().click();
        }
    }

    public void fazerConexao() throws SQLException, ClassNotFoundException {
        UtilsDB.connectToDB();

        // Chame o método queryRetornaQuiz para obter a lista de respostas.
        List<String> quizData;
        try {
            quizData = UtilsDB.queryRetornaQuiz();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Agora, vamos extrair cada resposta da coluna ns_res e armazená-las em variáveis.
        String resposta1 = quizData.get(0); // Primeira resposta (primeira linha da coluna ns_res).
        String resposta2 = quizData.get(1); // Segunda resposta (segunda linha da coluna ns_res).
        String resposta3 = quizData.get(2); // Terceira resposta (terceira linha da coluna ns_res).

        // Agora você pode usar essas respostas para o que precisar no seu teste automatizado.
        // Por exemplo, exibir as respostas na saída:
        System.out.println("Resposta 1: " + resposta1);
        System.out.println("Resposta 2: " + resposta2);
        System.out.println("Resposta 3: " + resposta3);

        // Chame o seu método ResponderQuiz() passando as respostas como argumentos.
        ResponderQuiz(resposta1, resposta2, resposta3);
    }

    // Crie o seu método ResponderQuiz() para realizar ações com as respostas.
    public void ResponderQuiz(String resposta1, String resposta2, String resposta3) {
        // Implemente aqui as ações para responder ao quiz com as respostas fornecidas.
        // Por exemplo, usando o Selenium para interagir com a página e enviar as respostas.
    }


    public void validoQueACorDoBotaoGetStartedÉVerde() {
        // Localizar o elemento do botão
        // String botao = loginPage.getCorDoBotao();
        // Obter a cor do botão
        // String corDoBotao = loginPage.getCorDoBotao().getCssValue("background-color");
        //// Defina a cor esperada que você deseja validar
        // String corEsperada = "rgba(0, 44, 96, 1)"; // Exemplo: vermelho
        // Valide a cor do botão
        // Assert.assertEquals(corEsperada, corDoBotao);

        // Chamar o método utilitário para validar a cor do botão
        Utils.validarCorDoBotao(loginPage.getCorDoBotao(), "rgba(0, 44, 95, 1)");
        String cpf = "473807233011";
        String senhaNova = funcionalidades.GeradorSenhaNumerica.gerarSenhaNumerica(cpf);
        System.out.println(senhaNova);
    }

    public void visualizoQueODownloadDoArquivoFoiFeitoComSucesso() throws InterruptedException {        // Verificar o número de arquivos no diretório de download antes do download
        String downloadPath = "C:\\Users\\Daniel\\Downloads";  // Caminho para a pasta de downloads
        int numFilesBeforeDownload = countFilesInDirectory(downloadPath);

        // Localizar e clicar no link para iniciar o download

        loginPage.getMediafire().click();

        // Esperar até que um novo arquivo seja adicionado ao diretório de download
        waitForNewFileInDirectory(downloadPath, numFilesBeforeDownload);

        // Verificar se o download foi concluído com sucesso
        boolean downloadSuccess = countFilesInDirectory(downloadPath) > numFilesBeforeDownload;

        if (downloadSuccess) {
            System.out.println("O download foi concluído com sucesso.");
        } else {
            System.out.println("O download falhou ou não foi concluído.");
        }
    }

    private static int countFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        return files != null ? files.length : 0;
    }

    private static void waitForNewFileInDirectory(String directoryPath, int numFilesBefore) {
        int maxWaitTimeInSeconds = 60;
        int waitedTimeInSeconds = 0;

        while (waitedTimeInSeconds < maxWaitTimeInSeconds) {
            int numFilesAfter = countFilesInDirectory(directoryPath);
            if (numFilesAfter > numFilesBefore) {
                break;
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitedTimeInSeconds++;
        }
    }

    public void como() {

        List<String> abas = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(abas.get(2));
    }

    public static class GeradorSenhaNumerica {
        private static final int TAMANHO_SENHA = 6;

        public static String gerarSenhaNumerica(String cpf) {
            List<Integer> cpfDigits = new ArrayList<>();
            for (char c : cpf.toCharArray()) {
                cpfDigits.add(Character.getNumericValue(c));
            }

            List<Integer> senhaDigits = new ArrayList<>();
            Random random = new Random();

            while (senhaDigits.size() < TAMANHO_SENHA) {
                int randomDigit = random.nextInt(10);
                if (validarRequisitos(senhaDigits, randomDigit, cpfDigits)) {
                    senhaDigits.add(randomDigit);
                }
            }

            StringBuilder senha = new StringBuilder();
            for (int digit : senhaDigits) {
                senha.append(digit);
            }

            return senha.toString();
        }

        static boolean validarRequisitos(List<Integer> senhaDigits, int novoDigit, List<Integer> cpfDigits) {
            if (senhaDigits.contains(novoDigit)) {
                return false;
            }
            if (senhaDigits.size() > 0) {
                int ultimoDigit = senhaDigits.get(senhaDigits.size() - 1);
                if (novoDigit == ultimoDigit + 1) {
                    return false;
                }
            }
            for (int cpfDigit : cpfDigits) {
                if (senhaDigits.contains(cpfDigit * 10 + cpfDigit)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            String cpf = "473807233011";
            String senha = gerarSenhaNumerica(cpf);
            System.out.println("Senha gerada: " + senha);
        }
    }


    public void clicoNoChekbox() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getCheckbox()));
        Thread.sleep(5000);
        loginPage.getCheckbox().click();
        Thread.sleep(5000);
        boolean isSelected = loginPage.getCheckbox().isSelected();
        System.out.println("O checkbox está selecionado? " + isSelected);
        Utils.guardarValor(String.valueOf(isSelected));
        webDriver.navigate().refresh();
        Thread.sleep(5000);
    }

    public void validoQueTentoFazerMoverMousePraCaixaDeTexto2() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.switchTo().frame(loginPage.getIframe2());

        Point ponto = webDriver.findElement(By.xpath("/html/body/div/div/div/section/div/div/table/thead/tr/th[1]/button")).getLocation();
        int coordenadaX = ponto.getX();
        int coordenadaY = ponto.getY();

// Imprimindo as coordenadas
        System.out.println("Coordenada X do iframe: " + coordenadaX);
        System.out.println("Coordenada Y do iframe: " + coordenadaY);


    }

    public void validoQueTentoFazerMoverMousePraCaixaDeTexto() throws AWTException, InterruptedException {
        Thread.sleep(5000);

        // Encontrar o iframe
        WebElement iframe = loginPage.getIframe();

        // Obter a largura e altura do iframe
        int larguraIframe = iframe.getSize().getWidth();
        int alturaIframe = iframe.getSize().getHeight();

// Definir as coordenadas relativas dentro do iframe (por exemplo, 50% da largura e 30% da altura)
        double porcentagemX = 1.8; // 50% da largura do iframe
        double porcentagemY = 2.0; // 30% da altura do iframe

// Calcular as coordenadas dentro do iframe com base na largura e altura do iframe e nas porcentagens desejadas
        int coordenadaX = (int) (larguraIframe * porcentagemX);
        int coordenadaY = (int) (alturaIframe * porcentagemY);

        System.out.println("X: " + coordenadaX);
        System.out.println("Y: " + coordenadaY);

//// Executar o clique nas coordenadas calculadas
//        Actions actions = new Actions(webDriver);
        Robot robot = new Robot();
        robot.mouseMove(coordenadaX, coordenadaY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(15000);
    }

    public void tentarfazerCliquePorCoordenada() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        Robot robot = new Robot();

        // Espera 2 segundos antes de executar a ação
        robot.delay(2000);

        // Clica nas coordenadas (x, y) na tela
        int x = 1020; // coordenada x
        int y = 595; // coordenada y

        // Move o mouse para as coordenadas
        robot.mouseMove(x, y);

        // Simula o clique pressionando e soltando o botão do mouse
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(9000);
    }

    //833 e 579

    public void validarCheckbox() throws InterruptedException {
        //String teste = Utils.obterValor();
        // boolean expectedState = Boolean.parseBoolean(teste);
        boolean isSelected = loginPage.getCheckbox().isSelected();
        System.out.println("O checkbox está selecionado? " + isSelected);

        //Assert.assertEquals(expectedState, isSelected);
    }

    public void validarQueConsigoManipularVariasChavesAoDigitarNoCampo() throws InterruptedException {

        Utils.guardarValor("namorado", "oliveira");

        String valor = Utils.obterValor("amor");
        loginPage.getPesquisarGoogle().sendKeys(valor);
    }

    public void queFacoRequesicaoDeApi() {

    }

}


