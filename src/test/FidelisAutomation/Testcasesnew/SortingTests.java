package com.FidelisAutomation.Testcases;

import com.Fidelis.Automation.Pages.CoachSherpa;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTests {
    configReader read = new configReader();
    WebDriver driver = BrowserFactory.startBrowser(read.getBrowserName());
    com.Fidelis.Automation.Pages.loginPage loginPage = PageFactory.initElements(driver, com.Fidelis.Automation.Pages.loginPage.class);
    com.Fidelis.Automation.Pages.CoachSherpa lrm = PageFactory.initElements(driver, CoachSherpa.class);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 80);

    @Test
    public void sortGoalsColumn() {
        try {
            loginPage.coachLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gradeX")));
        List<WebElement> rows_table = driver.findElements(By.className("gradeX"));
        int rows_count = rows_table.size();
        System.out.println("No of rows is " + rows_count);
        List sortedList = new ArrayList<Integer>();
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            String celltext_1 = Columns_row.get(8).getText();
            int celltext_2 = Integer.parseInt(celltext_1);
            System.out.println("Text  " + celltext_1);
            sortedList.add(celltext_2);
        }
        Collections.sort(sortedList);
        for (Object el : sortedList) {
            System.out.println(el);
        }
        List obtainedList = new ArrayList<Integer>();

        lrm.goalSetHeader.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gradeX")));
        List<WebElement> rows_table1 = driver.findElements(By.className("gradeX"));

        for (int row = 0; row < 31; row++) {
            List<WebElement> Columns_row2 = rows_table1.get(row).findElements(By.tagName("td"));
            String celltext = Columns_row2.get(8).getText();
            int celltext_3 = Integer.parseInt(celltext);
            System.out.println("Text  " + celltext);
            obtainedList.add(celltext_3);
        }
            for (Object el : obtainedList) {
                System.out.println("Obtained " +el);
            }
            Assert.assertTrue(sortedList.equals(obtainedList));
        }

    @Test
    public void sortGoalsMissedColumn() {
        try {
            loginPage.coachLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gradeX")));
        List<WebElement> rows_table = driver.findElements(By.className("gradeX"));
        int rows_count = rows_table.size();
        System.out.println("No of rows is " + rows_count);
        List sortedList = new ArrayList<Integer>();
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            String celltext_1 = Columns_row.get(9).getText();
            int celltext_2 = Integer.parseInt(celltext_1);
            System.out.println("Text  " + celltext_1);
            sortedList.add(celltext_2);
        }
        Collections.sort(sortedList);
        for (Object el : sortedList) {
            System.out.println(el);
        }
        List obtainedList = new ArrayList<Integer>();

        lrm.goalMissedHeader.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gradeX")));
        List<WebElement> rows_table1 = driver.findElements(By.className("gradeX"));

        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Columns_row2 = rows_table1.get(row).findElements(By.tagName("td"));
            String celltext = Columns_row2.get(9).getText();
            int celltext_3 = Integer.parseInt(celltext);
            System.out.println("Text  " + celltext);
            obtainedList.add(celltext_3);
        }
        for (Object el : obtainedList) {
            System.out.println("Obtained " +el);
        }
        Assert.assertTrue(sortedList.equals(obtainedList));
    }
}



