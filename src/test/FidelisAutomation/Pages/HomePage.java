package FidelisAutomation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@omniture='App Store,App Store'][contains(@id,'goal')][contains(.,'Add Goal')]")
    public WebElement addGoalButton;

    @FindBy(xpath = "//span[@class='js-goals-current active'][contains(.,'Current')]")
    public WebElement Current;

    @FindBy(xpath = "//span[@class='js-goals-future active'][contains(.,'Future')]")
    public WebElement future;

    @FindBy(xpath = "//span[@class='js-goals-history active'][contains(.,'History')]")
    public WebElement history;

    @FindBy(xpath = "//a[@omniture='Activity,Activity'][contains(.,'Activity')]")
    public WebElement activity;

    @FindBy(xpath = "(//a[@href='javascript:;'])[28]")
    public WebElement goals;

    @FindBy(xpath = "//a[@omniture='Add Objectives,Objective'][contains(.,'Add')]")
    public WebElement addPurpose;

    @FindBy(xpath = "//a[@omniture='Agenda,Agenda'][contains(.,'Agenda')]")
    public WebElement calenderAgenda;

    @FindBy(xpath = "//a[contains(.,'Find Mentor')]")
    public WebElement findMentor;

    @FindBy(xpath = "//a[contains(.,'Find Mentee')]")
    public WebElement findMentee;

    @FindBy(xpath = "//div[@class='section_header_sm'][contains(.,'Communities')]")
    public WebElement communities;

    @FindBy(xpath = "//a[contains(.,'View other communities')]")
    public WebElement viewOtherCommunities;

    @FindBy(xpath = "(//a[@href='javascript:;'])[29]")
    public WebElement profile;

    @FindBy(xpath = "//a[@class='add_app'][contains(.,'Learning App')]")
    public WebElement addLearningApp;

    @FindBy(xpath = "//a[@class='add_badge'][contains(.,'Badge')]")
    public WebElement addBadge;

}
