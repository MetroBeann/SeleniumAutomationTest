package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

public class LoginPage {
    WebDriver driver = BrowserDriver.driver;

    By LoginButton = By.xpath("//*[@id='pageLogin']/div[4]/form/button");
    By AcceptAllButton = By.xpath("//*[@id='cookiesModal']/div[2]/div[2]/div[2]/button[1]");
    By ProfileButton = By.xpath("//*[@id='app']/header/nav/a[5]");
    By LoginModal = By.xpath("//*[@id='pageLogin']/div[4]");
    By emailButton = By.xpath("//*[@id='pageLogin']/div[4]/form/input[1]");
    By passwordButton = By.xpath("//*[@id='pageLogin']/div[4]/form/input[2]");
    By LogoButton = By.xpath("//*[@id='logo']");


    public void genericWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LoginPage() {
        WebDriver driver = BrowserDriver.driver;
    }

//    public void enterUsername(String username) {
//        WebElement usernameInput = driver.findElement(usernameField);
//        usernameInput.clear();
//        usernameInput.sendKeys(username);
//    }
//
//    public void enterPassword(String password) {
//        WebElement passwordInput = driver.findElement(passwordField);
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//    }
//
//    public void clickLogin() {
//        driver.findElement(loginButton).click();
//    }

    public void clickAcceptAll(){
        WebElement clickAcceptAll = driver.findElement(AcceptAllButton);
        clickAcceptAll.click();
        genericWait(2);
    }

    public void clickProfileButton(){
        WebElement clickProfileButton = driver.findElement(ProfileButton);
        clickProfileButton.click();
        genericWait(2);
    }

    public void validateLoginModal() {
        WebElement loginModalElement = driver.findElement(LoginModal);
        if (loginModalElement.isDisplayed()) {
            System.out.println("Login modal is displayed.");
        } else {
            System.out.println("Login modal is present but not visible.");
        }
        genericWait(2);
    }

    public void enterEmail(String emailInput){
        WebElement enterEmail = driver.findElement(emailButton);
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys(emailInput);
        genericWait(2);
    }

    public void enterPassword(String passwordInput){
        WebElement enterPassword = driver.findElement(passwordButton);
        enterPassword.click();
        enterPassword.clear();
        enterPassword.sendKeys(passwordInput);
        genericWait(2);
    }

    public void clickLogin(){
        WebElement clickLogin = driver.findElement(LoginButton);
        clickLogin.click();
    }

    public void clickLogo(){
        WebElement clickLogo = driver.findElement(LogoButton);
        clickLogo.click();
    }





}