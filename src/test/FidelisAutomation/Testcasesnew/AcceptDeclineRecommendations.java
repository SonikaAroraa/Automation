package FidelisAutomation.Testcasesnew;


import FidelisAutomation.Pages.LearningAppMarketplace;
import FidelisAutomation.Pages.loginPage;
import FidelisAutomation.Utilities.BrowserFactory;
import FidelisAutomation.Utilities.configReader;
import com.Fidelis.Automation.Pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AcceptDeclineRecommendations {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    FidelisAutomation.Pages.loginPage loginPage = PageFactory.initElements(driver, FidelisAutomation.Pages.loginPage.class);
    com.Fidelis.Automation.Pages.CoachSherpa lrm = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.CoachSherpa.class);
    LearningAppMarketplace lam = PageFactory.initElements(driver, LearningAppMarketplace.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 80);
    com.Fidelis.Automation.Pages.MentorMenteePage MentorMenteePage = PageFactory.initElements(driver, MentorMenteePage.class);
    com.Fidelis.Automation.Pages.HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
    com.Fidelis.Automation.Pages.myCommunities myCommunities = PageFactory.initElements(driver, myCommunities.class);

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    @Test
    public void acceptAppRecommedation() throws InterruptedException {
        loginPage.loginTestStudent();
        wait.until(ExpectedConditions.titleContains("Home"));
        List<WebElement> recommendedApps = driver.findElements(By.xpath("(//div[@class='list_item recommended learningapp first added_by_advisor cursorDefault'])"));
        if (recommendedApps.size() == 0) {
            System.out.println("Here in if: No recommendations found");
            assert (false);
        } else {
            recommendedApps.get(0).findElement(By.className("recommend_accept")).click();
            String acceptedAppTitle = recommendedApps.get(0).findElement(By.className("app_desc")).findElement(By.className("learning_app_link")).getAttribute("title");
            System.out.println(acceptedAppTitle);
            WebElement cal = driver.findElement(By.xpath("//input[contains(@data-type,'date')]"));
            cal.click();
            lam.clickDate.click();
            lam.addToPath.click();
            Thread.sleep(5000);
            List<WebElement> addedApps = driver.findElements(By.xpath("(//div[@class='list_item started cursorDefault'])"));
            for (WebElement addedAppName : addedApps) {
                String addedAppName1 = addedAppName.findElement(By.className("app_desc")).findElement(By.className("learning_app_link")).getAttribute("title");
                if (addedAppName1.equalsIgnoreCase(acceptedAppTitle)) {
                    Assert.assertTrue(true);
                    System.out.println("Here " + addedAppName1);
                    break;
                } else {
                    System.out.println("in else " + addedAppName1);
                }
            }
        }

    }

    @Test(priority = 1)
    public void acceptMentorRecommendation() {
        try {
            loginPage.loginTestStudent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.titleContains("Home"));
        MentorMenteePage.exploreMentors.click();

        List<WebElement> recommendedMentors = driver.findElements(By.xpath("(//div[contains(@class,'list_item recommended first')])"));
        if (recommendedMentors.size() == 0) {
            System.out.println("Here in if: No recommendations found");
            assert (false);
        } else {
            WebElement mentorToAccept = recommendedMentors.get(0).findElement(By.className("recommend_accept"));
            mentorToAccept.click();
            wait.until(ExpectedConditions.visibilityOf(MentorMenteePage.acceptOnDialog));
            MentorMenteePage.acceptOnDialog.click();
            String acceptedMentorName = mentorToAccept.getAttribute("mentor_name");
            System.out.println(" Accepted Mentor:" + acceptedMentorName);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<WebElement> outgoingRequests = driver.findElements(By.xpath("(//div[contains(@class,'list_item pending_request')])"));
            System.out.println(outgoingRequests.size());
            for (WebElement outgoingRequestNames : outgoingRequests) {
                String mentorName = outgoingRequestNames.findElement(By.tagName("h2")).getText();
                System.out.println(mentorName);
                if (mentorName.equalsIgnoreCase(acceptedMentorName)) {
                    Assert.assertTrue(true);
                    System.out.println("Here " + mentorName);
                    break;
                } else
                    System.out.println("in else " + mentorName);
            }

        }
    }


    //need to identify the community name here
    @Test
    public void acceptCommunityRecommendation() {
        try {
            loginPage.loginTestStudent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.titleContains("Home"));
        HomePage.communities.click();
        HomePage.myCommunities.click();
        executor.executeScript("arguments[0].click();", HomePage.myCommunities);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isElementPresent(By.xpath("//a[contains(@class,'button grey acceptComRecom mar_l10')]")))
        {
            System.out.println("here acceptCommunityButton ");
            myCommunities.acceptCommunityButton.click();
            wait.until(ExpectedConditions.visibilityOf(myCommunities.buttonOnDialog));
            myCommunities.buttonOnDialog.click();
            assert (true);
        }
       else
           if (isElementPresent(By.xpath("//a[@href='javascript:;'][contains(.,'Apply to Join')]")))
           {
               System.out.println("Here");
               myCommunities.applyToJoinButton.click();
               wait.until(ExpectedConditions.visibilityOf(myCommunities.buttonOnDialog));
               myCommunities.buttonOnDialog.click();
               assert (true);
        }
        else
            {
            System.out.println("No recommendations available");
            assert (false);
        }
    }
}



