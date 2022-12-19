package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

public class AmazonDropDown extends TestBase {

//    Create A Class: AmazonDropdown
//    Create A Method dropdownTest

    @Test
    public void dropDownTest(){

        //    Go to https://www.amazon.com/

        driver.get("https://www.amazon.com/");

//    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

//  Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
      String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);

        Assert.assertEquals("All Departments",firstOption);

        /* Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
         (after you select you need to use get first selected option method). If it fails, then comment
         that code out and continue rest of the test case.
          */
        select.selectByIndex(3);

        Assert.assertEquals("Baby",select.getFirstSelectedOption().getText());


//    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.

        List<WebElement> allOptions = select.getOptions();

        for (WebElement w: allOptions){
            System.out.println(w.getText());
        }

//    Print the the total number of options in the dropdown
        System.out.println(allOptions.size());

//    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.

        boolean flag = false;
        for (WebElement w: allOptions){
            if (w.getText().equals("Appliances")){
                flag=true;
            }
        }
        System.out.println(flag);

        //Assert.assertTrue(flag);

//            BONUS: Assert if the dropdown is in Alphabetical Order


    }

}
