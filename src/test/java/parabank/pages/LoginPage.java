package parabank.pages;

import org.example.pages.BasePage;
import org.example.util.ConfigLoader;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    private final By username = By.xpath("//input[@name=\"username\"]");
    private final By password = By.xpath("//input[@name=\"password\"]");
    private final By loginButton = By.xpath("//input[@type=\"submit\"]");

    public void open() {
        String url = ConfigLoader.getProperty("PARABANK_URL");
        System.out.println("URL: " + url);
        webDriver.get(url);
        String title = webDriver.getTitle();
        assertEquals("ParaBank | Welcome | Online Banking", title);
    }

    public void login(String user, String pass){
        webDriver.findElement(username).sendKeys(user);
        webDriver.findElement(password).sendKeys(pass);
        webDriver.findElement(loginButton).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
