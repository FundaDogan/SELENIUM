package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutTest(){

        driver.get("https://techproeducation.com/");

//        Trying to locate the element using Explicit wait
//        We get timeout exception because explicit wait could not handle the issue.
        waitForVisibility(By.id("wrong-id"),15);  //org.openqa.selenium.TimeoutException:

        /*
        Locator is wrong in here, but we got time out exception. The reason is I gave time with explicit wait
        but within that time driver could not find the element that's why it throw time out exception.
         */

    }
}
