package org.example.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.example.exception.InvalidBrowserException;
import org.example.util.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriverFactory {

    private WebDriverFactory() {}

    public static WebDriver create(String browser){
        return switch (browser.toUpperCase()) {
            case "CHROME" -> {
                String headless = ConfigLoader.getProperty("HEADLESS");
                if(headless.equalsIgnoreCase("true")){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    yield WebDriverManager.chromedriver().capabilities(options).create();
                }
                yield WebDriverManager.chromedriver().create();
            }
            case "EDGE" -> WebDriverManager.edgedriver().create();
            default -> {
                try {
                    throw new InvalidBrowserException();
                } catch (InvalidBrowserException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static WebDriver createChromeWithArgs(String browser, List<String> args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(args);
        WebDriver driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);
        return driver;
    }

}
