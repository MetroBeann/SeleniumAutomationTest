package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // XPaths for a generic login form. You must adjust these based on actual website structure.
    By usernameField = By.xpath("//*[@id='pageLogin']/div[4]/form/input[1]");
    By passwordField = By.xpath("//*[@id='pageLogin']/div[4]/form/input[2]");
    By loginButton = By.xpath("//*[@id='pageLogin']/div[4]/form/button");

    //*[@id="pageLogin"]/div[4]/form/input[1]
    //*[@id="pageLogin"]/div[4]/form/input[2]
    //*[@id="pageLogin"]/div[4]/form/button

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

//    public String getMessage() {
//        return driver.findElement(message).getText();
//    }
}