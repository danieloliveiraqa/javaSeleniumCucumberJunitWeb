package funcionalidades;


import commons.BaseTest;
import commons.Utils;


public class CommonFuncionalidade extends BaseTest {

    public void acessaSite(String site) {
        webDriver.navigate().to(site);
    }


}
