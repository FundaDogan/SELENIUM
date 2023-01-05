package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Toggle extends TestBase {

    @Test
    public void test() {

        driver.get("https://jqueryui.com/toggle/");

        driver.switchTo().frame(0);
        String text = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println(text);

        driver.findElement(By.xpath("//button[@id='button']")).click();
        waitFor(3);

        String text2 = driver.findElement(By.xpath("//div[@id='effect']/p")).getText();
        System.out.println(text2);
        System.out.println("---------");

        waitFor(3);
        Assert.assertEquals("",text2);

        driver.findElement(By.xpath("//button[@id='button']")).click();

        String text3 = driver.findElement(By.xpath("//div[@id='effect']/p")).getText();
        System.out.println(text3);

//        When user goes to https://jqueryui.com/toggle/


//        Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
//        Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.

//    Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
//    Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.




//                Then click on Run Effect button



//        Then print the text and verify it is empty.
        // Eg: System.out.println(element); -> NO TEXT



        //        Then click on Run Effect button one more time



//        Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
//        Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
//        Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
//        Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.




//                You can use hard wait if needed.
    }
}
