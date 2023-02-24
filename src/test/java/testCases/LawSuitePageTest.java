package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LawSuitePageTest extends BaseClass {

    @Test
    public void getSizeofTheLink() throws IOException {
        //lawSuitsPage.acceptCookie();
        Assert.assertEquals(lawSuitsPage.getLinkSize(), 15);
        Assert.assertFalse(lawSuitsPage.getLinkSize()<0, getScreenshot(driver, "test-failed"));
    }


}
