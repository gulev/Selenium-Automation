package Utils;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class BrowserTabsUtils {

    public static void moveToTheNextTab(WebDriver driver){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.switchTo().window(tabs2.get(1));
    }

    public static void killTab(WebDriver driver){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }
}
