package tests;

import org.junit.Test;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

    @Test
    public void takeScreenShotTest() throws IOException {
//        Given user search for ‘uni’
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//      TAKE A SCREENSHOT. CREATE A REUSABLE METHOD AND CALL THAT METHOD

        takeScreenshotOfPage();

        //COMPLETE AS HOMEWORK
//        And select United Kingdom

//        TAKE SCREENSHOT

//        Add click on submit button
//        TAKE SCREENSHOT
//        Then verify the result contains united Kingdom
//        TAKE SCREENSHOT
    }
}
