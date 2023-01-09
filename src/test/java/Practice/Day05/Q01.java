package Practice.Day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {
    @Test
    public void Q01() {

//    Given
//        Go to https://testpages.herokuapp.com/styled/tag/table.html
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
//    When
//        Calculate the total amount on the table
        List<WebElement> amounts = driver.findElements(By.xpath("//tbody/tr/td[2]"));  //tbody//td[2] de olur.

        double sum =0;

        for (WebElement w: amounts){

            sum= sum + Double.parseDouble(w.getText());
        }
        System.out.println(sum);

 // difference between parse and value methods is parse returns primitive data, value returns wrapper class

//    Then
//        Assert the amount
        Assert.assertTrue(110.3==sum);

        // assert equal expected ve actual datayi string ister , bizimki double old icin assert true ile yaptik

    }
}
