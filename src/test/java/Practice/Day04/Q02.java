package Practice.Day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q02 extends TestBase {
    @Test
    public void test() {

//        Given
//        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

//        When
//        Click on "click me" button

        waitFor(5);
        driver.findElement(By.xpath("//button[.='Click Me']")).click();

//                Then
//        Verify that "Event Triggered"
        String text = driver.findElement(By.id("growbuttonstatus")).getText();
        Assert.assertEquals("Event Triggered",text);
    }
}
