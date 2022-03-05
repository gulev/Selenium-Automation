package com.practice.webpages;

import managers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductDetailsPage {
    static final Logger logger = Logger.getLogger(SearchResultPage.class);
    protected WebDriver driver;

    @FindBy(id = "short_description_block")
    protected WebElement productShortDescription;

    @FindBy(id = "add_to_cart")
    protected WebElement addToCardButton;

    @FindBy(id = "wishlist_button")
    protected WebElement addToWishlistButton;

    @FindBy(className = "fancybox-error")
    protected WebElement addedToWishlistMessage;

    @FindBy(id = "header_logo")
    protected WebElement headerLogo;

    @FindBy(className = "fancybox-close")
    protected WebElement closeWishlistModalDialogButton;

    @FindBy(css = ".pb-center-column h1[itemprop=\"name\"]")
    protected WebElement productName;

    @FindBy(css = "#bigpic")
    protected WebElement productImage;

    protected String SuccsessfulWithlistMessage = "Added to your wishlist.";

    public ProductDetailsPage(){
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public boolean isShortDescriptionExists() {
        logger.info("getting description....");
        return productShortDescription.getText().length() > 0;
    }

    public boolean isAddToCardButtonExist(){
        return addToCardButton.isDisplayed();
    }

    public void clickAddToWishlistButton(){
        addToWishlistButton.click();
    }

    public boolean isCorrectWishlistMessage(){
        return addedToWishlistMessage.getAttribute("innerHTML").trim().equals(SuccsessfulWithlistMessage);
    }

    public void clickOnHeaderLogo() {
        logger.info("clickOnHeaderLogo");
        headerLogo.click();
    }

    public void clickOnCloseWishlistModal() {
        logger.info("clickOnCloseWishlistModal");
        closeWishlistModalDialogButton.click();
    }

    public String getProductName(){
        logger.info("getProductName" + productName.getAttribute("innerHTML").trim());
        return productName.getAttribute("innerHTML").trim();
    }

    public String getProductImage(){
        logger.info("getProductImage" + productImage.getAttribute("src").replace("large_default",""));
        return productImage.getAttribute("src").replace("large_default","");
    }
}