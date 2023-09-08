package tech.aluvesoftware.template.pages.manager;

import org.openqa.selenium.WebDriver;
import tech.aluvesoftware.template.pages.LoginPage;
import tech.aluvesoftware.template.pages.MainPage;


public class PageObjectManager {
    private final WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public MainPage getMainPage() {
        if (mainPage == null){
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }


}
