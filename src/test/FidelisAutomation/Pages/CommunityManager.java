package com.Fidelis.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityManager {

    @FindBy(className = "admin_nav")
    public WebElement tools;

    @FindBy(xpath = "(//p[@class='community_name'])[1]")
    public WebElement communityName;

    @FindBy(id = "communityManager")
    public WebElement communityManager;

    @FindBy(xpath = "//a[@rel='manage_org_structure']")
    public WebElement OrgStructure;

    @FindBy(xpath = "//a[contains(@rel,'manage_subcommunities')]")
    public WebElement subcommunities;

    @FindBy(linkText = "Create New Sub-Community")
    public WebElement createSubcom;

    @FindBy(id = "communityName")
    public WebElement enterNewcomName;

    @FindBy(id = "communityAdmin")
    public WebElement enterComAdmin;

    @FindBy(id = "communityType")
    public WebElement selectComType;

    @FindBy(id = "create_community_btn")
    public WebElement saveAndShare;

    @FindBy(id = "refresh_community_manager")
    public WebElement refreshComManager;

    @FindBy(xpath = "//a[contains(@rel,'manage_training_groups')]")
    public WebElement trainingGrp;

    @FindBy(xpath = "//a[@class='button f_right blue'][contains(.,'Create New Training-Group')]")
    public WebElement createTrainingGrp;

    @FindBy(id = "trainingGroupName")
    public WebElement enterTrainingGroupName;

    @FindBy(id = "trainingGroupAdmin")
    public WebElement enterTrainingGroupAdmin;

    @FindBy(className = "sbSelector")
    public WebElement selectTraingGroupType;

    @FindBy(xpath = "//a[@title='Academic Dept'][contains(.,'Academic Dept')]")
    public WebElement selectTrngGrpType;

    @FindBy(id = "create_training_group_btn")
    public WebElement saveTrainingGrp;

    @FindBy(xpath = "(//p[@class='community_name'][contains(.,'Smoke Training Group')])[1]")
    public WebElement navigateToTrainingGroup;

    @FindBy(className = "invite_training_members")
    public WebElement inviteToTrainingGroup;

    @FindBy(xpath = "//a[@href='#admin/1485/community-manager']")
    public WebElement trnGrpComManager;

    @FindBy(id = "inviteTrainingStaff")
    public WebElement inviteComMembers;

    @FindBy(className = "middle")
    public WebElement invitedUsers;

    @FindBy(className = "ui-dialog-titlebar-close")
    public WebElement closeInviteMemberDialog;

    @FindBy(id = "search_input")
    public WebElement searchBox;

    @FindBy(className = "search_btn")
    public WebElement search_btn;

    @FindBy(className = "case")
    public WebElement checkBox;

    @FindBy(className = "col_filters")
    public WebElement dropDown;

    @FindBy(id = "conferBadge")
    public WebElement conferBadgeFromDropDown;

    @FindBy(xpath = "(//input[contains(@class,'w8per goalScore')])")
    public WebElement goalScoreForConfer;

    @FindBy(className = "selectall")
    public WebElement selectAll;

    @FindBy(id = "download_csv")
    public WebElement emailAsCsv;

    @FindBy(id = "fidelis_alert")
    public WebElement successAlertonSendingEmailAscsv;

    @FindBy(xpath = "(//div[contains(@id,'alert_msg')])[2]")
    public WebElement alert_msg;

    @FindBy(xpath = "//a[contains(@class,'button button_med button_med_centered')]")
    public WebElement OkayButton;

    @FindBy(xpath = "//a[contains(@rel,'manage_settings')]")
    public WebElement settings;

    @FindBy(xpath = "//a[contains(@rel,'manage_configuration')]")
    public WebElement manageConfiguration;

    @FindBy(xpath = "(//a[contains(@type,'Other')])[1]")
    public WebElement editCommunityConfiguration;

    @FindBy(xpath = "//input[contains(@name,'hide.coach.tile.if.coach.is.unassigned')]")
    public WebElement hideCoachTileCheckBox;

    @FindBy(xpath = "(//a[@name='saveConfiguration'])[1]")
    public WebElement saveConfiguration;

    @FindBy(xpath = "(//a[contains(@type,'Mentor')])[1]")
    public WebElement editMentorConfiguration;

    @FindBy(xpath = "//input[@placeholder='Search for apps/badges'][contains(@id,'mentor')]")
    public WebElement textBoxForMentorApp;

    @FindBy(xpath = "//input[@placeholder='Search for apps/badges'][contains(@id,'mentee')]")
    public WebElement textBoxForMenteeApp;

    @FindBy(xpath = "(//a[@name='saveConfiguration'])[2]")
    public WebElement saveMentorConfiguration;

}