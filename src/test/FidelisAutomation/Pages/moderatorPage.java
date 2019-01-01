package FidelisAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class moderatorPage {

    WebDriver driver;

    public moderatorPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(id ="numberOfRecords")
    public WebElement countOntheTop;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    public WebElement searchBox;

    @FindBy(xpath = "//img[contains(@alt,'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//a[contains(.,'Smoke Student')]")//change and make configurable
    public WebElement selectStudenttoModerate;

    @FindBy(xpath = "//input[contains(@value,'0')]")
    public WebElement enterGrade;

    @FindBy(xpath = "//a[@name='submitGrades'][contains(.,'Save')]")
    public WebElement saveGrades;

    @FindBy(xpath = "//a[contains(@class,'f_right backLink')]")
    public WebElement closeDetailView;

    @FindBy(id="submit_all_grades")
    public WebElement submitAllGradesButton;
}
