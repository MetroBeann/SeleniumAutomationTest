# Project Structure [Diagram]
* SeleniumCucumberTests/
* ├── .idea/
* ├── .mvn/
* ├── src/
* │   ├── main/
* │   │   ├── java/
* │   │   └── resources/
* │   └── test/
* │       ├── java/
* │       │   ├── features/
* │       │   │   └── LoginPage.feature
* │       │   ├── pages/
* │       │   │   └── LoginPage.java
* │       │   ├── runner/
* │       │   │   └── TestRunner.java
* │       │   ├── StepDefinition/
* │       │   │   └── LoginStep.java
* │       │   └── utilities/
* │       │       └── BrowserDriver.java
* │       └── resources/
* │           └── drivers/
* │               └── chromedriver_136x.exe
* ├── target/
* ├── .gitignore
* ├── cucumber.json
* ├── pom.xml
* └── readme.md



# Component Connections Flow

[**1. Feature Files → Step Definitions**]()

LoginPage.feature connects directly to LoginStep.java

The connection happens through Gherkin statements (Given/When/Then)

Each statement in the feature file has a matching annotated method in LoginStep
Example:

Feature statement: `Given the user is on the Monkeytype homepage`

Step definition:` @Given("the user is on the Monkeytype homepage")` in LoginStep.java

##

**[2. Step Definitions → Page Objects]()**

LoginStep.java uses LoginPage.java for element interactions

Step definitions should call methods from page objects rather than containing WebElement interactions directly

In current implementation, LoginStep is directly using WebDriver rather than fully utilizing the LoginPage class

Ideally, statements like `the_user_enters_email()` would call `loginPage.enterUsername(emailInput)` from LoginPage class

##
**[3. Step Definitions → Utilities]()**

LoginStep.java uses BrowserDriver.java to access the WebDriver instance

The connection happens through the static WebDriver variable:
`javaprivate WebDriver driver = BrowserDriver.driver;`

This shared WebDriver instance ensures all steps use the same browser session

##
**[4. TestRunner → Feature Files + Step Definitions]()**

TestRunner.java connects to both features and step definitions through Cucumber options:

`java@CucumberOptions(
features = "src/test/java/features",
glue = {"StepDefinition", "utilities"}
)`

The features parameter points to feature file location

The glue parameter points to packages containing step definitions and hooks

##
**[5. Utilities → Resources]()**

BrowserDriver.java connects to chromedriver_136x.exe in resources folder:

`javaSystem.setProperty("webdriver.chrome.driver",
System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver_136x.exe");`

This sets up the path to the ChromeDriver executable needed to control Chrome browser

##
**[Complete Connection Flow]()**

TestRunner initiates the test execution process by reading feature files and connecting them with step definitions
Feature files define test scenarios that are mapped to methods in step definition files
Step definition files implement the test steps and use:

Page objects for element interactions (or should, in a complete POM implementation)
Utilities for browser management


Page objects contain element locators and methods to interact with web elements
Utilities set up the test environment and manage resources

##
**[Enhancement Opportunity]()**

The current implementation could better utilize the Page Object Model by having LoginStep fully rely on LoginPage methods rather than directly working with WebDriver. 

For example:

`java// Current implementation in LoginStep
@Then("the user enters email {string}")
public void the_user_enters_email(String emailInput){
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//*[@id='pageLogin']/div[4]/form/input[1]")));
email.clear();
email.sendKeys(emailInput);
}`

Better implementation using Page Object Model

`@Then("the user enters email {string}")
public void the_user_enters_email(String emailInput) {
LoginPage loginPage = new LoginPage(driver);
loginPage.enterUsername(emailInput);
}`

This would strengthen the connections between components and improve maintainability of test suite.