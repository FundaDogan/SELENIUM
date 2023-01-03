package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown(){
//
//        driver.quit();
//    }


//       AUTO COMPLETE REUSABLE METHOD

//    THIS CODE IS USED FOR SELECTING AND VERIFYING OUR APP AUTO COMPLETE SEARCH FUNCTIONALITY
    //day 10 auto complete question.

//    NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS,
//    BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT

//    NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT

    //    THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS


    public static void searchAndSelectFromList(String keyword, String textFromList){

     // sending a keyword dynamically using parameter 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);

//   selecting an option from the list Dynamically using parameter 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+textFromList+"']")).click();

 // click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

// verify using parameter 2
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains(textFromList));

    }

    //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD

    public void takeScreenshotOfPage() throws IOException {

//        1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium

        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//        2. Save the screenshot in a path and Save with dynamic name
//        2. Creating a PATH and dynamic name for the image
        //getting the current local date and time
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // path is where we save the screenshot. PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";//Where we save the image


        //3. Saving the IMAGE in the PATH
        FileUtils.copyFile(image, new File(path));

    }



        //    TAKE SCREENSHOT OF SPECIFIC ELEMENT

    public void takeScreenshotOfTheElement(WebElement element) throws IOException {

//        1. take screenshot

        File image = element.getScreenshotAs(OutputType.FILE);

//        2. Creating a PATH and dynamic name for the image

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time

//        path is where we save the screenshot. PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png

        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";//Where we save the image

//        3. Saving the IMAGE in the PATH

        FileUtils.copyFile(image, new File(path));

    }


/*   HARD WAIT:
     @param : second
 */

    public static void waitFor(int seconds ){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*
        JAVASCRIPT EXECUTOR
        @param WebElement
        Accepts a web element and scrolls into that element
        We may need to scroll for capturing the screenshots property
        We may need to scroll to specific elements with js executor
        because some elements may not LOAD properly
        unless we scroll to that elements
    */

    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }


    /*
   scroll the page all the way down
    */
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


    /*
    scroll the page all the way up
     */
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    /*
        click on an element
        @param WebElement
        Normally we use element.click() method in selenium
        When there is an issue with click()-hidden, different UI, ...
        Then we can use javascript click that works better
         */

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }



    /*
        @param : WebElement, String
        Types the string in the WebElement

        element.sendKeys("text") to type in an input
        ALTERNATIVELY we can use use js executor to type in an input
        arguments[0].setAttribute('value','admin123');  -> SAME AS element.sendKeys("admin123")

        INTERVIEW QUESTION : What are the selenium methods that you use to type in an input?
        - sendKeys()
        - with javascript executor we can change the value of the input
         */

    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }



    /*
    param : id of the element
     */

    public void getValueByJS(String idOfElement){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);

         /*
        if it is a normal text I use getText() with selenium. But if the text is an input value,such as default
        values in a box- caretta website check-in check out values, I cannot use it.
        to get these kind of values, which seems text, we use JSexecuter.

        Day13 Js executer class ta metodu cagirdik ve run edince tarihleri getirdi. git bak
        bunun html kodum]nda value attribute u var onun degerini getiriyor.

        html kodundaki text ile value='ayse' farkli seyler, value attribute degeri de ayse.

        Bu metodta getElementById() kullaniliyor, eger webelement te id yoksa bu metodu kullanamam.

        jsexecuter da xpath kullanark ta elemani getirebilirdi ama komplike gerek yok dedi.

         */

//        How you get the value of an input box?
//        We can use js executor.
//        How?
//        I can get the element using js executor, and get the value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input

        //We are able to get the default value of the Check-in Check-out box
//      This is one of the limitations of the selenium because normally, we cannot get the value of an
//      attribute  with selenium

    }



    //    Changes the changeBackgroundColorByJS of an element.
    //    Params: WebElement element, String color.
    //    NOT COMMON ,  it is used to change background color.sometimes we may need to highlight an element
    //  for this we may need it.

    public void changeBackgroundColorByJS(WebElement element, String color){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }


    //    NOT COMMON
    public void addBorderWithJS(WebElement element, String borderStyle){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }

}