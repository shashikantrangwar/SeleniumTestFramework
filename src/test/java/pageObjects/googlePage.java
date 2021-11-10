package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class googlePage  {

    public FirefoxDriver currentInstance=null;
    public void initWebDriver(FirefoxDriver webD)
    {
        currentInstance = webD;
    }
    public void navigateToMain()
    {
        currentInstance.get("www.google.com");
    }
    public void enterSearchText(String srchText)
    {
        WebElement searchBox = currentInstance.findElement(By.xpath("//input"));
        searchBox.sendKeys(srchText);

    }

    public void clickSearch()
    {
        WebElement wb = currentInstance.findElement(By.xpath("//input[@type='submit'][@value='Google Search']"));
        wb.submit();
    }

}
