package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class FacebookPage {

    protected static WebDriver driver;
    static final Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(css = ".fb_logo")
    protected WebElement facebookLogo;

    public FacebookPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isFacebookPage() {
        logger.info("is facebook page");
        return facebookLogo.isDisplayed();
    }
}
