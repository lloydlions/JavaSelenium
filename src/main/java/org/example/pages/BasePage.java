package org.example.pages;

import org.example.framework.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(){
        webDriver = DriverManager.getDriver();
    }
}
