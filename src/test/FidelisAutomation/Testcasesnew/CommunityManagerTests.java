package com.FidelisAutomation.Testcases;

import com.Fidelis.Automation.Pages.CommunityManager;
import com.Fidelis.Automation.Pages.loginPage;
import com.com.FidelisAutomation.Utilities.BrowserFactory;
import com.com.FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;
import java.util.Random;

public class CommunityManagerTests
{
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    com.Fidelis.Automation.Pages.loginPage loginPage = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.loginPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 90);
    com.Fidelis.Automation.Pages.CommunityManager comManager = PageFactory.initElements(driver, CommunityManager.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    @Test(priority = 1)
    public void createSubcommunity() throws InterruptedException
    {
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.OrgStructure));
        wait.until(ExpectedConditions.elementToBeClickable(comManager.OrgStructure));
        executor.executeScript("arguments[0].click();", comManager.OrgStructure);
        executor.executeScript("arguments[0].click();", comManager.subcommunities);
        comManager.createSubcom.click();
        String newComName = "AutomationCommunitynew5"+ read.getreleaseNum();
        comManager.enterNewcomName.sendKeys(newComName);
        comManager.enterComAdmin.sendKeys("Smoke student10");
        List<WebElement> optionsToSelect = driver.findElements(By.tagName("li"));
        Thread.sleep(2000);
        comManager.enterComAdmin.sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        comManager.enterComAdmin.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        comManager.saveAndShare.click();
        Thread.sleep(5000);
        try {
            WebElement newCommunity = driver.findElement(By.xpath("//a[contains(.,'" + newComName + "')]"));
            if (newCommunity.isDisplayed()) {
                System.out.println("Here");
                Assert.assertTrue(true);
            } else {
                System.out.println("Here1");
                Assert.assertTrue(false);
            }
        }
        catch(Exception e) {
        assert (false);
    }
    }

    @Test(priority = 2)
    public void createTrainingGrp()
    {
        driver.get("https://dev2.fideliseducation.com/home.html");
        loginPage.logout();
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.OrgStructure));
        wait.until(ExpectedConditions.elementToBeClickable(comManager.OrgStructure));
        executor.executeScript("arguments[0].click();", comManager.OrgStructure);
        executor.executeScript("arguments[0].click();",comManager.trainingGrp);
        wait.until(ExpectedConditions.elementToBeClickable(comManager.createTrainingGrp));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //executor.executeScript("arguments[0].click();",comManager.createTrainingGrp);
        comManager.createTrainingGrp.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String trainingGrpName = "Automation Training Group3" +read.getreleaseNum();
        comManager.enterTrainingGroupName.sendKeys(trainingGrpName);
        String trainingGrpAdminName = "smoke";
        comManager.enterTrainingGroupAdmin.sendKeys(trainingGrpAdminName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.enterTrainingGroupAdmin.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.enterTrainingGroupAdmin.sendKeys(Keys.RETURN);
        comManager.selectTraingGroupType.click();
        comManager.selectTrngGrpType.click();
        comManager.saveTrainingGrp.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement newCommunity = driver.findElement(By.xpath("//a[contains(.,'"+trainingGrpName+"')]"));
        if(newCommunity.isDisplayed())
        {
            System.out.println("Here");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Here1");
            Assert.assertTrue(false);
        }

    }

    //assert doesnt work
    @Test(priority = 3)
    public void inviteMemberToTrnGrp()
    {
        loginPage.logout();
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.navigateToTrainingGroup);
        executor.executeScript("arguments[0].click();", comManager.trnGrpComManager);
        wait.until(ExpectedConditions.elementToBeClickable(comManager.inviteToTrainingGroup));
        comManager.inviteToTrainingGroup.click();
        comManager.inviteComMembers.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> inviteButton = driver.findElements(By.name("invite_member"));
        inviteButton.get(0).click();
        String invitedUsersId = inviteButton.get(0).getAttribute("user_id");
        System.out.println(invitedUsersId);
        comManager.closeInviteMemberDialog.click();
        comManager.invitedUsers.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Boolean test = driver.getPageSource().contains(invitedUsersId);
        System.out.println(test);
        Assert.assertTrue(test);

    }
//decide on approach select a particular student
    @Test(priority = 4)
    public void conferBadge()
    {
        loginPage.logout();
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.searchBox));
        comManager.searchBox.sendKeys("Student1");
        comManager.search_btn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement userSelected = comManager.checkBox;
        String primaryIdofUserSelected = userSelected.getAttribute("username");
        System.out.println(primaryIdofUserSelected);
        userSelected.click();
        comManager.dropDown.click();
        comManager.conferBadgeFromDropDown.click();
        List<WebElement> badgesToConfer = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[contains(@class,'list_item')])")));
        int i = badgesToConfer.size();
        System.out.println("Size = " +i);
        Random rand = new Random();
        int  n = rand.nextInt(i-1) + 1;
        System.out.println("Printing n"+ n);
        WebElement badgeConfered = driver.findElement(By.xpath("(//div[contains(@class,'list_item')])["+n+"]"));
        String maxScore = badgeConfered.findElement(By.xpath("(//span[contains(@class,'maxScore')])["+n+"]")).getText();
        System.out.println("Printing" +maxScore);
        badgeConfered.findElement(By.xpath("(//input[contains(@class,'w8per goalScore')])["+n+"]")).sendKeys(maxScore);
        badgeConfered.findElement(By.xpath("(//a[contains(@class,'button grey conferGoal')])["+n+"]")).click();

    }

    @Test(priority = 5)
    public void emailAsCsv()
    {
        loginPage.logout();
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.dropDown));
        comManager.dropDown.click();
        wait.until(ExpectedConditions.visibilityOf(comManager.selectAll));
        comManager.selectAll.click();
        comManager.dropDown.click();
        comManager.emailAsCsv.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (comManager.successAlertonSendingEmailAscsv.isDisplayed())
        {
            String text = comManager.alert_msg.getText();
            System.out.println("Text on alert  "+text);
            boolean s = text.equalsIgnoreCase("Report will be sent to your email address");
            comManager.OkayButton.click();
            System.out.println("Found "+s);
            Assert.assertTrue(s);
        }
        else
            assert (false);
    }
    @Test(priority = 6)
    public void updateCommunityConfigurations()
    {
       // loginPage.logout();
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.settings));
        comManager.settings.click();
        executor.executeScript("arguments[0].click();", comManager.manageConfiguration);
        wait.until(ExpectedConditions.visibilityOf(comManager.editCommunityConfiguration));
        comManager.editCommunityConfiguration.click();
        String value= comManager.hideCoachTileCheckBox.getAttribute("originalvalue");
        System.out.println(value);
       // if (value.equalsIgnoreCase("true"))
        comManager.hideCoachTileCheckBox.click();
        comManager.saveConfiguration.click();
        wait.until(ExpectedConditions.visibilityOf(comManager.editCommunityConfiguration));
        if (value.equalsIgnoreCase("true"))
        {
            boolean test = loginPage.isElementPresent(By.xpath("(//span[@class='content text'][contains(.,'No')])"));
            System.out.println("Asserting True - " +test);
            Assert.assertTrue(test);
        }
        else if (value.equalsIgnoreCase("false"))
    {
        boolean test = loginPage.isElementPresent(By.xpath("(//span[@class='content text'][contains(.,'Yes')])"));
        System.out.println("Asserting False - " +test);
        Assert.assertTrue(test);
    }
    else
        assert (false);
    }

    @Test(priority = 6)
    public void UpdateMentoringConfigurations()
    {
        loginPage.loginTestAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(comManager.tools));
        comManager.tools.click();
        executor.executeScript("arguments[0].click();", comManager.communityName);
        executor.executeScript("arguments[0].click();", comManager.communityManager);
        wait.until(ExpectedConditions.visibilityOf(comManager.settings));
        comManager.settings.click();
        executor.executeScript("arguments[0].click();", comManager.manageConfiguration);
        wait.until(ExpectedConditions.visibilityOf(comManager.editMentorConfiguration));
        comManager.editMentorConfiguration.click();
        comManager.textBoxForMentorApp.clear();
        comManager.textBoxForMentorApp.sendKeys("Why You Need a Mentor and How to Keep One");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.textBoxForMentorApp.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.textBoxForMentorApp.sendKeys(Keys.RETURN);
        comManager.textBoxForMenteeApp.clear();
        comManager.textBoxForMenteeApp.sendKeys("Moderated App");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.textBoxForMenteeApp.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comManager.textBoxForMenteeApp.sendKeys(Keys.RETURN);
        comManager.saveMentorConfiguration.click();

         if (loginPage.isElementPresent(By.xpath("//a[contains(.,'Why You Need a Mentor and How to Keep One')]")) && loginPage.isElementPresent(By.xpath("//a[contains(.,'Moderated App')]")))
         {
            assert (true); }
    else
        assert (false);
    }


    }




