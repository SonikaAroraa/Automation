package FidelisAutomation.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory
{
    static WebDriver driver;

    public static WebDriver startBrowser(String browserName)
    {
        configReader read = new configReader();
        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Fidelis\\FidelisAutomation\\chromedriver.exe");
            driver = new ChromeDriver();

        }

        else if(browserName.equalsIgnoreCase("Firefox"))
        {
            System.out.print("here");
            System.setProperty("webdriver.gecko.driver", "D:\\Fidelis\\FidelisAutomation\\geckodriver.exe");
            System.out.print("here1");

            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
            driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        System.out.print(read.getUrl());
        driver.get(read.getUrl());
        return driver;

    }
}
