package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class ForgottenPasswordPage {

    @FindBy(className = "page-subheading")
    protected WebElement pageHeading;

    @FindBy(id = "email")
    protected WebElement emailTextBox;

    @FindBy(css = ".submit button")
    protected WebElement retrievePasswordButton;

    @FindBy(css = ".alert ol li")
    protected WebElement errorMessage;

    @FindBy(css = ".alert")
    protected WebElement successMessage;

    protected final String HEADER = "Forgot your password?";
    protected final String UNREGISTERED_USER_ERROR_MESSAGE = "There is no account registered for this email address.";
    protected final String REGISTERED_USER_SUCCESS_MESSAGE = "A confirmation email has been sent to your address: ";

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    public ForgottenPasswordPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean isForgottenPasswordPage() {
        logger.info("is it forgotten password page " + pageHeading.getAttribute("innerHTML"));
        return pageHeading.getAttribute("innerHTML").equals(HEADER);
    }

    public void enterTextInEmailTextBox(String emailAddress) {
        logger.info("emailAddress is  " + emailAddress);
        emailTextBox.sendKeys(emailAddress);
    }
    public void clickRetrievePasswordButton() {
        logger.info("clicking Retrieve Password  ");
        retrievePasswordButton.click();
    }

    public boolean verifyErrorMessageForUnregisteredUser() {
        logger.info("check for unregistered user "+ errorMessage.getText().equals(UNREGISTERED_USER_ERROR_MESSAGE));
        return errorMessage.getText().equals(UNREGISTERED_USER_ERROR_MESSAGE);
    }

    public boolean verifySuccessMessageForRegisteredUser(String emailAddress) {
        logger.info("check for registered user "+ successMessage.getText().equals(REGISTERED_USER_SUCCESS_MESSAGE + emailAddress));
        return successMessage.getText().equals(REGISTERED_USER_SUCCESS_MESSAGE + emailAddress);
    }
}
