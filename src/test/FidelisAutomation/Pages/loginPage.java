package FidelisAutomation.Pages;

import FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class loginPage {
    WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 80);


    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//a[@class='button button_lg x_signin_button']")
    WebElement loginButton;

 //   WebDriverWait wait = new WebDriverWait(driver, 80);

    public void login(String uid, String pswrd) {
        username.sendKeys(uid);
        password.sendKeys(pswrd);
        loginButton.click();

    }

    public void authorLogin() throws InterruptedException {
        // WebDriverWait wait=new WebDriverWait(driver, 20);
        configReader read = new configReader();
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(read.getAuthorID(), read.getPassword());
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);
    }

    public void studentLogin() throws InterruptedException {
        configReader read = new configReader();
        // WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
        loginPage loginPage = (FidelisAutomation.Pages.loginPage) PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.login(read.getStudentID(), read.getPassword());
    }

    public void publisherLogin() throws InterruptedException {
        // WebDriverWait wait=new WebDriverWait(driver, 20);
        configReader read = new configReader();
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(read.getPublisherID(), read.getPassword());
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);
    }

    public void moderatorLogin() throws InterruptedException {
        // WebDriverWait wait=new WebDriverWait(driver, 20);
        configReader read = new configReader();
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(read.getModeratorId(), read.getPassword());
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);

    }

    public void graderLogin() throws InterruptedException {
        // WebDriverWait wait=new WebDriverWait(driver, 20);
        configReader read = new configReader();
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(read.getModeratorId(), read.getPassword());
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);

    }
}