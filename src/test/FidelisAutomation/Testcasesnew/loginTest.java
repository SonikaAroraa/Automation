package FidelisAutomation.Testcasesnew;

import FidelisAutomation.Pages.loginPage;
import FidelisAutomation.Utilities.BrowserFactory;
import FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class loginTest {
    configReader read = new configReader();
   //WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    /*
        @Test
        public void loginTestAdmin()
            {
                WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
                loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
                loginPage.login(read.getAdminID(),read.getPassword());
               String CurrentURL = driver.getCurrentUrl();
               if(CurrentURL.contains("home"))
                Assert.assertTrue(true,"Testcase passed");
                driver.quit();
            }
            */
    @Test(priority = 1)
    public void loginTestStudent() throws InterruptedException {
    // System.setProperty("webdriver.gecko.driver", "D:\\Fidelis\\FidelisAutomation\\geckodriver.exe");
        System.out.print("here1");
        WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    // WebDriver driver = new FirefoxDriver();
        loginPage loginPage = (FidelisAutomation.Pages.loginPage) PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.login(read.getStudentID(), read.getPassword());
        Thread.sleep(30000);
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);
        if (CurrentURL.contains("home"))
            Assert.assertTrue(true, "Testcase passed");
        else
            Assert.assertFalse(true, "Testcase passed");
    }
/*
    @Test(priority = 2)
    public void addGoal() throws InterruptedException
    {
        String Url = driver.getCurrentUrl();
        System.out.print(Url);
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LearningAppMarketplace lam = PageFactory.initElements(driver, LearningAppMarketplace.class);
        HomePage.addGoalButton.click();
        HomePage.addLearningApp.click();
        Thread.sleep(15000);
        List<WebElement> apps = driver.findElements(By.linkText("ADD"));
        WebElement clickedApp = apps.get(3);
        clickedApp.click();
        WebElement cal = driver.findElement(By.xpath("//input[contains(@data-type,'date')]"));
        cal.click();
        WebElement overlay = driver.findElement(By.id("set_target_overlay"));
        String appName = overlay.findElement(By.tagName("h2")).getText();
        System.out.println(appName);
        lam.clickDate.click();
        lam.addToPath.click();
    }



*/

/*
    @Test
    public void loginTestCoach()
    {
        WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.login(read.getCoachID(),read.getPassword());
        String CurrentURL = driver.getCurrentUrl();
        if(CurrentURL.contains("lrm"))
            Assert.assertTrue(true,"Testcase passed");
        driver.quit();
    }
*/

}

