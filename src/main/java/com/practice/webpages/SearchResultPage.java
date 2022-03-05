package com.practice.webpages;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class SearchResultPage {
    static final Logger logger = Logger.getLogger(SearchResultPage.class);
    protected WebDriver driver;

    @FindBy(className = "heading-counter")
    protected WebElement resultText;

    @FindBy(className = "alert-warning")
    protected WebElement emptyResult;

    static final String ENTER_SEARCH_KEY = "Please enter a search keyword";
    static final String NO_RESULTS_FOUND = "No results were found for your search ";

    public SearchResultPage() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public String getReturnedItems() {
        logger.info("resultText.getText() is " + resultText.getText());
        String[] text = resultText.getText().split(" ");
        logger.info("resultText.getText() is " + text[0]);
        return text[0];
    }

    public boolean isSearchResultEmpty(String searchItem) {
        logger.info("emptyResult is " + emptyResult.getText());
        Boolean result = emptyResult.getText().contentEquals(NO_RESULTS_FOUND + '"' + searchItem + '"');
        return result;
    }

    public boolean isSearchInvalid() {
        logger.info("InvalidSearch is " + emptyResult.getText());
        Boolean result = emptyResult.getText().contentEquals(ENTER_SEARCH_KEY);
        return result;
    }
}
