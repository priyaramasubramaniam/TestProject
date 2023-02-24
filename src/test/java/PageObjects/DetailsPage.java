package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {

    WebDriver driver;
    LawSuitsPage lp;
    public DetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "plaintiff_content")
    WebElement plantiffEle;

    @FindBy(className = "defendant_block")
    WebElement defendentEle;


    public void getPlantiffAndDefendentNames() throws InterruptedException {
        int i = 0;
        lp = new LawSuitsPage(driver);
        while (i<lp.links.size())
        {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", lp.links.get(i));
                Thread.sleep(2000);
                lp.links.get(i).click();
                System.out.println("-----------Plaintiff Information ------- ");
                System.out.println(plantiffEle.getText());
                System.out.println("-----------Defendent Information -------");
                System.out.println(defendentEle.getText());
                driver.navigate().back();
                i++;

            }
            catch (StaleElementReferenceException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public void checkPlaintiffName() throws InterruptedException {
        int i = 0;
        lp = new LawSuitsPage(driver);
        while (i < lp.links.size()) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", lp.links.get(i));
                Thread.sleep(2000);
                lp.links.get(i).click();

            }catch (StaleElementReferenceException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
