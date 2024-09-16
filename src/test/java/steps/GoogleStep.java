package steps;

import bean.enums.Web;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import funcionalidades.GoogleFuncionalidade;
import funcionalidades.LoginFuncionalidade;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class GoogleStep {


    private LoginFuncionalidade loginFuncionalidade = new LoginFuncionalidade();
    private GoogleFuncionalidade googleFuncionalidade = new GoogleFuncionalidade();

    public GoogleStep() throws Exception {

    }

    @Dado("que estou logado no {string}")
    public void queEstouLogadoNoGoogle(String site) throws InterruptedException, IOException {
        loginFuncionalidade.loginGoogle(site);
    }

    @Quando("pesquiso por alguma palavra chamada {string}")
    public void pesquisoPorAlgumaPalavra(String nome) throws InterruptedException, IOException, DocumentException {
        googleFuncionalidade.digitarNoCampo(nome);
    }

    @E("clico no botao OK")
    public void clicoNoBotaoOK() throws InterruptedException, AWTException, IOException {
        googleFuncionalidade.clicarNoBotao();
    }

    @Entao("visualizo o resultado da minha pesquisa")
    public void visualizoOResultadoDaMinhaPesquisa() throws IOException, InterruptedException {
        googleFuncionalidade.visualizarResultado();
    }

    @E("clico no botao OK {string}")
    public void clicoNoBotaoOK(String botao) throws InterruptedException {
        googleFuncionalidade.clicarNoBotao2(botao);
    }

    @Quando("clico no botão {string}")
    public void clicoNoBotão(String botao) throws InterruptedException {
        googleFuncionalidade.clicarNoBotaoPagina(botao);
    }

    @E("adiciono o alimento {string}")
    public void adicionoOAlimento(String arg0) {
    }

    @E("clico no botao {string}")
    public void clicoNoBotao(String botao) throws IOException, InterruptedException, AWTException {
        googleFuncionalidade.clicarNoBotao2(botao);
    }

    @E("realizo o login no site")
    public void realizoOLoginNoSite() {
        googleFuncionalidade.RealizarLoginNoSite();
    }

    @E("preencho os seguintes campos:")
    public void preencherCampos(DataTable dataTable) throws InterruptedException {
        googleFuncionalidade.preencherCampos(dataTable);
    }

    @Então("vejo a mensagem de confirmação {string}")
    public void vejoAMensagemDeConfirmação(String arg0) {
    }

    @Entao("visualizo que o download do arquivo foi feito com sucesso")
    public void visualizoQueODownloadDoArquivoFoiFeitoComSucesso() throws InterruptedException {
        googleFuncionalidade.visualizoQueODownloadDoArquivoFoiFeitoComSucesso();
    }

    @Entao("valido que a cor do botao get started é verde")
    public void validoQueACorDoBotaoGetStartedÉVerde() {
        googleFuncionalidade.validoQueACorDoBotaoGetStartedÉVerde();

    }

    @Entao("validar que banco vai extrair")
    public void validarQueBancoVaiExtrair() throws SQLException, ClassNotFoundException {
        googleFuncionalidade.fazerConexao();
    }

    @Entao("validar que elemento sumiu da tela")
    public void validarQueElementoSumiuDaTela() throws InterruptedException {
        googleFuncionalidade.aguardarQueElementoQueEstaNaTelaSuma();
    }

    @Entao("validar que checkbox")
    public void validarQueCheckbox() throws InterruptedException {
        googleFuncionalidade.validarCheckbox();
    }

    @Quando("clico no checkbox")
    public void clicoNoCheckbox() throws InterruptedException {
        googleFuncionalidade.clicoNoChekbox();
    }

    @Entao("valido que tento fazer um clique por coordenada")
    public void validoQueTentoFazerUmCliquePorCoordenada() throws InterruptedException, AWTException {
        googleFuncionalidade.tentarfazerCliquePorCoordenada();
    }

    @Entao("valido que tento fazer mover mouse pra caixa de texto")
    public void validoQueTentoFazerMoverMousePraCaixaDeTexto() throws InterruptedException, AWTException {
        //googleFuncionalidade.validoQueTentoFazerMoverMousePraCaixaDeTexto();
        googleFuncionalidade.validoQueTentoFazerMoverMousePraCaixaDeTexto2();
    }

    @Entao("validar que consigo manipular varias chaves ao digitar no campo")
    public void validarQueConsigoManipularVariasChavesAoDigitarNoCampo() throws InterruptedException {
        googleFuncionalidade.validarQueConsigoManipularVariasChavesAoDigitarNoCampo();
    }

    @Dado("que faco requesicao de api")
    public void queFacoRequesicaoDeApi() {
        googleFuncionalidade.queFacoRequesicaoDeApi();
    }

    @Entao("envio da requesicao")
    public void envioDaRequesicao() {
    }
}
