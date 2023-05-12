package steps;

import funcionalidades.GoogleFuncionalidade;
import funcionalidades.GrowthFuncionalidade;
import funcionalidades.LoginFuncionalidade;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.io.IOException;

public class GrowthStep {

    private LoginFuncionalidade loginFuncionalidade = new LoginFuncionalidade();
    private GoogleFuncionalidade googleFuncionalidade = new GoogleFuncionalidade();
    private GrowthFuncionalidade growthFuncionalidade = new GrowthFuncionalidade();

    public GrowthStep() throws Exception {
    }

    @E("insiro no campo {string} o valor {string}")
    public void insiroNoCampoOValor(String campo, String valor) throws InterruptedException, IOException {
        growthFuncionalidade.insiroNoCampoOValor(campo,valor);
    }

    @Quando("seleciono o produto {string}")
    public void selecionoOProduto(String produto) throws IOException, InterruptedException {
        growthFuncionalidade.selecionarOproduto(produto);
    }

    @Entao("visualizo que a creatina esta {string}")
    public void visualizoQueACreatinaEsta(String status) throws IOException {
        growthFuncionalidade.visualizoProduto(status);
    }
}
