package Practice.Day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q02 extends TestBase {

    /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */

    @Test
    public void test() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //go into iframe
        driver.switchTo().frame("emoojis");

        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        //Click all the "Animals and Nature"  emoji elements

        List<WebElement> allEmojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement w: allEmojis){

            w.click();
        }

        //using lambda is recommended for above task

        //allEmojis.stream().forEach(t->t.click());
       // simpler :  allEmojis.forEach(WebElement::click);

        //Fill the form

        //go out of iframe
        driver.switchTo().defaultContent();

        List<WebElement> allInputs = driver.findElements(By.xpath("//input"));

        List<String> allWords =
                new ArrayList<>(Arrays.asList("Ezgi","Smile","fun","orange","joy","cat","muffin",",","a","b","c"));

        for (int i=0; i<allInputs.size();i++){
            allInputs.get(i).sendKeys(allWords.get(i));
        }

        //press apply button
        driver.findElement(By.id("send")).click();

        //Verify "code" element is displayed

        WebElement text = driver.findElement(By.id("code"));
        Assert.assertTrue(text.isDisplayed());
    }
}
