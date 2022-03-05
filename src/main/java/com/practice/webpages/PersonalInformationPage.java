package com.practice.webpages;

import managers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import Utils.WaitUtils;
import enums.Gender;
import enums.MonthsInWords;

public class PersonalInformationPage {

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "page-subheading")
    protected WebElement pageSubheading;

    @FindBy(css = "button[name=submitIdentity]")
    protected WebElement saveButton;

    @FindBy(id = "id_gender1")
    protected WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    protected WebElement mrsRadioButton;

    @FindBy(id = "firstname")
    protected WebElement firstNameTextBox;

    @FindBy(id = "lastname")
    protected WebElement lastNameTextBox;

    @FindBy(id = "email")
    protected WebElement emailTextBox;

    @FindBy(id = "days")
    protected WebElement daysDropDown;

    @FindBy(id = "months")
    protected WebElement monthsDropDown;

    @FindBy(id = "years")
    protected WebElement yearsDropDown;

    @FindBy(id = "newsletter")
    protected WebElement newsLetterCheckbox;

    @FindBy(id = "optin")
    protected WebElement recieveSpecialOffersCheckbox;

    @FindBy(className = "logout")
    protected WebElement SignOutLink;

    protected String pageSubheadingText = "YOUR PERSONAL INFORMATION";

    public PersonalInformationPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        WaitUtils.waitForElementPresent(pageSubheading,5, driver);
    }

    public boolean isPersonalInformationPage() {
        String headerText = pageSubheading.getText();
        logger.info("Is it personal information page " + headerText);
        return (headerText.equals(pageSubheadingText));
    }

    public boolean isSaveButtonDisplayed() {
        logger.info("is saveButton isDisplayed()" + saveButton.isDisplayed());
        return saveButton.isDisplayed();
    }

    public String getFirstName(){
        logger.info("firstNameTextBox " + firstNameTextBox.getAttribute("value"));
        return firstNameTextBox.getAttribute("value");
    }

    public String getLastName(){
        logger.info("lastNameTextBox " + lastNameTextBox.getAttribute("value"));
        return lastNameTextBox.getAttribute("value");
    }

    public String getEmailAddress(){
        logger.info("emailTextBox " + emailTextBox.getAttribute("value"));
        return emailTextBox.getAttribute("value");
    }

    public String getDaysFromDateOfBirthDropDown(){
        Select dropdown = new Select(daysDropDown);
        logger.info("getDaysFromDateOfBirthDropDown " + dropdown.getFirstSelectedOption().getText());
        return dropdown.getFirstSelectedOption().getText().trim();
    }

    public MonthsInWords getMonthsFromDateOfBirthDropDown(){
        Select dropdown = new Select(monthsDropDown);
        logger.info("getMonthsFromDateOfBirthDropDown " + dropdown.getFirstSelectedOption().getText());
        String value = dropdown.getFirstSelectedOption().getText().trim();
        switch(value){
            case "January":
                return MonthsInWords.JANUARY;
            case "February":
                return MonthsInWords.FEBRUARY;
            case "March":
                return MonthsInWords.MARCH;
            case "April":
                return MonthsInWords.APRIL;
            case "May":
                return MonthsInWords.MAY;
            case "June":
                return MonthsInWords.JUNE;
            case "July":
                return MonthsInWords.JULY;
            case "August":
                return MonthsInWords.AUGUST;
            case "September":
                return MonthsInWords.SEPTEMBER;
            case "October":
                return MonthsInWords.OCTOBER;
            case "November":
                return MonthsInWords.NOVEMBER;
            case "December":
                return MonthsInWords.DECEMBER;
            default:
                return MonthsInWords.DECEMBER;
        }
    }

    public String getYearsFromDateOfBirthDropDown(){
        Select dropdown = new Select(yearsDropDown);
        logger.info("getYearsFromDateOfBirthDropDown " + dropdown.getFirstSelectedOption().getText());
        return dropdown.getFirstSelectedOption().getText().trim();
    }

    public boolean isSignupForNewsLetterChecked() {
        return newsLetterCheckbox.isSelected();
    }

    public boolean isRecieveSpecialOffersChecked() {
        return recieveSpecialOffersCheckbox.isSelected();
    }

    public Gender getGender(){
        logger.info("get gender" + mrRadioButton.isSelected());
        return  mrRadioButton.isSelected() ? Gender.MALE : Gender.FEMALE;
    }

    public void clickOnSignOutLink() {
        logger.info("singoing out ");
        SignOutLink.click();
    }
}