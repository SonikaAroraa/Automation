package FidelisAutomation.Testcasesnew;

import FidelisAutomation.Pages.*;
import FidelisAutomation.Utilities.BrowserFactory;
import FidelisAutomation.Utilities.configReader;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BadgeTests {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    FidelisAutomation.Pages.loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
    FidelisAutomation.Pages.moderatorPage moderatorPage = PageFactory.initElements(driver, moderatorPage.class);
    appAuthoringPage authoringPage = PageFactory.initElements(driver, appAuthoringPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 80);
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    @Test
    public void createBadge()
    {
        try {
            loginPage.authorLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.createAppButton));
        authoringPage.createAppButton.click();
        authoringPage.createBadge.click();
        authoringPage.badgeTitleBox.click();
        authoringPage.badgeTitleBox.sendKeys("Automation Badge");
        authoringPage.saveBadgeTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.editOverViewInBadge));
        authoringPage.editOverViewInBadge.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(authoringPage.ckEditorFrame);
        authoringPage.ckEditorBody.click();
        authoringPage.ckEditorBody.sendKeys("About Badge Section Text");
        driver.switchTo().defaultContent();
        authoringPage.saveAboutBadge.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", authoringPage.badgeQuestionsPage);
        wait.until(ExpectedConditions.visibilityOf(authoringPage.badgeQuestionsPage));
        executor.executeScript("arguments[0].click()", authoringPage.badgeQuestionsPage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  wait.until(ExpectedConditions.visibilityOf(authoringPage.badgeAddQuestionButton));
        executor.executeScript("arguments[0].click()", authoringPage.selectTrueFalseQuestionInBadge);
      //  authoringPage.badgeAddQuestionButton.click();
       // authoringPage.selectTrueFalseQuestionInBadge.click();
        authoringPage.questionTotalPointsBadge.sendKeys("20");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(authoringPage.badgeTrueorFalseQuestionFrame);
        authoringPage.ckEditorBody.click();
        authoringPage.ckEditorBody.sendKeys("Question: Select True");
        driver.switchTo().defaultContent();
        executor.executeScript("arguments[0].scrollIntoView(true);", authoringPage.selectTrue);
        executor.executeScript("arguments[0].click()", authoringPage.selectTrue);
        executor.executeScript("arguments[0].scrollIntoView(true);", authoringPage.saveTrueFalseQuestion);
        authoringPage.saveTrueFalseQuestion.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void submitToPublisher()
    {
        try {
            loginPage.authorLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // authoringPage.inProgressTab.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.searchApps));
        authoringPage.searchApps.sendKeys("Automation Badge");
        try {

            wait.until(ExpectedConditions.elementToBeClickable(authoringPage.clickBadge));
        }
        catch(Exception e)
        {
            System.out.println("App not present ");
         assert (false);
            }

        authoringPage.clickBadge.click();
        authoringPage.versions.click();
        authoringPage.clickAppOptions.click();
        try {
            authoringPage.submitToPublisher.click();
        }
        catch (Exception e){
            assert (false);
        }
        authoringPage.publishConfirmationContinueButton.click();
    }


    @Test
    public void publishBadge()
    {
        try {
            loginPage.publisherLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(authoringPage.navigateToSubmittedApps));
        }
        catch (Exception e){
            System.out.println("Badge not present in submitted tab");
            assert (false);
        }
        authoringPage.navigateToSubmittedApps.click();
        authoringPage.clickBadge.click();
        authoringPage.clickAppOptions.click();
        authoringPage.publishApp.click();
        authoringPage.publishButtonOnOverlay.click();
    }


    @Test
    public void takeBadge(){
        try {
            loginPage.studentLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LearningAppMarketplace lam = PageFactory.initElements(driver, LearningAppMarketplace.class);
        wait.until(ExpectedConditions.visibilityOf(HomePage.addGoalButton));
        HomePage.addGoalButton.click();
        HomePage.addBadge.click();
        wait.until(ExpectedConditions.visibilityOf(lam.searchApps));
        lam.searchApps.sendKeys("Automation Badge");
        lam.addGoalfromLAM.click();
        try {
            WebElement cal = driver.findElement(By.xpath("//input[contains(@data-type,'date')]"));
            cal.click();
            lam.clickDate.click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        lam.goToApp.click();
        wait.until(ExpectedConditions.visibilityOf(lam.startBadgeAssessment));
        lam.startBadgeAssessment.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.publishConfirmationContinueButton));
        authoringPage.publishConfirmationContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.selectTrue));
        authoringPage.selectTrue.click();
        authoringPage.submitOnBadgeQuestion.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.publishConfirmationContinueButton));
        authoringPage.publishConfirmationContinueButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains("Result"));
    }

}
