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
        // Add a small delay to ensure page loads
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the user clicks the profile button")
    public void the_user_clicks_the_profile_button() {
        // Use WebDriverWait to ensure element is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/header/nav/a[5]")));
        loginBtn.click();
    }

    @Then("the login modal should appear")
    public void the_login_modal_should_appear() {
        // Wait for modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".loginModal")));

        if (!modal.isDisplayed()) {
            throw new AssertionError("Login modal did not appear");
        }
    }
}