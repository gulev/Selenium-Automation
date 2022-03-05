package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BasePage {
    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "search_query")
    protected WebElement searchTextBox;

    @FindBy(className = "login")
    protected WebElement loginLink;

    @FindBy(name = "submit_search")
    protected WebElement submitSearchButton;

    @FindBy(className = "ac_results")
    protected WebElement autoCompleteResults;

    @FindBy(css = ".ac_even:first-child")
    protected WebElement firstAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(2)")
    protected WebElement secondAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(3)")
    protected WebElement thirdAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(4)")
    protected WebElement fourthAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(5)")
    protected WebElement fifthAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(6)")
    protected WebElement sixthAutoCompleteElement;

    @FindBy(css = ".shopping_cart a")
    protected WebElement cartLink;

    @FindBy(className = "ajax_cart_no_product")
    protected WebElement emptyCartPlaceholder;

    @FindBy(id = "homefeatured")
    protected WebElement popularSection;

    @FindBy(css = "#homefeatured .first-in-line")
    protected WebElement firstProductInHomeFeaturedList;

    @FindBy(css = ".ajax_add_to_cart_button")
    protected WebElement addToCardButton;

    @FindBy(css = ".lnk_view")
    protected WebElement ViewButton;

    @FindBy(css = ".first-in-line .product-container .product-name")
    protected WebElement itemName;

    @FindBy(css = ".first-in-line .product-container .product_img_link img")
    protected WebElement itemImage;

    @FindBy(css = ".first-in-line .product-container .product-price")
    protected WebElement itemPrice;

    @FindBy(css = ".cart_block_list .products .first_item .product-name a")
    protected WebElement itemNameQuickCart;

    @FindBy(css = ".cart_block_list .products .first_item .cart-images img")
    protected WebElement itemImageQuickCart;

    @FindBy(css = ".cart_block_list .products .first_item .price")
    protected WebElement itemPriceQuickCart;

    @FindBy(css = ".remove_link a")
    protected WebElement iconToRemoveItemFromQuickCart;

    @FindBy(css = ".shopping_cart .cart_block_no_products")
    protected WebElement noProductsAvailableInTheCart;

    @FindBy(css = ".shopping_cart .cart_block")
    protected WebElement cartDropdown;

    @FindBy(id = "button_order_cart")
    protected WebElement cartCheckoutLink;

    @FindBy(id = "header_logo")
    protected WebElement headerLogo;

    @FindBy(css = ".header_user_info a")
    protected WebElement userProfileLink;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void searchAndPressEnter(String query) {
        logger.info("searching....");
        searchTextBox.sendKeys(query + Keys.ENTER);
    }

    public void emptySearchField() {
        logger.info("emptying....");
        searchTextBox.clear();
    }

    public void enterTextInSearchField(String query) {
        logger.info("entering text in search field....");
        searchTextBox.sendKeys(query);
    }

    public void clickSearchButton() {
        logger.info("clicking search button....");
        submitSearchButton.click();
    }

    public boolean isUserLogged() {
        String loginText = loginLink.getText();
        logger.info("IS USER LOGGED" + loginText);
        return (loginText.contains("Sign in")) ? false : true;
    }

    public void enterValueInSearchField(String query) {
        logger.info("entering value is the search field....");
        searchTextBox.sendKeys(query);
    }

    public boolean isAutoCompleteDisplayed() {
        logger.info("autocomplete is...");
        return autoCompleteResults.isDisplayed();
    }

    public void clickElementFromAutoComplete(int elementSeqNumber) {
        logger.info("clicking first element..." + firstAutoCompleteElement.getText());
        if (elementSeqNumber == 1) {
            firstAutoCompleteElement.click();
        } else if (elementSeqNumber == 2) {
            secondAutoCompleteElement.click();
        } else if (elementSeqNumber == 3) {
            thirdAutoCompleteElement.click();
        } else if (elementSeqNumber == 4) {
            fourthAutoCompleteElement.click();
        } else if (elementSeqNumber == 5) {
            fifthAutoCompleteElement.click();
        } else if (elementSeqNumber == 6) {
            sixthAutoCompleteElement.click();
        }
    }

    public void clicksSignInButton() {
        logger.info("clicking sign in button....");
        loginLink.click();
    }

    protected final String EmptyCartMsssage = "(empty)";
    protected final String NoProductsMessage = "No products";

    public void clickCartLink() {
        logger.info("clicking cart link...");
        cartLink.click();
    }

    public boolean isCartPlaceholderEmpty() {
        logger.info("is car placeholder empty..." + emptyCartPlaceholder.getAttribute("innerHTML"));
        return emptyCartPlaceholder.getAttribute("innerHTML").contentEquals(EmptyCartMsssage);
    }

    public void moveToPopularSection() {
        logger.info("moving to...");
        Actions actions = new Actions(driver);
        actions.moveToElement(popularSection);
        actions.perform();
    }

    public boolean isPopularSectionDisplayed() {
        logger.info("is popular section displayed..");
        return popularSection.isDisplayed();
    }

    public void hoverOnFirstElementAndClickOnAddCardButton() {
        logger.info("hovering to...");
        Actions builder = new Actions(driver);
        builder.moveToElement(firstProductInHomeFeaturedList).perform();
        addToCardButton.click();
    }

    public String getItemPrice() {
        logger.info("base item price." + itemPrice.getAttribute("innerHTML").trim());
        return itemPrice.getAttribute("innerHTML").trim();
    }

    public String getItemImage() {
        logger.info("base item image" + itemImage.getAttribute("src").trim());
        return itemImage.getAttribute("src").trim();
    }

    public String getItemName() {
        logger.info("base item name" + itemName.getText().trim());
        return itemName.getText().trim();
    }

    public void hoverOnCart() {
        logger.info("hovering to...");
        Actions actions = new Actions(driver);
        actions.moveToElement(cartLink);
        actions.perform();
    }

    public String getItemPriceFromQuickCart() {
        logger.info("base item price. FromQuickCart" + itemPriceQuickCart.getAttribute("innerHTML").trim());
        return itemPrice.getAttribute("innerHTML").trim();
    }

    public String getItemImageFromQuickCart() {
        logger.info("base item image FromQuickCart" + itemImageQuickCart.getAttribute("src").trim());
        return itemImage.getAttribute("src").trim();
    }

    public String getItemNameFromQuickCart() {
        logger.info("base item name FromQuickCart" + itemNameQuickCart.getAttribute("title").trim());
        return itemName.getText().trim();
    }

    public void removeItemFromQuickCart() {
        logger.info("removing item ....");
        iconToRemoveItemFromQuickCart.click();
    }

    public boolean isCartEmpty() {
        logger.info("is cart empty..." + noProductsAvailableInTheCart.getAttribute("innerHTML"));
        return noProductsAvailableInTheCart.getAttribute("innerHTML").contains(NoProductsMessage);
    }

    public boolean isCartDropdownDisplayed() {
        logger.info("is popular section displayed.." + cartDropdown.getCssValue("display"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeContains(cartDropdown, "display", "none"));
        logger.info("is popular section displayed.." + cartDropdown.getCssValue("display"));
        if (cartDropdown.getCssValue("display").equalsIgnoreCase("none") == true)
            return false;
        else
            return true;
    }

    public void clickCartCheckoutLink() {
        logger.info("clicking cart checkout button....");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cartCheckoutLink));
        cartCheckoutLink.click();
    }

    public void clickViewButtonOnFirstProductFromTheProductList() {
        logger.info("clickOnFirstProductFromThePRoductList to...");
        Actions builder = new Actions(driver);
        builder.moveToElement(firstProductInHomeFeaturedList).perform();
        ViewButton.click();
    }

    public void clickOnHeaderLogo() {
        logger.info("clickOnHeaderLogo");
        headerLogo.click();
    }

    public void clickUserProfileLink(){
        userProfileLink.click();
    }

}