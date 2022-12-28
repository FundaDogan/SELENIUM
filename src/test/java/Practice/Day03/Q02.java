package Practice.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q02 extends TestBase {

    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Select the file to upload
    And
        Click "Choose File" button
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("My File");

        Thread.sleep(3000);

        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "/Desktop/file.txt";

        driver.findElement(By.name("upfile")).sendKeys(pathOfFile);

        driver.findElement(By.xpath("//input[@value='Press']")).click();

        String note = driver.findElement(By.xpath("//blockquote")).getText();
        Assert.assertEquals("My File",note);

        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        Assert.assertTrue(fileContent.contains("Hello, I am uploaded file"));

    }
}
