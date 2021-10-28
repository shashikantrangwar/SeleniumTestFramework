package coreSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.devtools.*;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
public class seleniumBase {

    public static FirefoxDriver webDriverInstance;

    public static void initialize()
    {
        System.setProperty("webdriver.gecko.driver","C:\\Public\\ChromeDriver\\geckodriver.exe");
        webDriverInstance = new FirefoxDriver();
        webDriverInstance.get("https://www.google.com");
    }

}
