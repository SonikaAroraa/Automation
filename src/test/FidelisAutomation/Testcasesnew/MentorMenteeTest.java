package com.FidelisAutomation.Testcases;
import com.Fidelis.Automation.Pages.MentorMenteePage;
import com.Fidelis.Automation.Pages.loginPage;
import com.FidelisAutomation.Testcases.loginTest;
import com.Fidelis.Automation.Pages.HomePage;
import com.com.FidelisAutomation.Utilities.BrowserFactory;
import com.com.FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MentorMenteeTest {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    com.Fidelis.Automation.Pages.HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
    MentorMenteePage mentorMenteePage = PageFactory.initElements(driver, MentorMenteePage.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    com.Fidelis.Automation.Pages.loginPage loginPage = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.loginPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 90);


    @Test(priority = 1)
    public void loginTestStudent() throws InterruptedException {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(read.getStudentID(), read.getPassword());
        Thread.sleep(3000);
        String CurrentURL = driver.getCurrentUrl();
        System.out.print(CurrentURL);
        if (CurrentURL.contains("home"))
            Assert.assertTrue(true, "Testcase passed");
        else
            Assert.assertFalse(true, "Testcase passed");
    }

    @Test(priority = 3)
    public void AddMentor()
    {

        executor.executeScript("arguments[0].click();", HomePage.manageMentor.findElement(By.className("img")));
        List<WebElement> MentorList = driver.findElements(By.className("default_recommend"));
        executor.executeScript("arguments[0].click();", MentorList.get(0).findElement(By.className("add_internal_mentor_button")));
        String ClickedMentorName = MentorList.get(0).findElement(By.className("add_internal_mentor_button")).getAttribute("mentor_name");
        System.out.println(ClickedMentorName);
        mentorMenteePage.mentorMessage.sendKeys("Mentor Request sent through Automation");
        mentorMenteePage.acceptOnDialog.click();
        mentorMenteePage.myMentors.click();
        boolean requestSent = (driver.getPageSource().contains(ClickedMentorName));
        Assert.assertEquals(requestSent,true);
    }

    @Test(priority = 2)
    public void AddMentee() {

        executor.executeScript("arguments[0].click();", HomePage.manageMentee.findElement(By.className("img")));
        List<WebElement> MenteeList = driver.findElements(By.className("default_recommend"));
        executor.executeScript("arguments[0].click();", MenteeList.get(0).findElement(By.className("button")));
        String ClickedMenteeName = MenteeList.get(0).findElement(By.className("button")).getAttribute("mentee_name");
        System.out.println(ClickedMenteeName);
        mentorMenteePage.mentorMessage.sendKeys("Mentee Request sent through Automation");
        mentorMenteePage.acceptOnDialog.click();
        mentorMenteePage.myMentors.click();
        boolean requestSent = (driver.getPageSource().contains(ClickedMenteeName));
        Assert.assertEquals(requestSent, true);
    }

    @Test(priority = 3)
    public void searchAndAddMentorAndValidateNotification() {
        try {
            loginPage.loginTestStudent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.executeScript("arguments[0].click();", HomePage.manageMentor.findElement(By.className("img")));
        wait.until(ExpectedConditions.visibilityOf(mentorMenteePage.mentorSearchBox));
        mentorMenteePage.mentorSearchBox.sendKeys("Admin");
        mentorMenteePage.searchButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //List<WebElement> MentorList = driver.findElements(By.className("default_recommend"));
        WebElement button = driver.findElement(By.xpath("//button[contains(@mentor_name,'Smoke Admin1')]"));
        executor.executeScript("arguments[0].click();", button);
        String ClickedMentorName = driver.findElement(By.xpath("//button[contains(@mentor_name,'Smoke Admin1')]")).getAttribute("mentor_name");
        System.out.println(ClickedMentorName);
        mentorMenteePage.mentorMessage.sendKeys("Mentor Request sent through Automation");
        mentorMenteePage.acceptOnDialog.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mentorMenteePage.myMentors.click();
        // boolean requestSent = (driver.getPageSource().contains(ClickedMentorName));
        // Assert.assertEquals(requestSent,true);
        loginPage.logout();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(mentorMenteePage.topNavBell));
        mentorMenteePage.topNavBell.click();
        wait.until(ExpectedConditions.visibilityOf(HomePage.notifications_tile));
        List<WebElement> notifications = HomePage.notifications_tile.findElements(By.className("body"));
        System.out.println(notifications.size());
        boolean test = false;
        for (WebElement notification1 : notifications) {
                if (notification1.getText().contains("Sonika API test sent you a mentor request."))
                {
                     test = true;
                     System.out.println("inside the loop : " +test);
                    break;
                }
            }
            System.out.println("outside loop : " +test);
            Assert.assertTrue(test);
    }

}
