package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class GooglePlusPage {
    protected static WebDriver driver;
    static final Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(id = "logo")
    protected WebElement googlePlusLogo;

    public GooglePlusPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isGooglePlusPage() {
        logger.info("is g+ page" + googlePlusLogo.isDisplayed());
        return googlePlusLogo.isDisplayed();
    }
}
