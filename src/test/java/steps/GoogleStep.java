package steps;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import funcionalidades.GoogleFuncionalidade;
import funcionalidades.LoginFuncionalidade;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.awt.*;
import java.io.IOException;

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
    public void visualizoOResultadoDaMinhaPesquisa() throws IOException {
        googleFuncionalidade.visualizarResultado();
    }

    @E("clico no botao OK {int}")
    public void clicoNoBotaoOK(int arg0) throws InterruptedException {
        googleFuncionalidade.clicarNoBotao2();
    }
}
