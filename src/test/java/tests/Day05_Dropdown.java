package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day05_Dropdown {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {
//    select Option 1 by index from the dropdown
//        1. locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. Create Select object cause dropdown is in the select tag. this is for only dropdowns
        Select select = new Select(dropdown);
//        3. Select any option using the select object
        select.selectByIndex(1);

    }


    //2.Create method selectByVisibleTextTest Select Option 2 by visible text

        @Test
        public void selectByVisibleTextTest(){
            WebElement dropdown = driver.findElement(By.id("dropdown"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Option 2");
        }


        //3.Create method selectByValueTest Select Option 1 value by value

    @Test
    public void selectByValueTest() throws InterruptedException {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(3000);// hard wait. will wait 3 sn

        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
    }


        //4.Create method printAllTest and  Print all dropdown values

    @Test
    public void printAllTest(){

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        //getOptions(); returns all dropdown values

        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption : allOptions){

//            getText() returns the TEXT of the webelements as STRING
            System.out.println(eachOption.getText());
        }

//    5. Verify the dropdown has Option 2 text

        boolean isOption2Exist=false;

        for (WebElement eachOption : allOptions){

            if (eachOption.getText().equals("Option 2")){

                isOption2Exist=true;
            }
        }

//        fails if Option 2 is not in the dropdown
//        pass if Option 2 is in the dropdown

        Assert.assertTrue(isOption2Exist);
    }


    //6.Create method printFirstSelectedOptionTest and Print first selected option

    @Test
    public void printFirstSelectedOptionTest() {

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdown);

//        printing the selected option

        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());

        // getFirstSelectedOption() returns whatever option is selected

//        selecting a different option from the dropdown

        select.selectByIndex(2);

//        printing the selected option

        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());// displays option2 because ,it is selected


        //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

        int numberOfOptions = select.getOptions().size();

        int expectedNumberOfOptions = 3;

//        Assertion will print Expected Is Not Equal Actual ONLY IF THIS ASSERTION FAILS

        Assert.assertEquals("Expected Is Not Equal Actual", expectedNumberOfOptions, numberOfOptions);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}