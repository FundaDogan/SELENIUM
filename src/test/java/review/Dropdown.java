package review;

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

public class Dropdown {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() throws InterruptedException {

        //Go to https://the-internet.herokuapp.com/dropdown

        //1.Create method selectByIndexTest and Select Option 1 using index

        // 1.locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // 2.create a select object
        Select select = new Select(dropdown);  // select will be imported from selenium not apache

        // 3. select any option using by index ===> index start with 0
        Thread.sleep(3000);

        select.selectByIndex(1);

        Thread.sleep(2000);


        //2. Select Option 2 by value

        select.selectByValue("2"); //2. option'in value 2

        Thread.sleep(2000);


        //3. Select Option 1 value by visible text

        select.selectByVisibleText("Option 1");

    }


    //4.Create method printAllTest and Print all dropdown values

    @Test
    public void printAllTest() {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        List<WebElement> allOptions = select.getOptions();

        for (WebElement w : allOptions) {

            System.out.println(w.getText());
        }

        //5. Verify the dropdown has Option 2 text

        boolean flag = false;

        for (WebElement w : allOptions) {

            if (w.getText().equals("Option 2")) {

                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }


    //6.Create method printFirstSelectedOptionTest and Print first selected option
    @Test
    public void printFirstSelectedOptionTest() {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        WebElement firstOption = select.getFirstSelectedOption();// secili optioni verir.
        System.out.println(firstOption.getText());

        //getAllSelectedOption() birden fazla eleman secilebiliyorsa secili olanlarin hepsini verir

        //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there
        //are not 3 elements in the dropdown.

        int numOfOptions = select.getOptions().size();

        int expectedNumOfOptions = 3;

        Assert.assertEquals("Expected Is Not Equal Actual",expectedNumOfOptions,numOfOptions);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    }
