package coreSelenium;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.reporter.ExtentReporter.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Locale;


public class seleniumBase{

    public static FirefoxDriver webDriverInstance;
    public static FirefoxDriver webDriverInstance1;
    public ExtentReports extent;
    public ExtentSparkReporter spark;

    public static void initialize()
    {
        WebDriverEventListener listener = new TestListenerWebdriver();
        System.setProperty("webdriver.gecko.driver","C:\\Public\\ChromeDriver\\geckodriver.exe");
        webDriverInstance = new FirefoxDriver();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(webDriverInstance);
        eventDriver.register(listener);
        eventDriver.get("https://www.google.com");
    }
    @BeforeTest(alwaysRun = true)
    public void startReporting(ITestContext i)
    {

        ExtentTestManager.startTest(i.getClass().getName(),i.getSuite().toString());
    }
    @AfterMethod(alwaysRun = true)
    public synchronized void afterexest(ITestResult testResult) {


        switch (testResult.getStatus()) {
            case ITestResult.FAILURE:
                    ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel("In test failure method", ExtentColor.BLUE));
                    ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(testResult.getThrowable().toString(), ExtentColor.BLUE));
                   break;
            case ITestResult.SUCCESS:
                    ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel("Test: " + testResult.getMethod().getMethodName() + " - PASS", ExtentColor.GREEN));
                    break;
            case ITestResult.SKIP:
                    ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel("Test SKIPPED: " + testResult.getMethod().getMethodName(), ExtentColor.RED));
                break;
            default:
                    ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel("Test ERROR: " + testResult.getMethod().getMethodName(), ExtentColor.RED));
                    break;
        }
        ExtentTestManager.endTest();
           }

    @AfterClass
    public void tearDown() {
        webDriverInstance.quit();
    }

}
