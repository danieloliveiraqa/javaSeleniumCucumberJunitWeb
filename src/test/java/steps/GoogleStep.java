package steps;

import funcionalidades.GoogleFuncionalidade;
import funcionalidades.LoginFuncionalidade;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class GoogleStep {

    private LoginFuncionalidade loginFuncionalidade = new LoginFuncionalidade();
    private GoogleFuncionalidade googleFuncionalidade = new GoogleFuncionalidade();

    public GoogleStep() throws Exception {
    }

    @Dado("que estou logado no google")
    public void queEstouLogadoNoGoogle() throws InterruptedException {
        loginFuncionalidade.loginGoogle();
    }

    @Quando("pesquiso por alguma palavra")
    public void pesquisoPorAlgumaPalavra() throws InterruptedException {
        googleFuncionalidade.digitarNoCampo();
    }

    @E("clico no botao OK")
    public void clicoNoBotaoOK() {
    }

    @Entao("visualizo o resultado da minha pesquisa")
    public void visualizoOResultadoDaMinhaPesquisa() {
    }
}
