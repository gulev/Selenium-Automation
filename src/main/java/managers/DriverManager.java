package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;
    private static final DriverType driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();

    public static WebDriver getDriver() {
        if(driver == null) driver = createWebDriver();
        return driver;
    }

    public static WebDriver createWebDriver() {
        WebDriver driver;
        switch (driverType) {
            case CHROME:  WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX: WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw  new IllegalStateException("Error: " + driverType);
        }
        return driver;
    }
}