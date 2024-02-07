package features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MailChimpsteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Given("^I am on the Mailchimp registration page$")
    public void i_am_on_the_Mailchimp_registration_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
    }

    @When("^I enter valid user details$")
    public void i_enter_valid_user_details() throws Throwable {
        WebElement username = driver.findElement(By.id("new_username"));
        username.sendKeys("valid Username");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("valid email");

        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys("valid Password");
    }

    @When("^I submit the form$")
    public void i_submit_the_form() throws Throwable {
        WebElement signupButton = driver.findElement(By.id("create-account-enabled"));
        signupButton.click();
    }

    @Then("^I should be registered successfully$")
    public void i_should_be_registered_successfully() throws Throwable {
        By successMessageLocator = By.xpath("//*[@id='signup-success']/div/div[1]/section/div");
        WebElement successMessage = driver.findElement(successMessageLocator);
        Assert.assertEquals("Expected registration successfully", "Success Message", successMessage.getText());

        // Close the browser
        driver.quit();
    }

    @Given("^I am on the Mailchimp registration page for long username$")
    public void i_am_on_the_Mailchimp_registration_page_for_long_username() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
    }

    @When("^I enter a username longer than 100 characters$")
    public void i_enter_a_username_longer_than_100_characters() throws Throwable {
        WebElement username = driver.findElement(By.id("new_username"));
        username.sendKeys("a".repeat(101));
    }

    @When("^I submit the form for long username$")
    public void i_submit_the_form_for_long_username() throws Throwable {
        WebElement signupButton = driver.findElement(By.id("create-account-enabled"));
        signupButton.click();
    }

    @Then("^I should see a username length error$")
    public void i_should_see_a_username_length_error() throws Throwable {
        WebElement errorMessage = driver.findElement(By.xpath("//span[@class='invalid-error']"));
        Assert.assertEquals("Enter a value less than 100 characters long", errorMessage.getText());
    }

    @Given("^I am on the Mailchimp registration page for existing username$")
    public void i_am_on_the_Mailchimp_registration_page_for_existing_username() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
    }

    @When("^I enter an existing username$")
    public void i_enter_an_existing_username() throws Throwable {
        WebElement username = driver.findElement(By.id("new_username"));
        username.sendKeys("existingUsername");
    }

    @When("^I submit the form for existing username$")
    public void i_submit_the_form_for_existing_username() throws Throwable {
        WebElement signupButton = driver.findElement(By.id("create-account-enabled"));
        signupButton.click();
    }

    @Then("^I should see a username already exists error$")
    public void i_should_see_a_username_already_exists_error() throws Throwable {
        String expectedErrorMessage = "Great minds think alike - someone already has this username. If it's you";

        WebElement errorMessage = driver.findElement(By.xpath("//span[@class='invalid-error' and contains(text(), '" + expectedErrorMessage + "')]"));
        Assert.assertEquals("Username already exists", expectedErrorMessage, errorMessage.getText());
    }

    @Given("^I am on the Mailchimp registration page for missing email$")
    public void i_am_on_the_Mailchimp_registration_page_for_missing_email() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
    }

    @When("^I do not enter an email$")
    public void i_do_not_enter_an_email() throws Throwable {
        // Ingen kod här eftersom steget bara är att inte ange e-post
    }

    @When("^I submit the form for existing username$")
    public void i_submit_the_form_for_existing() throws Throwable {
        WebElement signupButton = driver.findElement(By.id("create-account-enabled"));
        signupButton.click();
    }


    @Then("^I should see an email format error$")
    public void i_should_see_an_email_format_error() throws Throwable {
        By errorMessageLocator = By.xpath("//*[@id='signup-form']/fieldset/div[1]/div/span");
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        Assert.assertEquals("An email address must contain a single @", errorMessage.getText());
    }
}
