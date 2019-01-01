package FidelisAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class appAuthoringPage
{
    WebDriver driver;

    public appAuthoringPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "(//a[contains(@class,'button f_right mar_r10 create_new_app')])[2]")
    public WebElement createAppButton;

    @FindBy(xpath = "(//li[@class='menu-subitem'][contains(.,'New')])[4]")
    public WebElement createNewApp;

    @FindBy(xpath = "//input[contains(@class,'app_title dotted_border')]")
    public WebElement enterAppTitle;

    @FindBy(id = "chbox_app_moderated")
    public WebElement moderatedChkBox;

    @FindBy(tagName ="iframe")
    public WebElement ckEditorFrame;

    @FindBy(tagName = "body")
    public WebElement ckEditorBody;

    @FindBy(id = "createNewTemplate")
    public WebElement createAppSaveButton;

    @FindBy(className = "next_page floating_right")
    public WebElement nextPageCreateApp;

    @FindBy(xpath = "//span[@title='New Page']")
    public WebElement appNewPage;

    @FindBy(className = "mixed_media")
    public WebElement appAddTextAndImages;

    @FindBy(xpath = "//a[@name='savePageButton']")
    public WebElement appSavePage;

    @FindBy(id = "addEditCourseContent")
    public WebElement appAddPages;

    @FindBy(xpath = "//a[contains(@id,'addNewExamModule')]")
    public WebElement appAddAppExam;

    @FindBy(xpath = "//div[@id = 'cke_315_contents']//iframe")
    public WebElement Frame;

    @FindBy(xpath = "//div[@id = 'cke_523_contents']//iframe")
    public WebElement shortAnswerFrame;

    @FindBy(xpath = "//input[contains(@id,'moduleWorkload')]")
    public WebElement appExamPageWorkload;

    @FindBy(id = "saveModuleOverview")
    public WebElement saveFinalExam;

    @FindBy(id = "moduleOverviewNext")
    public WebElement nextButton;

    @FindBy(xpath = "//a[contains(.,'Edit Page')]")
    public WebElement finalExamEditPage;

    @FindBy(xpath = "//input[@value='Add Question']")
    public WebElement finalExamAddQuestion;

    @FindBy(xpath = "//p[contains(.,'Short answer')]")
    public WebElement addShortAnswerQuestion;

    @FindBy(id = "true_false_dd")
    public WebElement addTrueOrFalseQuestion;

    @FindBy(xpath = "//input[@id='questionTotalPoints']")
    public WebElement appTotalPoints;

    @FindBy(xpath = "//input[contains(@value,'1')]")
    public WebElement selectTrue;

    @FindBy(xpath = "//a[@id='true_false_save']")
    public WebElement saveTrueFalseQuestion;

    @FindBy(id = "trq_total_points")
    public WebElement shortQuesPoints;

    @FindBy(id = "typed_response_save")
    public WebElement saveShortQuesAnswer;

    @FindBy(id = "exam_page_save")
    public WebElement examPageSave;

    @FindBy(xpath = "//img[contains(@alt,'Back')]")
    public WebElement goBack;

    @FindBy(id = "templateOverviewBack")
    public WebElement templateOverviewBack;

    @FindBy(id ="myAppsSearch")
    public WebElement searchApps;

    @FindBy(xpath = "(//a[@href='javascript:;'][contains(.,'Automation App3')])[1]")
    public WebElement clickApp;

    @FindBy(xpath = "//a[contains(@rel,'detailViewModerators')]")
    public WebElement addModerator;

    @FindBy(id = "moderatorName")
    public WebElement enterModeratorName;

    @FindBy(xpath = "//a[contains(.,'Versions')]")
    public WebElement versions;

    @FindBy(className = "options")
    public WebElement clickAppOptions;

    @FindBy(xpath = "//a[@omniture='Submitt App To Publisher,App Author'][contains(.,'Submit to publisher')]")
    public WebElement submitToPublisher;

    @FindBy(xpath = "//a[contains(@class,'button affirm')]")
    public WebElement publishConfirmationContinueButton;

    @FindBy(id = "saveModerator")
    public WebElement saveModerator;

    @FindBy(xpath = "//a[contains(@rel,'submitted_app')]")
    public WebElement navigateToSubmittedApps;

    @FindBy(xpath = "//a[contains(.,'Automation App3')]")
    public WebElement appInSubmittedApps;

    @FindBy(xpath = "//a[@omniture='Publish App,App Author'][contains(.,'Publish')]")
    public WebElement publishApp;

    @FindBy(id = "publish_btn")
    public WebElement publishButtonOnOverlay;

    @FindBy(xpath = "(//a[@name='createBadge'])[2]")
    public WebElement createBadge;

    @FindBy(xpath = "//input[contains(@placeholder,'Badge Title')]")
    public WebElement badgeTitleBox;

    @FindBy(xpath = "//a[@class='button button_lg orange mar_l10 save_content'][contains(.,'Save')]")
    public WebElement saveBadgeTitle;

    @FindBy(xpath = "//i[contains(@class,'ico_levels_badge_exam')]")
    public WebElement badgeQuestionsPage;

    @FindBy(id = "add_badge_question")
    public WebElement badgeAddQuestionButton;

    @FindBy(xpath = "(//a[@class='lms_add_popup_global_question'][contains(.,'True/False')])[2]")
    public WebElement selectTrueFalseQuestionInBadge;

    @FindBy(id = "questionTotalPoints")
    public WebElement questionTotalPointsBadge;

    @FindBy(xpath = "//div[@id = 'cke_113_contents']//iframe")
    public WebElement badgeTrueorFalseQuestionFrame;

    @FindBy(xpath = "(//a[@href='javascript:;'][contains(.,'Automation Badge')])[1]")
    public WebElement badgeInAppAuthor;

    @FindBy(xpath = "//a[@class='button orange f_right edit_overview '][contains(.,'Edit')]")
    public WebElement editOverViewInBadge;

    @FindBy(xpath = "//div[@id = 'cke_200_contents']//iframe")
    public WebElement aboutBadgeIframe;

    @FindBy(xpath = "//a[@rel='save'][contains(.,'Save')]")
    public WebElement saveAboutBadge;

    @FindBy(xpath = "//a[contains(@rel,'progressApp')]")
    public WebElement inProgressTab;

    @FindBy(xpath = "(//a[contains(.,'Automation Badge')])[1]")
    public WebElement clickBadge;

    @FindBy(id = "submitAnswer")
    public WebElement submitOnBadgeQuestion;
}
