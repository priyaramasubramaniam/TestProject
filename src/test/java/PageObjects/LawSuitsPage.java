package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LawSuitsPage {

      WebDriver driver;

      public LawSuitsPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
      }

      @FindBy(linkText = "Accept")
      WebElement cookie;

      @FindBy(xpath = "//div[@class = 'post-item ']//a")
      List<WebElement> links;

      public void acceptCookie()
      {
            cookie.click();
      }

      public int getLinkSize() {
            int size = links.size();
            return size;
      }

      public DetailsPage clickLink()
      {
            for(WebElement link:links)
            {
                  link.click();
            }
            return new DetailsPage(driver);
      }

}


