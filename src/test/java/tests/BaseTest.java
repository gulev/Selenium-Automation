package tests;

import org.apache.commons.exec.OS;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import dataProviders.ConfigFileReader;
import managers.*;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
    private static WebDriver driver = DriverManager.getDriver();

    static ExtentTest test;
    static ExtentReports report;

    @Rule
    public TestRule junitWatcher = new TestWatcher() {

        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println( "Class is: " + description.getClassName());
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getDisplayName() + " " + "Test Passed!");
            test.log(LogStatus.PASS, "PASS: " + description.getDisplayName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName());
            test.log(LogStatus.FAIL, "FAIL: " + description.getDisplayName() + "Reason: "+ e.toString());
        }
    };

    @BeforeClass
    public static void createReport() {
        if (OS.isFamilyWindows()){
            report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        } else if (OS.isFamilyUnix()){
            report = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html");
        }
        test = report.startTest("UserLoginTest");
    }

    @Before
    public void launchApplication(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
    }

    @AfterClass
    public  static void closeBrowser() {
        driver.close();
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
