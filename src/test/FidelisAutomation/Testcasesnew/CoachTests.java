package com.FidelisAutomation.Testcases;

import com.Fidelis.Automation.Pages.CoachSherpa;
import com.Fidelis.Automation.Pages.loginPage;
import com.com.FidelisAutomation.Utilities.BrowserFactory;
import com.com.FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class CoachTests {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    com.Fidelis.Automation.Pages.loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
    com.Fidelis.Automation.Pages.CoachSherpa lrm = PageFactory.initElements(driver, CoachSherpa.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 80);

    @Test(priority = 0)
    public void RaiseManualFlag()  {

        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        try {
            loginPage.coachLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> Students = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("l-student-name")));
        //WebElement student = wait.until(ExpectedConditions.elementToBeClickable(Students.get(0)));
        WebElement student = driver.findElement(By.xpath("//div[@class='nameContainer'][contains(.,'"+read.getStudentID()+"')]"));
        student.click();
        executor.executeScript("arguments[0].click();", lrm.flags);
        lrm.raiseManualFlag.click();
        lrm.manualFlagName.sendKeys("Green Flag generated through Automation" + n);
        lrm.saveManualFlag.click();
        lrm.activity.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lrm.flags.click();
        lrm.flags.click();
        System.out.println((driver.getPageSource().contains("Green Flag generated through Automation" + n)));
    }

    @Test(priority = 1)
    public void recommendApp() throws InterruptedException {
        loginPage.coachLogin();
        List<WebElement> Students = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("l-student-name")));
        WebElement student = wait.until(ExpectedConditions.elementToBeClickable(Students.get(0)));
        student.click();
        lrm.activity.click();
        lrm.superR.click();
        List<WebElement> SuperROptions = driver.findElements(By.className("superR-recommendations"));
        for (WebElement item : SuperROptions) {
            if (item.getText().equalsIgnoreCase("App")) {
                item.click();
                break;
            }
        }
        Thread.sleep(5000);
        List<WebElement> appsToRecommend1 = driver.findElements(By.xpath("(//a[@class='button grey set_recommendation_msg'][contains(.,'Recommend')])"));
        System.out.println("Printing size of list" + appsToRecommend1.get(6).getAttribute("goalid"));
        String goalId = appsToRecommend1.get(6).getAttribute("goalid");
        executor.executeScript("arguments[0].click();", appsToRecommend1.get(6));
        WebElement sendButton = driver.findElement(By.xpath("//a[contains(@lapid,'" + goalId + "')]"));
        sendButton.click();
        System.out.println(sendButton.getAttribute("lapid"));
        lrm.closeAppRecommendationOverlay.click();
        wait.until(ExpectedConditions.elementToBeClickable(lrm.goals));
        executor.executeScript("arguments[0].click();", lrm.goals);
        List<WebElement> appsPresent = driver.findElements(By.className("list_item"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@activity_id,'" + goalId + "')]")));
        boolean pass = driver.getPageSource().contains(goalId);
        System.out.println(pass);
        Assert.assertEquals(pass, true);
        //   executor.executeScript("arguments[0].click();",sendButton);
    }

    @Test(priority = 2)
    public void recommendMentor() throws InterruptedException {
        loginPage.coachLogin();
        List<WebElement> Students = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("l-student-name")));
        WebElement student = wait.until(ExpectedConditions.elementToBeClickable(Students.get(0)));
        student.click();
        lrm.activity.click();
        lrm.superR.click();
        List<WebElement> SuperROptions = driver.findElements(By.className("superR-recommendations"));
        for (WebElement item : SuperROptions) {
            if (item.getText().equalsIgnoreCase("Mentor")) {
                item.click();
                break;
            }
        }

        List<WebElement> mentorRecommendButton = driver.findElements(By.className("add_internal_mentor_button"));
        String elementId = mentorRecommendButton.get(0).getAttribute("id");
        mentorRecommendButton.get(0).click();
        System.out.println(elementId);
        String[] mentorId1 = elementId.split("_");
        String recommendedMentorId = mentorId1[1];
        driver.findElement(By.xpath("//a[contains(@mentor_id,'" + recommendedMentorId + "')]")).click();
    }

    @Test(priority = 3)
    public void recommendCommunity() throws InterruptedException
    {
        loginPage.coachLogin();
        List<WebElement> Students = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("l-student-name")));
        WebElement student = wait.until(ExpectedConditions.elementToBeClickable(Students.get(0)));
        student.click();
        wait.until(ExpectedConditions.elementToBeClickable(lrm.teamTab));
        executor.executeScript("arguments[0].click();",lrm.teamTab);
        wait.until(ExpectedConditions.elementToBeClickable(lrm.recommendCommunityButton));
        lrm.recommendCommunityButton.click();
        List<WebElement> recommendCommunity = driver.findElements(By.xpath("(//a[@class='button orange set_recommendation_msg'])"));
        WebElement communityRecommended = recommendCommunity.get(0);
        String communityID = communityRecommended.getAttribute("communityid");
        communityRecommended.click();
        driver.findElement(By.xpath("//a[contains(@community_id,'" + communityID + "')]")).click();
    }
}



