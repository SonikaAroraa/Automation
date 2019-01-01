package FidelisAutomation.Testcasesnew;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {

    static WebDriver driver;
    JavascriptExecutor executor = (JavascriptExecutor) driver;


    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();

            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }   // isAlertPresent()


    @org.junit.Test
    public void getNumber() throws InterruptedException

    {
        System.setProperty("webdriver.chrome.driver", "D:\\Fidelis\\FidelisAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://recruit.journeylabs.io/");
        WebElement answerBox = driver.findElement(By.id("textinput"));
        WebElement resultbox = driver.findElement(By.id("resultBox"));
        WebElement submit = driver.findElement(By.id("singlebutton"));
        // submit.click();
        String num ="0";
        int counter = 0;
        //submit.click();
        for (counter = 1; counter <= 500; counter++) {
           // System.out.print("inside if");
            answerBox.clear();
            //long a =0, n,  b = 0, c = 1;
        //    System.out.print("Enter value of n:");
        //    System.out.print("Fibonacci Series:");
            /*for(int i = 1; i <= 500; i++) {
                a = b;
                b = c;
                c = a + b;
                */

            // answerBox.sendKeys(String.valueOf(counter));
                answerBox.sendKeys(String.valueOf(num));
            num = resultbox.getText();
                submit.click();
                Thread.sleep(2000);
                if (isAlertPresent()) {
                    System.out.print("inside if");
                    String alertText = driver.switchTo().alert().getText();
                    System.out.println(alertText);
                    driver.switchTo().alert().accept();
                    System.out.print("executed");
                    //submit.click();

                }
                answerBox.clear();

            }

            Thread.sleep(1000);

            System.out.println(num);




            // submit.click();
                //break;
            }

        }


