package FidelisAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LearningAppMarketplace {

    WebDriver driver;

    public LearningAppMarketplace(WebDriver driver)
    {
        this.driver = driver;
    }

    public @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight ui-state-hover')]")
    WebElement clickDate;

    public @FindBy(xpath = "//a[contains(@class,'button grey button_med')]")
    WebElement addToPath;

    @FindBy(id = "searchBox")
    public WebElement searchApps;

    @FindBy(id = "app_store_add_a_goal")
    public WebElement addGoalfromLAM;

    @FindBy(id = "quickStart")
    public WebElement goToApp;

    @FindBy(className = "button_lg")
    public WebElement startButton;

    @FindBy(className = "next_page")
    public WebElement nextPage;

    @FindBy(xpath = "//input[contains(@value,'1')]")
    public WebElement selectTrue;

    @FindBy(className = "typed_response_textarea")
    public WebElement typedResponse;

    @FindBy(id = "finish_exam")
    public WebElement finishExam;

    @FindBy(className = "js-finish_app")
    public WebElement finishApp;

    @FindBy(id = "moduleOverviewNext" )
    public WebElement moduleNext;

    @FindBy(id = "startApp")
    public WebElement startBadgeAssessment;
}

