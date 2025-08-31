package org.example.pages;

import org.example.framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(){
        webDriver = DriverManager.getDriver();
    }
}
