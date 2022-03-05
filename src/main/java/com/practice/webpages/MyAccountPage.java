package com.practice.webpages;

import managers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import Utils.WaitUtils;

public class MyAccountPage {

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "page-heading")
    protected WebElement pageHeading;

    @FindBy(className = "info-account")
    protected WebElement infoAccount;

    @FindBy(className = "logout")
    protected WebElement SignOutLink;

    @FindBy(css = ".header_user_info .account span")
    protected WebElement userInfo;

    @FindBy(css = ".myaccount-link-list a[title~=\"Orders\"] span")
    protected WebElement orderHistoryAndDetailsCategory;

    @FindBy(css = ".myaccount-link-list a[title~=\"Credit\"] span")
    protected WebElement myCreditSlipsCategory;

    @FindBy(css = ".myaccount-link-list a[title~=\"Addresses\"] span")
    protected WebElement myAddressesCategory;

    @FindBy(css = ".myaccount-link-list a[title~=\"Information\"] span")
    protected WebElement myPersonalInformationCategory;

    @FindBy(css = ".myaccount-link-list a[title~=\"wishlists\"] span")
    protected WebElement myWishlistsCategory;

    protected String accountMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

    public MyAccountPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        WaitUtils.waitForElementPresent(orderHistoryAndDetailsCategory,5,driver);
    }

    public boolean isMyAccountPage() {
        String loginText = pageHeading.getText();
        logger.info("IS my account page " + loginText);
        return (loginText.equals("MY ACCOUNT"));
    }

    public boolean isSignOutDisplayed() {
        logger.info("isSignOutDisplayed " + SignOutLink.isDisplayed());
        return SignOutLink.isDisplayed();
    }

    public String getUserInfo(){
        logger.info("get user info" + userInfo.getText());
        return userInfo.getText();
    }

    public boolean isOrderHistoryAndDetailsCategoryDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + orderHistoryAndDetailsCategory.isDisplayed());
        return orderHistoryAndDetailsCategory.isDisplayed();
    }

    public boolean isMyCreditSlipsCategoryDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + myCreditSlipsCategory.isDisplayed());
        return myCreditSlipsCategory.isDisplayed();
    }

    public boolean isMyAddressesCategoryDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + myAddressesCategory.isDisplayed());
        return myAddressesCategory.isDisplayed();
    }

    public boolean isMyPersonalInformationCategoryDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + myPersonalInformationCategory.isDisplayed());
        return myPersonalInformationCategory.isDisplayed();
    }

    public boolean isMyWishlistsCategoryDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + myWishlistsCategory.isDisplayed());
        return myWishlistsCategory.isDisplayed();
    }

    public boolean isInfoAccountMessageDisplayed(){
        logger.info("orderHistoryAndDetailsCategory" + infoAccount.getText());
        return myWishlistsCategory.getText().contentEquals(accountMessage);
    }

    public void clickMyAddressesCategory(){
        logger.info("clicking address category");
         myAddressesCategory.click();
    }

    public void clickMyPersonalInformationCategory(){
        logger.info("clicking address category");
        myPersonalInformationCategory.click();
    }

    public void clickOnSignOutLink() {
        logger.info("singoing out ");
        SignOutLink.click();
    }

    public void clickOnmyWishlistsCategory(){
        myWishlistsCategory.click();
    }
}
