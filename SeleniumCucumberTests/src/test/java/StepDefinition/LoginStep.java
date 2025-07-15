package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.BrowserDriver;

import java.time.Duration;

public class LoginStep {

    private WebDriver driver = BrowserDriver.driver;
    private final LoginPage loginPage = new LoginPage();

    @Given("the user is on the Monkeytype homepage")
    public void the_user_is_on_the_monkeytype_homepage() {
        driver.get("https://monkeytype.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    @Then("the user clicks Accept All")
    public void the_user_clicks_Accept_All() {
        loginPage.clickAcceptAll();
    }

    @When("the user clicks the profile button")
    public void the_user_clicks_on_the_profile_button() {
        loginPage.clickProfileButton();
    }


    @Then("the login modal should appear")
    public void the_login_modal_should_appear() {
        loginPage.validateLoginModal();
    }

    @Then("the user enters email {string}")
    public void the_user_enters_email(String emailInput) {
        loginPage.enterEmail(emailInput);
    }

    @Then("the user enters password {string}")
    public void the_user_enters_password(String passwordInput) {
        loginPage.enterPassword(passwordInput);
    }

    @Then("the user clicks on log in button")
    public void the_user_clicks_on_log_in_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the landing page")
    public void the_user_should_be_redirected_to_the_landing_page() {
        loginPage.clickLogo();
    }

}