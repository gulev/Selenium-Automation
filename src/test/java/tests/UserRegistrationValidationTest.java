package tests;

import com.practice.webpages.AuthenticationPage;
import com.practice.webpages.BasePage;
import com.practice.webpages.CreateAnAccountPage;
import enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class UserRegistrationValidationTest extends BaseTest{

    protected final static String DAY = "12";
    protected final static String MONTH = "4";
    protected final static String YEAR = "2010";
    protected final static String POST_CODE = "00000";
    protected final static String COUNTRY = "United States";
    protected final static String VALID_EMAIL_ADDRESS = "testGulev5555@gmail.com";
    protected final static String INVALID_EMAIL_ADDRESS = "no-valid";
    protected final static String FIRST_NAME = "Svetlin";
    protected final static String INVALID_FIRST_NAME = "11";
    protected final static String INVALID_LAST_NAME = "11";
    protected final static String LAST_NAME = "Gulev";
    protected final static String PASSWORD = "123456";
    protected final static String COMPANY_NAME = "Prime";
    protected final static String ADDRESS_1 = "Holloway";
    protected final static String ADDRESS_2 = "Two holloway";
    protected final static String CITY = "New York";
    protected final static String STATE = "New York";
    protected final static String ADDITIONAL_INFORMATION = "not that i know of";
    protected final static String HOME_PHONE_NUMBER = "123456789";
    protected final static String MOBILE_PHONE_NUMBER = "0987654321";
    protected final static String ADDRESS_ALIAS = "chonky";
    protected final static Gender GENDER = Gender.MALE;
    protected final static String INVALID_PASSWORD = "12";
    protected final static String FIRSTNAME_IS_REQUIRED = "firstname is required.";
    protected final static String IVALID_FIRSTNAME_MESSAGE = "firstname is invalid.";
    protected final static String IVALID_LASTNAME_MESSAGE = "lastname is invalid.";
    protected final static String LASTNAME_IS_REQUIRED_MESSAGE = "lastname is required.";
    protected final static String PASSWORD_IS_REQUIRED_MESSAGE = "passwd is required.";
    protected final static String ALIAS_IS_REQUIRED = "alias is required.";
    protected final static String PHONE_IS_REQUIRED = "You must register at least one phone number.";
    protected final static String CITY_IS_REQUIRED = "city is required.";
    protected final static String WRONG_ZIP_CODE = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    protected final static String ADDRESS1_IS_REQUIRED = "address1 is required.";
    protected final static String CHOOSE_STATE = "This country requires you to choose a State.";
    protected final static String INVALID_PASSWORD_MESSAGE = "passwd is invalid.";
    protected final static String EMAIL_IS_REQUIRED = "email is required.";
    protected final static String INVALID_EMAIL = "email is invalid.";


    private static Stream<Arguments> userData() {
        return Stream.of(
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, "", ALIAS_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, "", LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS,FIRSTNAME_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, "", VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, LASTNAME_IS_REQUIRED_MESSAGE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, "", GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, PASSWORD_IS_REQUIRED_MESSAGE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, "",
                        "", ADDRESS_ALIAS,PHONE_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, "", STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS,CITY_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, "",
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, WRONG_ZIP_CODE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, "", ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, ADDRESS1_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, "-", ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, CHOOSE_STATE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, INVALID_PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS,INVALID_PASSWORD_MESSAGE),
                Arguments.of(VALID_EMAIL_ADDRESS, INVALID_FIRST_NAME, LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, IVALID_FIRSTNAME_MESSAGE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, INVALID_LAST_NAME, VALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS, IVALID_LASTNAME_MESSAGE),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, "", PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS,EMAIL_IS_REQUIRED),
                Arguments.of(VALID_EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, INVALID_EMAIL_ADDRESS, PASSWORD, GENDER, DAY, MONTH, YEAR, POST_CODE,
                        COUNTRY, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ADDITIONAL_INFORMATION, HOME_PHONE_NUMBER,
                        MOBILE_PHONE_NUMBER, ADDRESS_ALIAS,INVALID_EMAIL)
        );
    }

    @ParameterizedTest
    @MethodSource("userData")
    public void validateForm(String validEmailAddress, String firstName, String lastName, String formEmailAddress,
                             String password, Gender gender, String DAY,String MONTH,String YEAR, String POST_CODE,
                             String COUNTRY, String companyName, String address1,
                             String address2, String city, String state, String additionalInformation,
                             String homePhoneNumber, String mobilePhoneNumber, String addressAlias,
                             String validationMessage){
        BasePage basePage = new BasePage();
        basePage.clicksSignInButton();
        AuthenticationPage authPage = new AuthenticationPage();
        Assertions.assertTrue(authPage.isAuthenticationPage());

        authPage.fillEmailAddressInCreateAnAccountSection(validEmailAddress);
        authPage.clickCreateAnAccountbutton();
        Assertions.assertTrue(authPage.isValidEmailAddress());

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.isPageCreateAnAccount();
        Assertions.assertTrue(createAnAccountPage.isPageCreateAnAccount());

        createAnAccountPage.chooseGender(gender);
        createAnAccountPage.enterTextInFirstNameTextBoxInYourPersonalInformationSection(firstName);
        createAnAccountPage.enterTextInLastNameTextBoxInYourPersonalInformationSection(lastName);
        createAnAccountPage.enterTextInEmailAddressTextBoxInYourPersonalInformationSection(formEmailAddress);
        createAnAccountPage.enterTextInPasswordTextBoxInYourPersonalInformationSection(password);
        createAnAccountPage.selectDaysValueInDateOfBirthInYourPersonalInformationSection(DAY);
        createAnAccountPage.selectMonthsValueInDateOfBirthInYourPersonalInformationSection(MONTH);
        createAnAccountPage.selectYearsValueInDateOfBirthInYourPersonalInformationSection(YEAR);
        createAnAccountPage.checkSignUpForNewsLetterCheckbox();
        createAnAccountPage.checkReceiveSpecialOffersCheckbox();

        createAnAccountPage.enterTextInFirstNameTextBoxInYourAddressSection(firstName);
        createAnAccountPage.enterTextInLastNameTextBoxInYourAddressSection(lastName);
        createAnAccountPage.enterTextInCompanyTextBoxInYourAddressSection(companyName);
        createAnAccountPage.enterTextInAddressTextBoxInYourAddressSection(address1);
        createAnAccountPage.enterTextInAddressLineTwoTextBoxInYourAddressSection(address2);
        createAnAccountPage.enterTextInCityTextBoxInYourAddressSection(city);
        createAnAccountPage.enterTextInStateDropDownInYourAddressSection(state);
        createAnAccountPage.enterTextInZipCodeTextBoxInYourAddressSection(POST_CODE);
        createAnAccountPage.enterTextInCountryDropDownInYourAddressSection(COUNTRY);
        createAnAccountPage.enterTextInAdditionalInformationTextBoxInYourAddressSection(additionalInformation);
        createAnAccountPage.enterTextInHomePhoneTextBoxInYourAddressSection(homePhoneNumber);
        createAnAccountPage.enterTextInMobilePhoneTextBoxInYourAddressSection(mobilePhoneNumber);
        createAnAccountPage.enterTextInAddressAliasTextBoxInYourAddressSection(addressAlias);
        createAnAccountPage.clickRegisterButton();
        Assertions.assertTrue(createAnAccountPage.isValidationDisplayed());
        Assertions.assertTrue(createAnAccountPage.isValidationMessageExist(validationMessage));
    }
}