package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class AuthenticationPage {

    @FindBy(css = ".page-heading")
    protected WebElement pageHeading;

    @FindBy(id = "email_create")
    protected WebElement createAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    protected WebElement createAnAccountButton;

    @FindBy(css = ".lost_password a")
    protected WebElement forgotYourPasswordLink;

    @FindBy(id = "email")
    protected WebElement logInEmailAddressInput;

    @FindBy(id = "passwd")
    protected WebElement logInPasswordInput;

    @FindBy(id = "SubmitLogin")
    protected WebElement signInButton;

    @FindBy(css = ".alert-danger ol li")
    protected WebElement invalidPasswordErrorMessage;

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    protected final String okIcon = "http://automationpractice.com/themes/default-bootstrap/img/icon/form-ok.png";
    protected final String INVALID_PASSWORD = "Invalid password.";

    public AuthenticationPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isAuthenticationPage() {
        logger.info("is it authentication page ");
        return pageHeading.isDisplayed();
    }

    public void fillEmailAddressInCreateAnAccountSection(String input) {
        logger.info("filling emailaddress input....");
        createAccountEmailInput.sendKeys(input);
    }

    public void clickCreateAnAccountbutton() {
        logger.info("clicking create an account button....");
        createAnAccountButton.click();
    }

    public boolean isValidEmailAddress() {
        logger.info("is it valid email address " + createAccountEmailInput.getCssValue("background"));
        boolean bgGreen = createAccountEmailInput.getCssValue("background-color").equals("rgba(221, 249, 225, 1)");
        boolean isIconDisplayed = createAccountEmailInput.getCssValue("background").contains(okIcon);
        return bgGreen && isIconDisplayed;
    }

    public void clickForgotYourPasswordLink() {
        logger.info("clicking forgot your password link");
        forgotYourPasswordLink.click();
    }

    public void fillEmailAddressInLoginSection(String input) {
        logger.info("filling emailaddress input in login section....");
        logInEmailAddressInput.sendKeys(input);
    }

    public void fillPasswordInLoginSection(String input) {
        logger.info("filling password input....");
        logInPasswordInput.sendKeys(input);
    }

    public void clickSignInButton() {
        logger.info("clicking sign in button");
        signInButton.click();
    }

    public boolean isInvalidPasswordMessageDisplayed() {
        logger.info("is Invalid Password Message Displayed");
        return invalidPasswordErrorMessage.getAttribute("innerHTML").equals(INVALID_PASSWORD);
    }
}
