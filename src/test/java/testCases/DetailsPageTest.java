package testCases;

import PageObjects.DetailsPage;
import org.testng.annotations.Test;

public class DetailsPageTest extends BaseClass {

    @Test
    public void testDetailsOfPlaintiffAndDefendent() throws InterruptedException {
        detailsPage = new DetailsPage(driver);
        detailsPage.getPlantiffAndDefendentNames();
    }
}
