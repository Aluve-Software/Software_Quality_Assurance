package tech.aluvesoftware.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tech.aluvesoftware.web.TestContext;
import tech.aluvesoftware.web.manager.PageObjectManager;
import tech.aluvesoftware.web.pages.LoginPage;
import tech.aluvesoftware.web.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class WebSteps {
    public WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public TestContext testContext;
    public PageObjectManager pageObjectManager;

    public WebSteps(TestContext context) {
        testContext = context;
        driver = testContext.getDriver();
        pageObjectManager = testContext.getPageObjectManager();
        loginPage = pageObjectManager.getLoginPage();
        mainPage = pageObjectManager.getMainPage();
    }

    @Given("the user is on the landing page")
    public void theUserNavigatesToTheLoginPage() {
        loginPage.openPage();
    }

    @When("the user logs in with the username {string} and password {string}")
    public void theUserLogsInWithTheUsernameAndPassword(String username, String password) {
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.LoginUser();
    }

    @Then("the user is redirected to the main page")
    public void theUserIsRedirectedToTheMainPage() {
       boolean isUserRedirected = mainPage.isPageLoaded();
       assertTrue(isUserRedirected);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
