package parabank.test;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parabank.pages.HomePage;
import parabank.pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AllureJunit5.class)
@Epic("Parabank Application")
@Feature("User Login and Navigation")
public class TestParabank extends BaseTest {

    @Test
    @Story("User logs in with valid credentials")
    @Description("Verify that user John can successfully login with demo password")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginIsSuccessful(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("john", "demo");
        loginPage.assertWelcomeElement();
    }

    @Test
    @Story("User navigates to left panel menu")
    public void testLeftPanelMenu(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("john", "demo");
        HomePage homePage = new HomePage();
        List<String> menu = homePage.getLeftMenuItems();
        assertEquals(6, menu.size());
    }

    @Test
    @Story("User navigates to left body panel")
    public void testLeftBodyMenu(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("john", "demo");
        HomePage homePage = new HomePage();
        List<String> menu = homePage.getLeftBodyPanelItems();
        assertEquals(8, menu.size());
    }

    @Test
    @Story("User views account overview")
    public void testAccountsOverview(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("john", "demo");
        HomePage homePage = new HomePage();
        Boolean isDisplayed = homePage.isAccountsOverviewDisplayed();
        assertEquals(true, isDisplayed);
    }
}
