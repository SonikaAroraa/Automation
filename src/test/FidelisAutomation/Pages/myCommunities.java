package com.Fidelis.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//Page not used
public class myCommunities
{

    WebDriver driver;

    public myCommunities(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@class,'button grey acceptComRecom mar_l10')]")
    public WebElement acceptCommunityButton;

    @FindBy(xpath = "(//a[@href='javascript:;'][contains(.,'Apply to Join')])")
    public WebElement applyToJoinButton;

    @FindBy(xpath = "//a[contains(@class,'button affirm')]")
    public WebElement buttonOnDialog;

}