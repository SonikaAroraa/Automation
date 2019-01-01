package com.FidelisAutomation.Testcases;

import com.Fidelis.Automation.Pages.HomePage;
import com.Fidelis.Automation.Pages.MentorMenteePage;
import com.Fidelis.Automation.Pages.profilePage;
import com.com.FidelisAutomation.Utilities.BrowserFactory;
import com.com.FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class profilePageTests {

    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    com.Fidelis.Automation.Pages.HomePage HomePage = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.HomePage.class);
    com.Fidelis.Automation.Pages.profilePage profilePage = PageFactory.initElements(driver, profilePage.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    com.Fidelis.Automation.Pages.loginPage loginPage = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.loginPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 90);

    @Test
    public void editProfile()
    {
        try {
            loginPage.loginTestStudent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String sentfirst  =  "Acting";
        String sentsecond  =  "American Football";
        String sentThird  =  "Astronomy";

        profilePage.profileLinkOnHome.click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(profilePage.addInterestOnProfile));
        }catch(Exception e){
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click();",profilePage.addInterestOnProfile);
        profilePage.enterFirstInteresttextBox.clear();
        profilePage.enterFirstInteresttextBox.sendKeys(sentfirst);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        profilePage.enterFirstInteresttextBox.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterFirstInteresttextBox.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterSecondInteresttextBox.clear();
        profilePage.enterSecondInteresttextBox.sendKeys(sentsecond);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterSecondInteresttextBox.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterSecondInteresttextBox.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterThirdInteresttextBox.clear();

        profilePage.enterThirdInteresttextBox.sendKeys(sentThird);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterThirdInteresttextBox.sendKeys(Keys.DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.enterThirdInteresttextBox.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilePage.saveInterests.click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(profilePage.finalThoughtEdit));
        }catch (Exception e) {
            e.printStackTrace();
        }

        executor.executeScript("arguments[0].click();",profilePage.finalThoughtEdit);
        profilePage.finalThoughtTextBox.clear();
        String finalThoughtToEnter = "Final Thought on Profile Page";
        profilePage.finalThoughtTextBox.sendKeys(finalThoughtToEnter);
        profilePage.saveFinalThought.click();
        String first  =  profilePage.interest_data_first.getText();
        String second = profilePage.interest_data_second.getText();
        String third = profilePage.interest_data_third.getText();
        System.out.print("Printing First: "+first);
        System.out.print("Printing second: "+second);
        System.out.print("Printing 3rd: "+third);

        Assert.assertEquals(sentfirst,first);
        Assert.assertEquals(sentsecond,second);
        Assert.assertEquals(sentThird,third);
        String finalThoughtTextTovalidate = profilePage.finalThoughtValidation.getText();
        Assert.assertEquals(finalThoughtTextTovalidate, finalThoughtToEnter);
    }
}
