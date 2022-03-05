package tests;

import com.practice.webpages.*;
import org.junit.Test;
import com.practice.webpages.MyAccountPage;
import org.junit.jupiter.api.Assertions;

public class UserLogInTest extends BaseTest{

    protected final static String NON_EXISTING_EMAIL_ADDRESS = "non-existing-email@gmail.com";
    protected final static String EXISTING_EMAIL_ADDRESS = "svetlin.gulev@primeholding.com";
    protected final static String RIGHT_PASSWORD = "chupakabra";
    protected final static String WRONG_PASSWORD = "wrong-PASSWORD";

    @Test
    public void loginWithRightCredentials(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(RIGHT_PASSWORD);
        authenticationPage.clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.isMyAccountPage();
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void loginWithWrongPassword(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(WRONG_PASSWORD);
        authenticationPage.clickSignInButton();
        authenticationPage.isInvalidPasswordMessageDisplayed();
    }

    @Test
    public void loginWithWrongEmailAddress(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.fillEmailAddressInLoginSection(NON_EXISTING_EMAIL_ADDRESS);
        authenticationPage.fillPasswordInLoginSection(WRONG_PASSWORD);
        authenticationPage.clickSignInButton();
        authenticationPage.isInvalidPasswordMessageDisplayed();
    }
}
