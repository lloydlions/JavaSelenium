package parabank.pages;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final By leftMenu = By.xpath("//ul[@class=\"leftmenu\"]//li");
    private final By leftBodyPanel = By.xpath("//div[@id=\"leftPanel\"]//ul//li");
    private final By accountsOverview = By.xpath("//div[@id=\"showOverview\"]");

    public List<String> getLeftMenuItems(){
        return webDriver.findElements(leftMenu).stream().map(e -> e.getText().trim()).toList();
    }

    public List<String> getLeftBodyPanelItems(){
        return webDriver.findElements(leftBodyPanel).stream().map(e -> e.getText().trim()).toList();
    }

    public boolean isAccountsOverviewDisplayed(){
        WebElement parentElement = webDriver.findElement(accountsOverview);
        return parentElement.findElement(By.xpath(".//table[@id=\"accountTable\"]")).isDisplayed();
    }

}
