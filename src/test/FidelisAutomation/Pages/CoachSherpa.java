package com.Fidelis.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoachSherpa {

    @FindBy(xpath = "//a[contains(.,'Flags')]")
    public WebElement flags;

    @FindBy(id = "manualFlag")
    public WebElement raiseManualFlag;

    @FindBy(id = "manualFlagDescription")
    public WebElement manualFlagName;

    @FindBy(className = "submit")
    public WebElement saveManualFlag;

    @FindBy(xpath = "//a[@rel='profile_shared_activity']")
    public WebElement activity;

    @FindBy(className = "super-r-button")
    public WebElement superR;

    @FindBy(xpath = "//button[@title='Close']")
    public WebElement closeAppRecommendationOverlay;

    @FindBy(xpath = "//a[@href='javascript:;'][contains(.,'Goals')]")
    public WebElement goals;

    @FindBy(xpath = "//a[@href='javascript:;'][contains(.,'Team')]")
    public WebElement teamTab;

    @FindBy(xpath = ("//a[contains(@class,'button button_sm recommend send_community_request')]"))
    public WebElement recommendCommunityButton;

    @FindBy(xpath = "//th[contains(@columnname,'goals_set')]")
    public WebElement goalSetHeader;

    @FindBy(xpath = "//th[@columnname='goals_missed']")
    public  WebElement goalMissedHeader;

}
