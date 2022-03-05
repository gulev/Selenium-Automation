package tests;

import com.practice.webpages.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WishListTest extends BaseTest{

    protected final static String EXISTING_EMAIL_ADDRESS = "svetlin.gulev@primeholding.com";
    protected final static String RIGHT_PASSWORD = "chupakabra";
    protected final static String WISHLIST_NAME = "gulev";
    protected final static String DEFAULT_WISHLIST_NAME = "My wishlist";

    @Test
    public void visitWishlistPageAndCheckIfExists(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertTrue(myAccountPage.isMyAccountPage());
        myAccountPage.clickOnmyWishlistsCategory();
        WishlistPage wishlistPage = new WishlistPage();
        Assertions.assertTrue(wishlistPage.isWishlistPage());
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void createWishlistAndCheckIfExists(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.isMyAccountPage();
        myAccountPage.clickOnmyWishlistsCategory();
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.isWishlistPage();
        wishlistPage.enterTextInNameTextBox(WISHLIST_NAME);
        wishlistPage.clickSaveButton();
        Assertions.assertEquals(wishlistPage.getFirstElementInWishlistTable(),WISHLIST_NAME);
        wishlistPage.clickDeleteWishlist();
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void deleteWishlistAndCheckIfExists(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.isMyAccountPage();
        myAccountPage.clickOnmyWishlistsCategory();
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.isWishlistPage();
        wishlistPage.enterTextInNameTextBox(WISHLIST_NAME);
        wishlistPage.clickSaveButton();
        Assertions.assertEquals(wishlistPage.getFirstElementInWishlistTable(),WISHLIST_NAME);
        wishlistPage.clickDeleteWishlist();
        Assertions.assertTrue(wishlistPage.isEmptyWhishlistTable());
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void createWishlistAndCheckForEmptyItems(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.isMyAccountPage();
        myAccountPage.clickOnmyWishlistsCategory();
        WishlistPage wishlistPage = new WishlistPage();
        wishlistPage.isWishlistPage();
        wishlistPage.enterTextInNameTextBox(WISHLIST_NAME);
        wishlistPage.clickSaveButton();
        Assertions.assertEquals(wishlistPage.getFirstElementInWishlistTable(),WISHLIST_NAME);
        wishlistPage.clickWhishlistName();
        Assertions.assertTrue(wishlistPage.isNoProductsDisplayed());
        wishlistPage.clickDeleteWishlist();
        Assertions.assertTrue(wishlistPage.isEmptyWhishlistTable());
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void addItemToWishlistAndCheckForItDeleteItemFromWishListAndCheckIfExists(){
        String productName = "";
        String productImage = "";
        String wishlistProductName = "";
        String wishlistProductImage = "";

        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertTrue(myAccountPage.isMyAccountPage());
        myAccountPage.clickOnmyWishlistsCategory();
        WishlistPage wishlistPage = new WishlistPage();
        Assertions.assertTrue(wishlistPage.isWishlistPage());
        wishlistPage.clickOnHeaderLogo();
        basePage.clickViewButtonOnFirstProductFromTheProductList();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assertions.assertTrue(productDetailsPage.isAddToCardButtonExist());
        productName = productDetailsPage.getProductName();
        productImage = productDetailsPage.getProductImage();
        productDetailsPage.clickAddToWishlistButton();
        Assertions.assertTrue(productDetailsPage.isCorrectWishlistMessage());
        productDetailsPage.clickOnCloseWishlistModal();
        productDetailsPage.clickOnHeaderLogo();
        basePage.clickUserProfileLink();
        Assertions.assertTrue(myAccountPage.isMyAccountPage());
        myAccountPage.clickOnmyWishlistsCategory();
        Assertions.assertTrue(wishlistPage.isWishlistPage());
        Assertions.assertEquals(wishlistPage.getFirstElementInWishlistTable(),DEFAULT_WISHLIST_NAME);
        wishlistPage.clickWhishlistName();
        wishlistProductName = wishlistPage.getFirstElementProductNameInWishlistExpandedItems();
        wishlistProductImage = wishlistPage.getWhishlistItemImage();
        Assertions.assertEquals(productName, wishlistProductName);
        Assertions.assertEquals(productImage, wishlistProductImage);
        wishlistPage.clickDeleteButtonForFirstItemInWishlistExpandedItem();
        wishlistPage.clickDeleteWishlist();
        Assertions.assertTrue(wishlistPage.isEmptyWhishlistTable());
        myAccountPage.clickOnSignOutLink();

    }
}