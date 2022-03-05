package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class TwitterPage {

    protected static WebDriver driver;
    static final Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(className = "css-1dbjc4n")
    protected WebElement twitterLogo;

    public TwitterPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isTwitterPage() {
        logger.info("is twitter page" + twitterLogo.isDisplayed());
        return twitterLogo.isDisplayed();
    }
}
