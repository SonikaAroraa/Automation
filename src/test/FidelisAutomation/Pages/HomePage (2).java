package com.Fidelis.Automation.Pages;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage
    {
        WebDriver driver;

    public HomePage(WebDriver driver)
        {
            this.driver = driver;
        }

        @FindBy(xpath = "//div[@omniture='App Store,App Store'][contains(@id,'goal')][contains(.,'Add Goal')]")
        public WebElement addGoalButton;

        @FindBy(className = "js-goals-current")
        public WebElement Current;

        @FindBy(className = "js-goals-future")
        public WebElement future;

        @FindBy(className = "js-goals-history")
        public WebElement history;

        @FindBy(xpath = "//a[@omniture='Activity,Activity'][contains(.,'Activity')]")
        public WebElement activity;

        @FindBy(xpath = "(//a[@href='javascript:;'])[28]")
        public WebElement goals;

        @FindBy(xpath = "//a[@omniture='Add Objectives,Objective'][contains(.,'Add')]")
        public WebElement addPurpose;

        @FindBy(xpath = "//a[@omniture='Agenda,Agenda'][contains(.,'Agenda')]")
        public WebElement calenderAgenda;

        @FindBy(id = "mentors")
        public WebElement manageMentor;

        @FindBy(id = "mentees")
        public WebElement manageMentee;

        @FindBy(xpath = "//span[contains(.,'Communities')]")
        public WebElement communities;

        @FindBy(xpath = "//a[@rel='my_communities']")
        public WebElement myCommunities;

        @FindBy(xpath = "//a[contains(.,'View other communities')]")
        public WebElement viewOtherCommunities;

        @FindBy(xpath = "(//a[@href='javascript:;'])[29]")
        public WebElement profile;

        @FindBy(xpath = "//a[@class='add_app'][contains(.,'Learning App')]")
        public WebElement addLearningApp;

        @FindBy(id = "student_menu")
        public WebElement userDropdown;

        @FindBy(id = "account_nav")
        public WebElement settings;

        @FindBy (className ="edit_email")
        public WebElement editPrimaryEmail;

        @FindBy(xpath = "(//input[contains(@type,'text')])[1]")
        public WebElement enterEmail;

        @FindBy (id ="saveEmail")
        public WebElement saveEmail;

        @FindBy(xpath = "//div[@class='f_left'][contains(.,'Email Updated Successfully')]")
        public WebElement successMessage;

        @FindBy(className = "recommend_accept")
        public WebElement acceptRecommendationButton;

        @FindBy(xpath = "//a[@omniture='Logout,HomePage,e'][contains(.,'Logout')]")
        public WebElement logout;

        @FindBy(id = "notifications_tile")
        public WebElement notifications_tile;



}
