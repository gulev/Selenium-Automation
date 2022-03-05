package tests;

import com.practice.webpages.BasePage;
import com.practice.webpages.ForgottenPasswordPage;
import com.practice.webpages.AuthenticationPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserForgottenPassword extends BaseTest{

    protected final static String NON_EXISTING_EMAIL_ADDRESS = "non-existing-email@gmail.com";
    protected final static String EXISTING_EMAIL_ADDRESS = "svetlin.gulev@primeholding.com";

    @Test
    public void forUnregisteredUser(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.clickForgotYourPasswordLink();
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage();
        Assertions.assertTrue(forgottenPasswordPage.isForgottenPasswordPage());
        forgottenPasswordPage.enterTextInEmailTextBox(NON_EXISTING_EMAIL_ADDRESS);
        forgottenPasswordPage.clickRetrievePasswordButton();
        Assertions.assertTrue(forgottenPasswordPage.verifyErrorMessageForUnregisteredUser());
    }

    @Test
    public void forRegisteredUser(){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        Assertions.assertTrue(authenticationPage.isAuthenticationPage());
        authenticationPage.clickForgotYourPasswordLink();
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage();
        Assertions.assertTrue(forgottenPasswordPage.isForgottenPasswordPage());
        forgottenPasswordPage.enterTextInEmailTextBox(EXISTING_EMAIL_ADDRESS);
        forgottenPasswordPage.clickRetrievePasswordButton();
        Assertions.assertTrue(forgottenPasswordPage.verifySuccessMessageForRegisteredUser(EXISTING_EMAIL_ADDRESS));
    }
}
