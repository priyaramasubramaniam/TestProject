package testCases;

import PageObjects.DetailsPage;
import PageObjects.LawSuitsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    WebDriver driver;
    LawSuitsPage lawSuitsPage;
    DetailsPage detailsPage;
    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.accessibility.com/digital-lawsuits");
        lawSuitsPage = new LawSuitsPage(driver);
        lawSuitsPage.acceptCookie();
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }


    //Take Screenshot
    public static String getScreenshot(WebDriver driver, String filename) throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("./Screenshots/"+ filename +".png"));
        return filename;
    }
}
