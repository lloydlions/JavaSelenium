package parabank.test;

import org.junit.jupiter.api.Test;
import parabank.pages.LoginPage;

public class TestLoginPage extends BaseTest {

    @Test
    public void testLoginIsSuccessful(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("john", "demo");
    }
}
