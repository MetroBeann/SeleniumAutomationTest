package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserDriver;

import java.time.Duration;

public class LoginStep {

    private WebDriver driver = BrowserDriver.driver;

    @Given("the user is on the Monkeytype homepage")
    public void the_user_is_on_the_monkeytype_homepage() {
        driver.get("https://monkeytype.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    @When("the user clicks the profile button")
    public void the_user_clicks_the_profile_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/header/nav/a[5]")));
        profileBtn.click();
    }

    @Then("the login modal should appear")
    public void the_login_modal_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='pageLogin']/div[4]")));

        if (!modal.isDisplayed()) {
            throw new AssertionError("Login modal did not appear");
        }
    }

    @Then("the user enters email {string}")
    public void the_user_enters_email(String emailInput) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pageLogin']/div[4]/form/input[1]")));
        email.clear();
        email.sendKeys(emailInput);
    }

    @Then("the user enters password {string}")
    public void the_user_enters_password(String passwordInput) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pageLogin']/div[4]/form/input[2]")));
        password.clear();
        password.sendKeys(passwordInput);
    }

    @Then("the user clicks on log in button")
    public void the_user_clicks_on_log_in_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pageLogin']/div[4]/form/button")));
        loginBtn.click();
    }

    @Then("the user should be redirected to the landing page")
    public void the_user_should_be_redirected_to_the_landing_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for redirection (e.g., presence of account element)
        boolean landed = wait.until(driver -> driver.getCurrentUrl().contains("/account"));

        if (!landed) {
            throw new AssertionError("Login failed or landing page not reached.");
        }

    }
}