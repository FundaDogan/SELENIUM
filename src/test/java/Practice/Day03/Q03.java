package Practice.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q03 extends TestBase {

    @Test
    public void name() {

//Given
        //Go to http://the-internet.herokuapp.com/add_remove_elements/

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //When
        // Click on the "Add Element" button 100 times

        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));

        for (int i=1; i<101; i++){
            addElement.click();
        }

        //And
        //Click on the "Delete" button 20 times


        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']"));

        for (int i=1; i<21;i++){
            deleteButton.click();
        }


        //Then
        //Assert that 20 buttons were deleted.

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println(deleteButtons.size());

        Assert.assertEquals(80,deleteButtons.size());

    }
}