package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Accordion extends TestBase {
    @Test
    public void test() {

//        When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");

        waitFor(3);

//        And user clicks on Section2 accordion
        driver.findElement(By.xpath("//h3[@id='ui-id-3']")).click();

        waitFor(3);

//        Verify the text contains “Sed non urna.”
        String text = driver.findElement(By.xpath("//div[@id='ui-id-4']")).getText();
        Assert.assertTrue(text.contains("Sed non urna."));
    }
}
