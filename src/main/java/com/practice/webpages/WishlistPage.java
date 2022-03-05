package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class WishlistPage {

    @FindBy(className = "page-heading")
    protected WebElement pageHeading;

    @FindBy(id = "name")
    protected WebElement nameTextBox;

    @FindBy(id = "submitWishlist")
    protected WebElement saveButton;

    @FindBy(css = ".table-bordered tr td:first-child a")
    protected WebElement firstElementInWishlistTable;

    @FindBy(className = "icon-remove")
    protected WebElement deleteWishlist;

    @FindBy(className = "alert-warning")
    protected WebElement noProductsWarning;

    @FindBy(css = "#wlp_1_1 img")
    protected WebElement firstWishlistItemImage;

    @FindBy(css = "#wlp_1_1 .product-name")
    protected WebElement firstWishlistItemName;

    @FindBy(css = "#wlp_1_1 .lnkdel")
    protected WebElement firstWishlistItemDeleteButton;

    @FindBy(id = "header_logo")
    protected WebElement headerLogo;

    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    protected final static String NO_ITEMS_MESSAGE = "No products";

    public WishlistPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isWishlistPage() {
        logger.info("is it wishlist page ");
        return pageHeading.isDisplayed();
    }

    public void enterTextInNameTextBox(String name) {
        logger.info("name is  " + name);
        nameTextBox.sendKeys(name);
    }

    public void clickSaveButton() {
        logger.info("clicking save button  ");
        saveButton.click();
    }

    public void clickDeleteWishlist() {
        logger.info("deleting wishlist  ");
        deleteWishlist.click();
        driver.switchTo().alert().accept();
    }

    public String getFirstElementInWishlistTable(){
        logger.info("getFirstElementInWishlistTable " + firstElementInWishlistTable.getAttribute("innerHTML").trim());
        return firstElementInWishlistTable.getAttribute("innerHTML").trim();
    }

    protected boolean isElementPresent(WebElement el){
        try{
            el.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isEmptyWhishlistTable(){
        logger.info("isEmptyWhishlistTable " + firstElementInWishlistTable.isDisplayed());
        return isElementPresent(firstElementInWishlistTable);
    }

    public void clickWhishlistName() {
        logger.info("clicking wishlist name");
        firstElementInWishlistTable.click();
    }

    public boolean isNoProductsDisplayed() {
        logger.info("isNoProductsDisplayed ");
        return  noProductsWarning.getAttribute("innerHTML").trim().equals(NO_ITEMS_MESSAGE);
    }

    public String getFirstElementProductNameInWishlistExpandedItems(){
        logger.info("getFirstElementProductNameInWishlistExpandedItems "
                + firstWishlistItemName.getAttribute("innerHTML").split("<small>")[0].trim());
        return firstWishlistItemName.getAttribute("innerHTML").split("<small>")[0].trim();
    }

    public void clickDeleteButtonForFirstItemInWishlistExpandedItem() {
        logger.info("firstWishlistItemDeleteButton");
        firstWishlistItemDeleteButton.click();
    }

    public void clickOnHeaderLogo() {
        logger.info("clickOnHeaderLogo");
        headerLogo.click();
    }

    public String getWhishlistItemImage(){
        logger.info("getWhishlistItemImage" +
                firstWishlistItemImage.getAttribute("src").replace("home_default",""));
        return firstWishlistItemImage.getAttribute("src").replace("home_default","");
    }
}
