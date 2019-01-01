package com.Fidelis.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;

public class MentorMenteePage {

        WebDriver driver;

        public MentorMenteePage(WebDriver driver)
        {
            this.driver = driver;
        }

    @FindBy(id = "mentors")
    public WebElement exploreMentors;

    @FindBy(xpath = "//a[contains(@class,'button submit_mentor_request')]")
        public WebElement acceptOnDialog;

        @FindBy(id= "requestMessage")
        public WebElement mentorMessage;

        @FindBy(className = "active")
        public WebElement myMentors;

        @FindBy(id = "x_advisor_search")
        public WebElement mentorSearchBox;

    @FindBy(xpath = "//i[contains(@class,'fa fa-bell')]")
    public WebElement topNavBell;

    @FindBy(xpath = "//span[contains(@class,'search_icon')]")
    public WebElement searchButton;
}
