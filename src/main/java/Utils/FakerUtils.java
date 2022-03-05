package Utils;

import com.github.javafaker.Faker;

public final class FakerUtils{

    static Faker faker = new Faker();
    public static String emailAddress;
    public static String firstName;
    public static String lastName;
    public static String password;
    public static String day;
    public static String month;
    public static Number year;
    public static String companyName;
    public static String address1;
    public static String address2;
    public static String city;
    public static String state;
    public static String additionalInformation;
    public static String homePhoneNumber;
    public static String mobilePhoneNumber;
    public static String addressAlias;

    private FakerUtils(){
        throw  new UnsupportedOperationException("This is a utility class");
    }

    static{
        firstName = faker.name().firstName();
        emailAddress = faker.internet().emailAddress();
        lastName = faker.name().lastName();
        password = faker.internet().password();
        companyName = faker.company().name();
        address1 = faker.address().streetAddress();
        address2 = faker.address().streetAddressNumber();
        city = faker.address().cityName();
        state  = faker.address().state();
        additionalInformation = faker.chuckNorris().fact();
        homePhoneNumber = faker.phoneNumber().cellPhone();
        mobilePhoneNumber = faker.phoneNumber().cellPhone();
        addressAlias = faker.address().streetAddress();
        year = faker.number().numberBetween(1900,2010);
    }
}
