package parabank.pages;

import org.example.pages.BasePage;
import org.example.util.ConfigLoader;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private final By username = By.xpath("//input[@name=\"username\"]");
    private final By password = By.xpath("//input[@name=\"password\"]");
    private final By loginButton = By.xpath("//input[@type=\"submit\"]");

    public void open() {
        String url = ConfigLoader.getProperty("PARABANK_URL");
        webDriver.get(url);
        String title = webDriver.getTitle();
        assertEquals("ParaBank | Welcome | Online Banking", title);
    }

    public void login(String user, String pass){
        webDriver.findElement(username).sendKeys(user);
        webDriver.findElement(password).sendKeys(pass);
        webDriver.findElement(loginButton).click();
        assertTrue(webDriver.findElement(By.xpath("//b[text()=\"Welcome\"]")).isDisplayed());
    }

    public void assertWelcomeElement(){
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(webDriver.findElement(By.xpath("//b[text()=\"Welcome\"]")).isDisplayed());
    }
}
