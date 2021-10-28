package appTests;
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
        gPage.initWebDriver(webDriverInstance);
        gPage.enterSearchText("India");
        gPage.clickSearch();

    }
    @AfterClass
    void closeDriver()
    {
        webDriverInstance.quit();
    }



}
