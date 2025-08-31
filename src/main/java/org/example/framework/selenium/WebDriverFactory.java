package org.example.framework.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.exception.InvalidBrowserException;
import org.example.util.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

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
            case "EDGE" -> {
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                yield new EdgeDriver();
            }
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
