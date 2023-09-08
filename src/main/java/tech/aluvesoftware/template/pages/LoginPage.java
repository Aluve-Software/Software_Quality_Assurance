package tech.aluvesoftware.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tech.aluvesoftware.WebActions;

public class LoginPage {
    private WebDriver driver;
    private WebActions webActions;
    By byUsername = By.id("username");
    By byPassword = By.id("password");
    By byLoginButton = By.xpath("//button[@type='submit']//i");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        webActions = new WebActions(driver, 30);
    }

    public void populateUsername(String username) {
        driver.findElement(byUsername).sendKeys(username);
    }

    public void populatePassword(String password) {
        driver.findElement(byPassword).sendKeys(password);
    }

    public void LoginUser(){
       webActions.clickElement(byLoginButton);
    }

    public void openPage(){
        driver.get("https://the-internet.herokuapp.com/login");
    }
}
