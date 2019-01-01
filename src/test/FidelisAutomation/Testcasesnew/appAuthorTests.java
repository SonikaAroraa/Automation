package FidelisAutomation.Testcasesnew;

import FidelisAutomation.Pages.*;
import FidelisAutomation.Utilities.BrowserFactory;
import FidelisAutomation.Utilities.configReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class appAuthorTests {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
    moderatorPage moderatorPage = PageFactory.initElements(driver, moderatorPage.class);
    appAuthoringPage authoringPage = PageFactory.initElements(driver, appAuthoringPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 80);
    JavascriptExecutor executor = (JavascriptExecutor) driver;


    @Test(priority = 1)
    public void createApp() {
        try {
            loginPage.authorLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.createAppButton));
        authoringPage.createAppButton.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.createNewApp));
        authoringPage.createNewApp.click();
        authoringPage.enterAppTitle.click();
        authoringPage.enterAppTitle.sendKeys("Automation App4");
        authoringPage.moderatedChkBox.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(authoringPage.ckEditorFrame);
        authoringPage.ckEditorBody.sendKeys("AutomationApp About Section");
        driver.switchTo().defaultContent();
        authoringPage.createAppSaveButton.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].scrollIntoView(false);", authoringPage.appNewPage);
        authoringPage.appNewPage.click();
        wait.until(ExpectedConditions.visibilityOf(authoringPage.appAddTextAndImages));
        authoringPage.appAddTextAndImages.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(authoringPage.ckEditorFrame);
        authoringPage.ckEditorBody.sendKeys("AutomationApp Page Section");
        driver.switchTo().defaultContent();
        authoringPage.appSavePage.click();
        System.out.print("herebefore");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click();", authoringPage.appAddPages);
        System.out.print("herebefore2");
        authoringPage.appAddAppExam.click();
        System.out.print("herebefore3");
        wait.until(ExpectedConditions.visibilityOf(authoringPage.appExamPageWorkload));
        authoringPage.appExamPageWorkload.click();
        authoringPage.appExamPageWorkload.sendKeys("2");
        authoringPage.saveFinalExam.click();
        authoringPage.nextButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.finalExamEditPage));
        executor.executeScript("arguments[0].click()", authoringPage.finalExamEditPage);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.finalExamAddQuestion.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.addTrueOrFalseQuestion.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.appTotalPoints.click();

        authoringPage.appTotalPoints.sendKeys("20");

        System.out.println("before frme");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cke_tr_question_description"))));
        //newframe.click();
        //newframe.sendKeys("tetsquest");
        wait.until(ExpectedConditions.visibilityOf(authoringPage.ckEditorBody));
        driver.switchTo().frame(authoringPage.Frame);
        System.out.println("after frme");
        // executor.executeScript("arguments[0].scrollIntoView(true);",authoringPage.ckEditorBody);
        authoringPage.ckEditorBody.click();
        authoringPage.ckEditorBody.sendKeys("AutomationApp true or false Question");
        System.out.println("after sendkeys");

        driver.switchTo().defaultContent();
        authoringPage.selectTrue.click();
        authoringPage.saveTrueFalseQuestion.click();
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.finalExamAddQuestion));
        executor.executeScript("arguments[0].click();", authoringPage.finalExamAddQuestion);
        //authoringPage.goBack.click();
        //authoringPage.goBack.click();
        authoringPage.addShortAnswerQuestion.click();

        // wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        System.out.print("after wait");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cke_tr_question_description"))));
        //newframe.click();
        //newframe.sendKeys("tetsquest");
        executor.executeScript("arguments[0].scrollIntoView(true);", authoringPage.shortAnswerFrame);
        wait.until(ExpectedConditions.visibilityOf(authoringPage.ckEditorBody));
        driver.switchTo().frame(authoringPage.shortAnswerFrame);
        System.out.println("after frme");
        executor.executeScript("arguments[0].click();", authoringPage.ckEditorBody);

         //  authoringPage.ckEditorBody.click();
        authoringPage.ckEditorBody.sendKeys("AutomationApp short answer Question");
        System.out.println("after sendkeys");
        driver.switchTo().defaultContent();
        authoringPage.shortQuesPoints.click();
        authoringPage.shortQuesPoints.sendKeys("20");
        authoringPage.saveShortQuesAnswer.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click();", authoringPage.examPageSave);
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.goBack));
        executor.executeScript("arguments[0].click();", authoringPage.goBack);
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.templateOverviewBack));
        authoringPage.templateOverviewBack.click();
        driver.quit();
    }

    @Test(priority = 2)
    public void addModeratorAndPublish() {
        try {
            loginPage.authorLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(authoringPage.searchApps));
        authoringPage.searchApps.sendKeys("Automation App4");
        wait.until(ExpectedConditions.elementToBeClickable(authoringPage.clickApp));
        authoringPage.clickApp.click();
        authoringPage.addModerator.click();
        authoringPage.enterModeratorName.sendKeys("moderator");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.enterModeratorName.sendKeys(Keys.DOWN);
        authoringPage.enterModeratorName.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.saveModerator.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.versions.click();
        authoringPage.clickAppOptions.click();
        authoringPage.submitToPublisher.click();
        authoringPage.publishConfirmationContinueButton.click();
        driver.close();
    }

    @Test(priority = 3)
    public void publishApp() {
        WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());

        try {
            loginPage.publisherLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authoringPage.navigateToSubmittedApps.click();
        authoringPage.appInSubmittedApps.click();
        authoringPage.clickAppOptions.click();
        authoringPage.publishApp.click();
        authoringPage.publishButtonOnOverlay.click();
        driver.close();
    }

    @Test(priority = 4)

    public void takeApp() throws InterruptedException {
        configReader read = new configReader();
        loginPage.studentLogin();
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LearningAppMarketplace lam = PageFactory.initElements(driver, LearningAppMarketplace.class);
        wait.until(ExpectedConditions.visibilityOf(HomePage.addGoalButton));
        HomePage.addGoalButton.click();
        HomePage.addLearningApp.click();
        wait.until(ExpectedConditions.visibilityOf(lam.searchApps));
        lam.searchApps.sendKeys("Automation App4");
        lam.addGoalfromLAM.click();
        WebElement cal = driver.findElement(By.xpath("//input[contains(@data-type,'date')]"));
        //cal.click();
        // lam.clickDate.click();
        lam.goToApp.click();
        wait.until(ExpectedConditions.visibilityOf(lam.startButton));
        lam.startButton.click();
        lam.nextPage.click();
        lam.nextPage.click();
        lam.selectTrue.click();
        lam.typedResponse.sendKeys("Automation Response");
        lam.finishExam.click();
        lam.finishApp.click();
        driver.close();
    }

    @Test(priority = 5)
    public void moderateApp() throws InterruptedException {
        WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
        loginPage.moderatorLogin();
        wait.until(ExpectedConditions.visibilityOf(moderatorPage.countOntheTop));
        Thread.sleep(30000);
        moderatorPage.searchBox.sendKeys("Automation App4");
        moderatorPage.searchButton.click();
        Thread.sleep(30000);
        wait.until(ExpectedConditions.visibilityOf(moderatorPage.selectStudenttoModerate));
        moderatorPage.selectStudenttoModerate.click();
        System.out.print("Here beforeJS");
        Thread.sleep(5000);
        executor.executeScript("arguments[0].scrollIntoView(true);", moderatorPage.enterGrade);
        moderatorPage.enterGrade.clear();
        System.out.print("Here after");
        moderatorPage.enterGrade.sendKeys("20");
        moderatorPage.saveGrades.click();
        moderatorPage.closeDetailView.click();
        if (moderatorPage.submitAllGradesButton.isEnabled()) {
            moderatorPage.submitAllGradesButton.click();
        } else
            assert (false);
        driver.close();
    }

        @Test(priority = 6)
        public void deleteApp() throws InterruptedException
        {
            WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
            try {
                loginPage.authorLogin();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myAppsSearch"))));
            // Thread.sleep(15000);
            System.out.print("Aftersleep");
            //driver.findElement(By.id("myAppsSearch")).click();
            for (int i = 0; i <= 10; i++) {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myAppsSearch"))));
                driver.findElement(By.id("myAppsSearch")).sendKeys("Automation App4");
                driver.findElement(By.xpath("(//a[@href='javascript:;'][contains(.,'Automation App4')])[1]")).click();
                driver.findElement(By.xpath("//a[contains(@class,'options')]")).click();
                driver.findElement(By.xpath("//a[@omniture='Delete App,App Author'][contains(.,'Delete')]")).click();
                driver.findElement(By.xpath("//a[contains(@class,'button affirm')]")).click();
                driver.quit();
                // driver.findElement(By.className("f_right")).click();
            }
        }
    }
