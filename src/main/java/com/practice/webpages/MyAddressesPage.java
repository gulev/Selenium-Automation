package com.practice.webpages;

import managers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import Utils.WaitUtils;

public class MyAddressesPage {

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "page-heading")
    protected WebElement pageHeading;

    @FindBy(css = ".address_update a[title~=\"Update\"] span")
    protected WebElement updateButton;

    @FindBy(css = ".address_update a[title~=\"Delete\"] span")
    protected WebElement deleteButton;

    @FindBy(css = "a[href=\"http://automationpractice.com/index.php?controller=address\"] span")
    protected WebElement addNewAddressButton;

    @FindBy(css = ".page-subheading")
    protected WebElement subHeadingAddress;

    @FindBy(css = ".address_name:nth-child(1)")
    protected WebElement addressNameOne;

    @FindBy(css = ".address_name:nth-child(2)")
    protected WebElement addressNameTwo;

    @FindBy(css = ".address_company")
    protected WebElement addressCompany;

    @FindBy(css = ".address_address1")
    protected WebElement addressOne;

    @FindBy(css = ".address_address2")
    protected WebElement addressTwo;

    @FindBy(css = ".last_item li:nth-child(5) span:nth-child(1)")
    protected WebElement city;

    @FindBy(css = ".last_item li:nth-child(5) span:nth-child(2)")
    protected WebElement state;

    @FindBy(css = ".last_item li:nth-child(5) span:nth-child(3)")
    protected WebElement zipCode;

    @FindBy(css = ".last_item li:nth-child(6) span")
    protected WebElement country;

    @FindBy(css = ".address_phone")
    protected WebElement phone;

    @FindBy(css = ".address_phone_mobile")
    protected WebElement mobilePhone;

    @FindBy(className = "logout")
    protected WebElement SignOutLink;

    protected String pageHeadingText = "MY ADDRESSES";

    public MyAddressesPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        WaitUtils.waitForElementPresent(updateButton,5, driver);
    }

    public boolean isMyAddressesPage() {
        String headerText = pageHeading.getText();
        logger.info("IS my account page " + headerText);
        return (headerText.equals(pageHeadingText));
    }

    public boolean isUpdateButtonPresent() {
        logger.info("isUpdateButtonPresent ");
        return updateButton.isDisplayed();
    }

    public boolean isDeleteButtonPresent() {
        logger.info("isDeleteButtonPresent ");
        return deleteButton.isDisplayed();
    }

    public boolean isAddNewAddressButtonPresent() {
        logger.info("addNewAddressButton  ");
        return addNewAddressButton.isDisplayed();
    }

    public String getAliasSubHeadingText() {
        logger.info("getAliasSubHeadingText is   " + subHeadingAddress.getAttribute("innerHTML"));
        return subHeadingAddress.getAttribute("innerHTML").trim();
    }

    public String getAddressNameOneText() {
        logger.info("addressNameOne is   " + addressNameOne.getAttribute("innerHTML"));
        return addressNameOne.getAttribute("innerHTML").trim();
    }

    public String getAddressNameTwoText() {
        logger.info("addressNameTwo is   " + addressNameTwo.getAttribute("innerHTML"));
        return addressNameTwo.getAttribute("innerHTML").trim();
    }

    public String getAddressCompanyText() {
        logger.info("addressCompany is   " + addressCompany.getAttribute("innerHTML"));
        return addressCompany.getAttribute("innerHTML").trim();
    }

    public String getAddressOneText() {
        logger.info("addressOne is   " + addressOne.getAttribute("innerHTML"));
        return addressOne.getAttribute("innerHTML").trim();
    }

    public String getAddressTwoText() {
        logger.info("addressTwo is   " + addressTwo.getAttribute("innerHTML"));
        return addressTwo.getAttribute("innerHTML").trim();
    }

    public String getCityText() {
        logger.info("city is   " + city.getAttribute("innerHTML"));
        return city.getAttribute("innerHTML").replace(",", "").trim();
    }

    public String getStateText() {
        logger.info("state is   " + state.getAttribute("innerHTML"));
        return state.getAttribute("innerHTML").trim();
    }

    public String getZipCodeText() {
        logger.info("zipCode is   " + zipCode.getAttribute("innerHTML"));
        return zipCode.getAttribute("innerHTML").trim();
    }

    public String getCountryText() {
        logger.info("country is   " + country.getAttribute("innerHTML"));
        return country.getAttribute("innerHTML").trim();
    }

    public String getPhoneText() {
        logger.info("phone is   " + phone.getAttribute("innerHTML"));
        return phone.getAttribute("innerHTML").trim();
    }

    public String getMobilePhoneText() {
        logger.info("mobilePhone is   " + mobilePhone.getAttribute("innerHTML"));
        return mobilePhone.getAttribute("innerHTML").trim();
    }

    public void clickOnSignOutLink() {
        logger.info("singoing out ");
        SignOutLink.click();
    }
}
