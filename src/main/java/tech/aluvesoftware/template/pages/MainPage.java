package tech.aluvesoftware.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tech.aluvesoftware.WebActions;

public class MainPage {
    private final WebDriver driver;
    private WebActions webActions;
    By byLandingTextDisplay = By.xpath("//h4[text() = 'Welcome to the Secure Area. When you are done click logout below.']");
    By byLogoutBtn = By.xpath("//a[@href='/logout']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        webActions = new WebActions(driver, 30);
    }

    public void clickLogoutButton(){
        webActions.clickElement(byLogoutBtn);
    }
    public boolean isPageLoaded(){
        return driver.findElement(byLandingTextDisplay).isDisplayed();
    }
}
