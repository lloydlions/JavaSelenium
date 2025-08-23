package org.example.framework;

import org.example.util.ConfigLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {}

    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = TL.get();
        if (driver == null) {
            driver = WebDriverFactory.create(
                    ConfigLoader.getProperty("BROWSER") != null ? ConfigLoader.getProperty("BROWSER") : "CHROME");
            TL.set(driver);
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TL.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = TL.get();
        if (driver != null) {
            driver.quit();
            TL.remove();
        }
    }
}
