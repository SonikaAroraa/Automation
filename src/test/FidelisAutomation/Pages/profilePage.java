package com.Fidelis.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class profilePage {
    WebDriver driver;

    public  profilePage(){
        this.driver = driver;
    }

    @FindBy(id = "homeProfileCompletionPercentage")
    public WebElement profileLinkOnHome;

    @FindBy(id = "timelinePlusButton")
    public  WebElement timelinePlusButton;

    @FindBy(xpath = "//a[contains(@rel,'addNewCompany')]")
    public WebElement addProfessionalExperience;

    @FindBy(xpath = "//a[contains(@googleanalyticsclickevent,'Add Interest,Profile')]")
    public WebElement addInterestOnProfile;

    @FindBy(id = "my_interest_0")
    public WebElement enterFirstInteresttextBox;

    @FindBy(id = "my_interest_1")
    public WebElement enterSecondInteresttextBox;

    @FindBy(id = "my_interest_2")
    public WebElement enterThirdInteresttextBox;

    @FindBy(xpath = "(//a[contains(@class,'save button orange')])")//check
    public WebElement saveInterests;

    @FindBy(xpath = "(//a[contains(@class,'f_right edit_btn')])[4]")
    public WebElement finalThoughtEdit;

    @FindBy(className = "hasMaxLength")
    public WebElement finalThoughtTextBox;

    @FindBy(xpath = "(//a[@href='javascript:;'][contains(.,'save')])[3]")
    public WebElement saveFinalThought;

    @FindBy(id = "finalThought")
    public WebElement finalThoughtValidation;

    @FindBy(xpath = "(//h3[@style='display: block;'])[1]")
    public WebElement interest_data_first;

    @FindBy(xpath = "(//h3[@style='display: block;'])[2]")
    public WebElement interest_data_second;

    @FindBy(xpath = "(//h3[@style='display: block;'])[3]")
    public WebElement interest_data_third;
}
