package com.practice.webpages;

import managers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPage {
    static final Logger logger = Logger.getLogger(SearchResultPage.class);
    protected WebDriver driver;

    @FindBy(className = "alert-warning")
    protected WebElement emptyCartMessage;

    @FindBy(id = "cart_title")
    protected WebElement cartTitle;

    @FindBy(css = "#layer_cart h2")
    protected WebElement productAddedToShoppingCart;

    @FindBy(id = "layer_cart_product_price")
    protected WebElement itemPrice;

    @FindBy(id = "layer_cart_product_title")
    protected WebElement itemName;

    @FindBy(id = "layer_cart_product_quantity")
    protected WebElement itemQuantity;

    @FindBy(className = "ajax_block_cart_total")
    protected WebElement itemsTotalPrice;

    @FindBy(css = ".product-image-container.layer_cart_img img")
    protected WebElement itemImage;

    @FindBy(className = "cross")
    protected WebElement closeIconForCartModalDialog;

    @FindBy(css = "#product_1_1_0_0 .cart_delete .cart_quantity_delete")
    protected WebElement deleteButtonForFirstItem;

    @FindBy(css = "#order_step .step_current.first")
    protected WebElement activeSummeryStep;

    @FindBy(css = "#product_1_1_0_0 .cart_product a img")
    protected WebElement imageForFirstItemInSummery;

    @FindBy(css = "#product_1_1_0_0 .cart_description")
    protected WebElement descriptionForFirstItemInSummery;

    @FindBy(css = ".cart_avail .label.label-success")
    protected WebElement isInStockForFirstItemInSummery;

    @FindBy(css = "#product_price_1_1_0 span")
    protected WebElement unitPriceForFirstItemInSummery;

    @FindBy(css = ".cart_quantity .cart_quantity_input")
    protected WebElement quantityForFirstItemInSummery;

    @FindBy(css = "#total_product_price_1_1_0")
    protected WebElement totalPriceForFirstItemInSummery;

    @FindBy(css = ".cart_total_price #total_product")
    protected WebElement totalProductsItemsInSummery;

    @FindBy(css = ".cart_total_delivery #total_shipping")
    protected WebElement totalShippingValueInSummery;

    @FindBy(css = ".cart_total_price #total_price_without_tax")
    protected WebElement totalInSummery;

    @FindBy(css = ".cart_total_tax #total_tax")
    protected WebElement taxInSummery;

    @FindBy(css = "#total_price_container #total_price")
    protected WebElement finalTotalInSummery;

    @FindBy(css = ".cart_navigation .button-exclusive")
    protected WebElement continueShoppingLInk;

    @FindBy(css = ".standard-checkout")
    protected WebElement proceedToCheckoutLInk;

    @FindBy(css = "#cart_title .heading-counter")
    protected WebElement headingCounter;

    public CartPage(){
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected String EmptyShoppingCartMessage = "Your shopping cart is empty.";
    protected String ShoppingCartSummeryMessage = "SHOPPING-CART SUMMARY";
    protected String SuccessfullyAddedProductToCartMessage = "Product successfully added to your shopping cart";
    protected String GreenCSSProperty = "linear-gradient(rgb(66, 184, 86) 0%, rgb(67, 171, 84) 100%)";
    protected String InStockMessage = "In stock";

    public boolean isCartEmpty() {
        logger.info("is car empty...");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeContains(emptyCartMessage, "display","block"));
        logger.info("is popular section displayed.." + emptyCartMessage.getCssValue("display"));
        if(emptyCartMessage.getText().contentEquals(EmptyShoppingCartMessage) == true)
            return true;
        else
            return false;
    }

    public boolean isShoppingCartPage() {
        logger.info("checking shopping cart page." + cartTitle.getText());
        return cartTitle.getText().contains(ShoppingCartSummeryMessage);
    }

    public boolean isProductSuccesfullyAddedToCart() {
        logger.info("isProduct SuccesfullyAddedTo Cart"+ productAddedToShoppingCart.getAttribute("innerHTML"));
        return productAddedToShoppingCart.getAttribute("innerHTML").contains(SuccessfullyAddedProductToCartMessage);
    }

    public String getItemPrice() {
        logger.info("item price." + itemPrice.getText().trim());
        return itemPrice.getText().trim();
    }

    public String getItemQuantity() {
        logger.info("item quantity" + itemQuantity.getText().trim());
        return itemQuantity.getText().trim();
    }

    public String getTotalPrice() {
        String price = itemsTotalPrice.getAttribute("innerHTML").replace("$", "");
        Double intPrice = Double.parseDouble(price);
        intPrice = intPrice + 2;
        price = intPrice.toString();
        logger.info("total price++++++++++++++++++" + price);
        return price;
    }

    public String getItemImage() {
        logger.info("item image" + itemImage.getAttribute("src").trim());
        return itemImage.getAttribute("src").trim();
    }

    public String getItemName() {
        logger.info("item image" + itemName.getText().trim());
        return itemName.getText().trim();
    }

    public void closeCartModalDialog() {
        logger.info("clicking close modal dialog...");
        closeIconForCartModalDialog.click();
    }

    public void deleteFirstElementFromTheSummeryList() {
        logger.info("deleteFirstElementFromTheSummeryList ...");
        deleteButtonForFirstItem.click();
    }

    public boolean isSummeryStepActive() {
        logger.info("background is " + activeSummeryStep.getCssValue("background"));
        String bgColor = activeSummeryStep.getCssValue("background");
        if(bgColor.contains(GreenCSSProperty))
            return true;
        else
            return false;
    }

    public String getProductImageFromCartInSummery() {
        logger.info("imageForFirstItemInSummery image " + imageForFirstItemInSummery.getAttribute("src").trim());
        return imageForFirstItemInSummery.getAttribute("src").trim();
    }

    public String getProductDescriptionFromCartInSummery() {
        logger.info("descriptionForFirstItemInSummery " + descriptionForFirstItemInSummery.getText());
        return  descriptionForFirstItemInSummery.getAttribute("innerHTML");
    }

    public boolean isProductInStockFromCartInSummery() {
        logger.info("isInStockForFirstItemInSummery " + isInStockForFirstItemInSummery.getAttribute("innerHTML"));
         if(isInStockForFirstItemInSummery.getAttribute("innerHTML").equals(InStockMessage)){
             return true;
         }
         else{
             return false;
         }
    }

    public String getUnitPriceFromCartInSummery() {
        logger.info("unitPriceForFirstItemInSummery " + unitPriceForFirstItemInSummery.getText());
        return  unitPriceForFirstItemInSummery.getText();
    }

    public String getQuantityFromCartInSummery() {
        logger.info("quantityForFirstItemInSummery " + quantityForFirstItemInSummery.getAttribute("value"));
        return  quantityForFirstItemInSummery.getAttribute("value");
    }

    public String getTotalPriceForFirstItemFromCartInSummery() {
        logger.info("totalPriceForFirstItemInSummery " + totalPriceForFirstItemInSummery.getText());
        return  totalPriceForFirstItemInSummery.getText();
    }

    public String getTotalProductsItemsFromCartInSummery() {
        logger.info("totalProductsItemsInSummery " + totalProductsItemsInSummery.getText());
        return  totalProductsItemsInSummery.getText();
    }

    public String getTotalShippingValueFromCartInSummery() {
        logger.info("totalShippingValueInSummery " + totalShippingValueInSummery.getText());
        return  totalShippingValueInSummery.getText();
    }

    public String getTotalWithoutTaxesValueFromCartInSummery() {
        logger.info("totalInSummery " + totalInSummery.getText());
        return  totalInSummery.getText();
    }

    public String getTotalTaxValueFromCartInSummery() {
        logger.info("taxInSummery " + taxInSummery.getText());
        return  taxInSummery.getText();
    }

    public String getFinalTotalValueFromCartInSummery() {
        logger.info("finalTotalInSummery " + finalTotalInSummery.getText());
        return  finalTotalInSummery.getText();
    }

    public boolean isContinueShoppingLinkVisible() {
        logger.info("continueShoppingLInk " + continueShoppingLInk.isDisplayed());
        return continueShoppingLInk.isDisplayed();
    }

    public boolean isProceedToCheckoutLinkVisible() {
        logger.info("proceedToCheckoutLInk " + proceedToCheckoutLInk.isDisplayed());
        return proceedToCheckoutLInk.isDisplayed();
    }

    public String calculateTotalPriceByMultiplyingProductTotalByProductQuantity() {
        String price = getTotalPriceForFirstItemFromCartInSummery().replace("$", "");
        Double intPrice = Double.parseDouble(price);
        intPrice = intPrice * Integer.parseInt(getQuantityFromCartInSummery());
        price = "$" + intPrice.toString();
        logger.info("calculate" + price);
        return price;
    }

    public String calculateTotalPriceBeforeTaxByMultiplyingProductTotalByProductQuantityAndAddingShipping() {
        String price = getTotalPriceForFirstItemFromCartInSummery().replace("$", "");
        String shippingCost = getTotalShippingValueFromCartInSummery().replace("$", "");
        Double shippingCostDouble = Double.parseDouble(shippingCost);
        Double intPrice = Double.parseDouble(price);
        intPrice = ((intPrice * Integer.parseInt(getQuantityFromCartInSummery())) + shippingCostDouble);
        price = "$" + intPrice.toString();
        logger.info("calculate" + price);
        return price;
    }

    public String getHeadingCounter() {
        logger.info("base item price." + headingCounter.getText());
        return headingCounter.getText();
    }

    public boolean isDeleteButtonEnabled(){
        if(deleteButtonForFirstItem.isDisplayed() && deleteButtonForFirstItem.isEnabled()){
            return true;
        }else{
            return false;
        }
    }
}
