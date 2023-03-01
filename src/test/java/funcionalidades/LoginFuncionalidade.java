package funcionalidades;

import commons.BaseTest;

public class LoginFuncionalidade extends BaseTest {


    private CommonFuncionalidade common = new CommonFuncionalidade();

    public LoginFuncionalidade() throws Exception {
    }

    public void loginGoogle() throws InterruptedException {
        common.acessaSite("https://www.google.com.br");
    }

}
