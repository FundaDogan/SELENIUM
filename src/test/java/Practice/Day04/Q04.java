package Practice.Day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q04 extends TestBase {
    @Test
    public void test() {
//        Given
//        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        When
//        Click on File Downloads
        driver.findElement(By.id("download")).click();

//        And
//        Click on Server Download
        driver.findElement(By.id("server-download")).click();

//        Then
//        Verify that file is downloaded

        //Files.exists(Paths.get("C:\\Users\\funda\\Downloads\\textfile.txt"));  --> not dynamic

        String userHome = System.getProperty("user.home");
        boolean isExist = Files.exists(Paths.get(userHome+"\\Downloads\\textfile.txt"));
        Assert.assertTrue(isExist);
    }
}
