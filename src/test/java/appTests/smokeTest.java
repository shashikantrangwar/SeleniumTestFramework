package appTests;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import coreSelenium.seleniumBase;
import pageObjects.googlePage;

public class smokeTest extends seleniumBase {

    @Test
    public void searchStringsTest()
    {
        seleniumBase.initialize();
        googlePage gPage = new googlePage();
        FirefoxDriver fDriver = (FirefoxDriver) webDriverInstance1;
        gPage.initWebDriver(fDriver);
        gPage.enterSearchText("India");
        gPage.clickSearch();

    }

    @Test
    public void searchStringsTest1()
    {
        seleniumBase.initialize();
        googlePage gPage = new googlePage();
        FirefoxDriver fDriver = (FirefoxDriver) webDriverInstance1;
        gPage.initWebDriver(fDriver);
        gPage.enterSearchText("India");
        gPage.clickSearch();
        Assert.assertFalse(true);
    }
    @AfterTest
    void closeDriver()
    {
        webDriverInstance1.close();

    }



}
