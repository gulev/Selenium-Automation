package tests;

import com.practice.webpages.BasePage;
import com.practice.webpages.CartPage;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageAddingAndRemovingFromCartWithUnregisteredUser extends BaseTest {

    @Test
    public void visitCartAndReturnEmptyCart(){
        BasePage basePage = new BasePage();
        basePage.clickCartLink();
        CartPage cartPage = new CartPage();
        Assertions.assertTrue(cartPage.isCartEmpty());
        Assertions.assertTrue(cartPage.isShoppingCartPage());
    }

    @Test
    public void returnEmptyCart(){
        BasePage basePage = new BasePage();
        Assertions.assertTrue(basePage.isCartPlaceholderEmpty());
    }

    @Test
    public void moveToPopularSectionAndAddFirstItemToCartTHneCheckForItInTheCart(){
        String expectedCartTotalPrice = "20.51";
        BasePage basePage = new BasePage();
        basePage.moveToPopularSection();
        Assertions.assertTrue(basePage.isPopularSectionDisplayed());
        basePage.hoverOnFirstElementAndClickOnAddCardButton();

        String baseImage = basePage.getItemImage();
        String baseItemPrice = basePage.getItemPrice();
        String baseItemName = basePage.getItemName();

        CartPage cartPage = new CartPage();
        Assertions.assertTrue(cartPage.isProductSuccesfullyAddedToCart());
        String cartItemImage = cartPage.getItemImage();
        String cartItemPrice = cartPage.getItemPrice();
        String cartItemName = cartPage.getItemName();

        String cartItemQuantity = cartPage.getItemQuantity();
        String cartTotalPrice = cartPage.getTotalPrice();
        Assertions.assertEquals(baseImage, cartItemImage);
        Assertions.assertEquals(baseItemPrice, cartItemPrice);
        Assertions.assertEquals(baseItemName, cartItemName);
        Assertions.assertEquals(cartItemQuantity, "1");
        Assertions.assertEquals(cartTotalPrice, expectedCartTotalPrice);
    }

    @Test
    public void addItemToCartCheckTheCartThenRemoveItFromTheCartAndCheckForEmptyCart(){
        BasePage basePage = new BasePage();
        basePage.moveToPopularSection();
        Assert.assertTrue(basePage.isPopularSectionDisplayed());
        basePage.hoverOnFirstElementAndClickOnAddCardButton();

        String baseImage = basePage.getItemImage();
        String baseItemPrice = basePage.getItemPrice();
        String baseItemName = basePage.getItemName();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isProductSuccesfullyAddedToCart());
        cartPage.closeCartModalDialog();
        basePage.hoverOnCart();

        String ImageInTheQuickCart = basePage.getItemImageFromQuickCart();
        String NameInTheQuickCart = basePage.getItemNameFromQuickCart();
        String PriceInTheQuickCart = basePage.getItemPriceFromQuickCart();

        Assertions.assertEquals(baseImage, ImageInTheQuickCart);
        Assertions.assertEquals(baseItemPrice, PriceInTheQuickCart);
        Assertions.assertEquals(baseItemName, NameInTheQuickCart);

        basePage.removeItemFromQuickCart();
        Assertions.assertTrue(basePage.isCartEmpty());
        basePage.moveToPopularSection();
        basePage.hoverOnCart();
        Assertions.assertFalse(basePage.isCartDropdownDisplayed());
        Assertions.assertTrue(basePage.isCartPlaceholderEmpty());

    }

    @Test
    public void addItemToCartGoToSummeryPage(){
        BasePage basePage = new BasePage();
        basePage.moveToPopularSection();
        Assert.assertTrue(basePage.isPopularSectionDisplayed());
        basePage.hoverOnFirstElementAndClickOnAddCardButton();

        String baseImage = basePage.getItemImage();
        String baseItemPrice = basePage.getItemPrice();
        String baseItemName = basePage.getItemName();

        CartPage cartPage = new CartPage();
        Assertions.assertTrue(cartPage.isProductSuccesfullyAddedToCart());
        cartPage.closeCartModalDialog();
        basePage.hoverOnCart();

        String ImageInTheQuickCart = basePage.getItemImageFromQuickCart();
        String NameInTheQuickCart = basePage.getItemNameFromQuickCart();
        String PriceInTheQuickCart = basePage.getItemPriceFromQuickCart();

        Assertions.assertEquals(baseImage, ImageInTheQuickCart);
        Assertions.assertEquals(baseItemPrice, PriceInTheQuickCart);
        Assertions.assertEquals(baseItemName, NameInTheQuickCart);

        basePage.clickCartCheckoutLink();
        Assertions.assertTrue(cartPage.isShoppingCartPage());
        cartPage.deleteFirstElementFromTheSummeryList();
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void addItemToCartGoToSummeryPageAndCheckFotItem(){
        String totalShipping = "$2.00";
        String tax = "$0.00";
        String headingCounterText = "Your shopping cart contains: 1 Product";
        String quantity = "1";
        String smallImage = "-small";
        String homeImage = "-home";

        BasePage basePage = new BasePage();
        basePage.moveToPopularSection();
        Assertions.assertTrue(basePage.isPopularSectionDisplayed());
        basePage.hoverOnFirstElementAndClickOnAddCardButton();

        String baseImage = basePage.getItemImage();
        String baseItemPrice = basePage.getItemPrice();

        CartPage cartPage = new CartPage();
        Assertions.assertTrue(cartPage.isProductSuccesfullyAddedToCart());
        cartPage.closeCartModalDialog();
        basePage.hoverOnCart();
        basePage.clickCartCheckoutLink();
        Assertions.assertTrue(cartPage.isShoppingCartPage());
        Assertions.assertTrue(cartPage.isSummeryStepActive());
        Assertions.assertTrue(cartPage.isContinueShoppingLinkVisible());
        Assertions.assertTrue(cartPage.isProceedToCheckoutLinkVisible());

        String ImageInTheCart = cartPage.getProductImageFromCartInSummery();
        Assertions.assertEquals(baseImage.replace(homeImage,""),
                ImageInTheCart.replace(smallImage,""));

        Assertions.assertTrue(cartPage.isProductInStockFromCartInSummery());

        String PriceInTheCart = cartPage.getUnitPriceFromCartInSummery();
        Assertions.assertEquals(baseItemPrice, PriceInTheCart);
        Assertions.assertEquals(cartPage.getQuantityFromCartInSummery(), quantity);
        Assertions.assertEquals( cartPage.getTotalPriceForFirstItemFromCartInSummery(),
                cartPage.calculateTotalPriceByMultiplyingProductTotalByProductQuantity()
        );
        Assertions.assertEquals( cartPage.getTotalProductsItemsFromCartInSummery(),
                cartPage.calculateTotalPriceByMultiplyingProductTotalByProductQuantity()
        );
        Assertions.assertEquals(cartPage.getTotalShippingValueFromCartInSummery(),totalShipping);
        Assertions.assertEquals(cartPage.getTotalWithoutTaxesValueFromCartInSummery(),
                cartPage.calculateTotalPriceBeforeTaxByMultiplyingProductTotalByProductQuantityAndAddingShipping()
        );
        Assertions.assertEquals(cartPage.getTotalTaxValueFromCartInSummery(),tax);
        Assertions.assertEquals(cartPage.getTotalWithoutTaxesValueFromCartInSummery(),
                cartPage.getFinalTotalValueFromCartInSummery()
        );
        Assertions.assertEquals(cartPage.getHeadingCounter(), headingCounterText);
        Assertions.assertTrue(cartPage.isDeleteButtonEnabled());
    }

}
