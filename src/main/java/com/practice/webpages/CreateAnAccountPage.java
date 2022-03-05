package com.practice.webpages;

import managers.DriverManager;
import Utils.DropDownUtil;
import Utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import enums.Gender;

public class CreateAnAccountPage {

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "page-heading")
    protected WebElement pageHeading;

    @FindBy(id = "id_gender1")
    protected WebElement ypiMrRadioButton;

    @FindBy(id = "id_gender2")
    protected WebElement ypiMrsRadioButton;

    @FindBy(id = "customer_firstname")
    protected WebElement ypiFirstNameTextBox;

    @FindBy(id = "customer_lastname")
    protected WebElement ypiLastNameTextBox;

    @FindBy(id = "email")
    protected WebElement ypiEmailTextBox;

    @FindBy(id = "passwd")
    protected WebElement ypiPasswordTextBox;

    @FindBy(id = "days")
    protected WebElement ypiDaysDropDown;

    @FindBy(id = "months")
    protected WebElement ypiMonthsDropDown;

    @FindBy(id = "years")
    protected WebElement ypiYearsDropDown;

    @FindBy(id = "newsletter")
    protected WebElement ypiNewsLetterCheckbox;

    @FindBy(id = "uniform-optin")
    protected WebElement ypiReceiveSpecialOffersCheckbox;

    @FindBy(id = "firstname")
    protected WebElement yaFirstName;

    @FindBy(id = "lastname")
    protected WebElement yaLastName;

    @FindBy(id = "company")
    protected WebElement yaCompany;

    @FindBy(id = "address1")
    protected WebElement yaAddress;

    @FindBy(id = "address2")
    protected WebElement yaAddressLine2;

    @FindBy(id = "city")
    protected WebElement yaCity;

    @FindBy(id = "id_state")
    protected WebElement yaState;

    @FindBy(id = "postcode")
    protected WebElement yaPostCode;

    @FindBy(id = "id_country")
    protected WebElement yaCountry;

    @FindBy(id = "phone")
    protected WebElement yaHomePhone;

    @FindBy(id = "phone_mobile")
    protected WebElement yaPhoneMobile;

    @FindBy(id = "alias")
    protected WebElement yaAddressAlias;

    @FindBy(id = "other")
    protected WebElement yaAdditionalInformation;

    @FindBy(id = "submitAccount")
    protected WebElement registerButton;

    @FindBy(className = "alert-danger")
    protected WebElement validationArea;

    @FindBy(css = ".alert-danger ol")
    protected WebElement validationInformation;

    public CreateAnAccountPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageCreateAnAccount() {
        String headingText = pageHeading.getText();
        logger.info("heading text is" + headingText);
        WaitUtils.waitForElementPresent(ypiFirstNameTextBox,10, driver);
        return !headingText.contains("Create an account");
    }

    public void chooseGender(Gender gender) {
        logger.info("choosing gender....");
        if (gender.equals(Gender.MALE)) {
            ypiMrRadioButton.click();
        } else {
            ypiMrsRadioButton.click();
        }
    }

    public void enterTextInFirstNameTextBoxInYourPersonalInformationSection(String firstName) {
        ypiFirstNameTextBox.sendKeys(firstName);
    }

    public void enterTextInLastNameTextBoxInYourPersonalInformationSection(String lastName) {
        ypiLastNameTextBox.sendKeys(lastName);
    }

    public void enterTextInEmailAddressTextBoxInYourPersonalInformationSection(String emailAddress) {
        ypiEmailTextBox.clear();
        ypiEmailTextBox.sendKeys(emailAddress);
    }

    public void enterTextInPasswordTextBoxInYourPersonalInformationSection(String password) {
        ypiPasswordTextBox.sendKeys(password);
    }

    public void selectDaysValueInDateOfBirthInYourPersonalInformationSection(String days) {
        DropDownUtil.selectValueFromDropDown(ypiDaysDropDown,days);
    }

    public void selectMonthsValueInDateOfBirthInYourPersonalInformationSection(String months) {
        DropDownUtil.selectValueFromDropDown(ypiMonthsDropDown,months);
    }

    public void selectYearsValueInDateOfBirthInYourPersonalInformationSection(String years) {
        DropDownUtil.selectValueFromDropDown(ypiYearsDropDown,years);
    }

    public void checkSignUpForNewsLetterCheckbox() {
        ypiNewsLetterCheckbox.click();
    }

    public void checkReceiveSpecialOffersCheckbox() {
        ypiReceiveSpecialOffersCheckbox.click();
    }

    public void enterTextInFirstNameTextBoxInYourAddressSection(String firstName) {
        yaFirstName.clear();
        yaFirstName.sendKeys(firstName);
    }

    public void enterTextInLastNameTextBoxInYourAddressSection(String lastName) {
        yaLastName.clear();
        yaLastName.sendKeys(lastName);
    }

    public void enterTextInCompanyTextBoxInYourAddressSection(String companyName) {
        yaCompany.sendKeys(companyName);
    }

    public void enterTextInAddressTextBoxInYourAddressSection(String address) {
        yaAddress.sendKeys(address);
    }

    public void enterTextInAddressLineTwoTextBoxInYourAddressSection(String address) {
        yaAddressLine2.sendKeys(address);
    }

    public void enterTextInCityTextBoxInYourAddressSection(String city) {
        yaCity.sendKeys(city);
    }

    public void enterTextInStateDropDownInYourAddressSection(String state) {
        DropDownUtil.selectValueFromDropDownByVisibleText(yaState,state);
    }

    public void enterTextInCountryDropDownInYourAddressSection(String country) {
        DropDownUtil.selectValueFromDropDownByVisibleText(yaCountry,country);
    }

    public void enterTextInZipCodeTextBoxInYourAddressSection(String zipCode) {
        yaPostCode.sendKeys(zipCode);
    }

    public void enterTextInHomePhoneTextBoxInYourAddressSection(String phoneNumber) {
        yaHomePhone.sendKeys(phoneNumber);
    }

    public void enterTextInMobilePhoneTextBoxInYourAddressSection(String phoneNumber) {
        yaPhoneMobile.sendKeys(phoneNumber);
    }

    public void enterTextInAddressAliasTextBoxInYourAddressSection(String address) {
        yaAddressAlias.clear();
        yaAddressAlias.sendKeys(address);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void enterTextInAdditionalInformationTextBoxInYourAddressSection(String info) {
        yaAdditionalInformation.sendKeys(info);
    }

    public boolean isValidationDisplayed() {
       return validationArea.isDisplayed();
    }

    public boolean isValidationMessageExist(String validationMessage) {
        String parseListAndBold = validationInformation.getAttribute("innerHTML")
                .replace("<li><b>","")
                .replace("</b>","")
                .replace("</li>","").trim();
        logger.info("parseListAndBold text is" + parseListAndBold);
        return parseListAndBold.contains(validationMessage);
    }
}
