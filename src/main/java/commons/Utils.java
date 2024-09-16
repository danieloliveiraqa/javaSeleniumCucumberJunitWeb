package commons;

import org.openqa.selenium.*;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class Utils {

    public static WebDriver webDriver;

    private final Object HomePage;
    public String cpf;

    public Utils(Object homePage) {
        HomePage = homePage;
    }


    public boolean validarQueElementoNaoEstaNaTela(WebElement element) {
        try {
            if (element.isDisplayed()) {
                throw new AssertionError("Elemento está visível"); // Lança uma AssertionError se o elemento estiver visível
            }
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotVisibleException e) {
            return true; // Elemento não está visível, então o teste passa
        }

        return false; // Elemento está visível, então o teste falha
    }

    public static void validarCorDoBotao(WebElement botao, String corEsperada) {
        // Obter a cor do botão
        String corDoBotao = botao.getCssValue("background-color");

        // Valide a cor do botão usando o JUnit
        assertEquals(corEsperada, corDoBotao);
    }

    public class PostgreSQLJDBC {
        public static void main(String args[]) {
            Connection c = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://sbri1zb1apsem0brscomm001.postgres.database.azure.com:5432/pgho171",
                                "emuser@sbri1zb1apsem0brscomm001.postgres.database.azure.com", "XXASAS");

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
    }

    public static String guardarValor(String valor) {
        Properties prop = new Properties();
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;

        try {
            String filePath = "C:\\Users\\Daniel\\Documents\\WorkSpaces\\Java\\JavaSeleniumCucumberJunit\\boolean.properties";

            fileInput = new FileInputStream(filePath);
            prop.load(fileInput);
            fileInput.close();

            fileOutput = new FileOutputStream(filePath);
            prop.setProperty("boolean", valor);
            prop.store(fileOutput, null);
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return valor;
    }

    public static String colorEvidencie(WebElement elemento) {
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("arguments[0].style.border = arguments[1] ", elemento, "solid 3px blue");
        return null;
    }

    // guardar valor

    private static final String FILE_PATH = "C:\\Users\\Daniel\\Documents\\WorkSpaces\\Java\\JavaSeleniumCucumberJunit\\boolean.properties";

    public static String guardarValor(String chave, String valor) {
        Properties prop = new Properties();
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;

        try {
            fileInput = new FileInputStream(FILE_PATH);
            prop.load(fileInput);
            fileInput.close();

            fileOutput = new FileOutputStream(FILE_PATH);
            prop.setProperty(chave, valor);
            prop.store(fileOutput, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fecharStream(fileInput);
            fecharStream(fileOutput);
        }

        return valor;
    }

    private static void fecharStream(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //obter valor
    private static Properties prop = new Properties();

    static {
        carregarPropriedades();
    }

    private static void carregarPropriedades() {
        try {
            String filePath = "C:\\Users\\Daniel\\Documents\\WorkSpaces\\Java\\JavaSeleniumCucumberJunit\\boolean.properties";
            FileInputStream fileInput = new FileInputStream(filePath);
            prop.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Lidar com a exceção conforme necessário
        }
    }

    public static String obterValor(String chave) {
        return prop.getProperty(chave, "");
    }


}
