package tests;

import com.practice.webpages.BasePage;
import com.practice.webpages.AuthenticationPage;
import com.practice.webpages.CreateAnAccountPage;
import com.practice.webpages.MyAccountPage;
import com.practice.webpages.MyAddressesPage;
import com.practice.webpages.PersonalInformationPage;
import org.junit.Before;
import org.junit.Test;
import com.github.javafaker.Faker;
import enums.MonthsInWords;
import enums.Gender;
import org.junit.jupiter.api.Assertions;

public class UserRegistrationTest extends BaseTest {

    protected final static String DAY = "12";
    protected final static String MONTH = "4";
    protected final static String YEAR = "2010";
    protected final static String POST_CODE = "00000";
    protected final static String COUNTRY = "United States";
    protected static String validEmailAddress;
    protected static String firstName;
    protected static String lastName;
    protected static String password;
    protected static String companyName;
    protected static String address1;
    protected static String address2;
    protected static String city;
    protected static String state;
    protected static String additionalInformation;
    protected static String homePhoneNumber;
    protected static String mobilePhoneNumber;
    protected static String addressAlias;
    protected static String fullName;
    protected static MonthsInWords monthsInWords = MonthsInWords.APRIL;
    protected static Gender gender = Gender.MALE;

    @Before
    public void setup() {
        Faker faker = new Faker();
        validEmailAddress = faker.internet().emailAddress();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = faker.internet().password();
        companyName = faker.company().name();
        address1 = faker.address().streetAddress();
        address2 = faker.address().streetAddressNumber();
        city = faker.address().cityName();
        state = faker.address().state();
        additionalInformation = faker.chuckNorris().fact();
        homePhoneNumber = faker.phoneNumber().cellPhone();
        mobilePhoneNumber = faker.phoneNumber().cellPhone();
        addressAlias = faker.address().streetAddress();
        fullName = firstName + " " + lastName;
    }

    @Test
    public void RegisterNewUser() {
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

        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertEquals(myAccountPage.getUserInfo(), fullName);
        Assertions.assertTrue(myAccountPage.isMyAccountPage());

        Assertions.assertTrue(myAccountPage.isSignOutDisplayed());
        Assertions.assertTrue(myAccountPage.isOrderHistoryAndDetailsCategoryDisplayed());
        Assertions.assertTrue(myAccountPage.isMyAddressesCategoryDisplayed());
        Assertions.assertTrue(myAccountPage.isMyCreditSlipsCategoryDisplayed());
        Assertions.assertTrue(myAccountPage.isMyPersonalInformationCategoryDisplayed());
        Assertions.assertTrue(myAccountPage.isMyWishlistsCategoryDisplayed());
        myAccountPage.clickOnSignOutLink();
    }

    @Test
    public void RegisterNewUserAndCheckForAddressDetails() {
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

        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertEquals(myAccountPage.getUserInfo(), fullName);
        Assertions.assertTrue(myAccountPage.isMyAccountPage());
        Assertions.assertTrue(myAccountPage.isMyAddressesCategoryDisplayed());

        myAccountPage.clickMyAddressesCategory();

        MyAddressesPage myAddressesPage = new MyAddressesPage();
        Assertions.assertTrue(myAddressesPage.isMyAddressesPage());
        Assertions.assertTrue(myAddressesPage.isUpdateButtonPresent());
        Assertions.assertTrue(myAddressesPage.isDeleteButtonPresent());
        Assertions.assertTrue(myAddressesPage.isAddNewAddressButtonPresent());
        Assertions.assertEquals(myAddressesPage.getAliasSubHeadingText(), addressAlias);
        Assertions.assertEquals(myAddressesPage.getAddressNameOneText(), firstName);
        Assertions.assertEquals(myAddressesPage.getAddressNameTwoText(), lastName);
        Assertions.assertEquals(myAddressesPage.getAddressCompanyText(), companyName);
        Assertions.assertEquals(myAddressesPage.getAddressOneText(), address1);
        Assertions.assertEquals(myAddressesPage.getAddressTwoText(), address2);
        Assertions.assertEquals(myAddressesPage.getCityText(), city);
        Assertions.assertEquals(myAddressesPage.getStateText(), state);
        Assertions.assertEquals(myAddressesPage.getZipCodeText(), POST_CODE);
        Assertions.assertEquals(myAddressesPage.getCountryText(), COUNTRY);
        Assertions.assertEquals(myAddressesPage.getPhoneText(), homePhoneNumber);
        Assertions.assertEquals(myAddressesPage.getMobilePhoneText(), mobilePhoneNumber);
        myAddressesPage.clickOnSignOutLink();
    }

    @Test
    public void RegisterNewUserAndCheckForPersonalInformation() {
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

        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertEquals(myAccountPage.getUserInfo(), fullName);
        Assertions.assertTrue(myAccountPage.isMyAccountPage());
        Assertions.assertTrue(myAccountPage.isMyAddressesCategoryDisplayed());
        myAccountPage.clickMyPersonalInformationCategory();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        Assertions.assertTrue(personalInformationPage.isPersonalInformationPage());

        Assertions.assertTrue(personalInformationPage.isSaveButtonDisplayed());

        Assertions.assertEquals(personalInformationPage.getFirstName(), firstName);
        Assertions.assertEquals(personalInformationPage.getLastName(), lastName);
        Assertions.assertEquals(personalInformationPage.getEmailAddress(), validEmailAddress);
        Assertions.assertEquals(personalInformationPage.getDaysFromDateOfBirthDropDown(), DAY);
        Assertions.assertEquals(personalInformationPage.getMonthsFromDateOfBirthDropDown(), monthsInWords);
        Assertions.assertEquals(personalInformationPage.getYearsFromDateOfBirthDropDown(), YEAR);

        Assertions.assertTrue(personalInformationPage.isSignupForNewsLetterChecked());
        Assertions.assertTrue(personalInformationPage.isRecieveSpecialOffersChecked());
        Assertions.assertEquals(personalInformationPage.getGender(), gender);
        personalInformationPage.clickOnSignOutLink();
    }
}