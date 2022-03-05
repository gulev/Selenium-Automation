package com.practice.webpages;

import managers.DriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import Utils.BrowserTabsUtils;

public class FooterPage {

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(css = ".facebook a")
    protected WebElement facebookLink;

    @FindBy(css = ".twitter a")
    protected WebElement twitterLink;

    @FindBy(css = ".youtube a")
    protected WebElement youtubeLink;

    @FindBy(css = ".google-plus a")
    protected WebElement googlePlusLink;

    public FooterPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickOnFacebookLink() {
        logger.info("clicking facebook link");
        facebookLink.click();
    }

    public void clickOnTwitterLink() {
        logger.info("clicking twitter link");
        twitterLink.click();
    }

    public void clickOnYouTubeLink() {
        logger.info("clicking youtube link");
        youtubeLink.click();
    }

    public void clickOnGooglePlusLink() {
        logger.info("clicking google plus link");
        googlePlusLink.click();
    }

    public void moveToTheNextTab(){
        BrowserTabsUtils.moveToTheNextTab(driver);
    }

    public void killTab(){
        BrowserTabsUtils.killTab(driver);
    }
}
