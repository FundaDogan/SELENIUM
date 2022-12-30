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
/*
    //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD

    public void takeScreenshotOfPage() throws IOException {

//        1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium

        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        2. Save the screenshot in a path and Save with dynamic name
//        2. Creating a PATH and dynamic name for the image
        //getting the current local date and time
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//Where we save the image

        // path is where we save the screenshot. PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+".png";
        FileUtils.copyFile(image,new File(path));

 */

        //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
        public void takeScreenshotOfPage() throws IOException {
//        1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
            File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        2. Creating a PATH and dynamic name for the image
            String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
//        path is where we save the screenshot. PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png
            String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image

//        3. Saving the IMAGE in the PATH
            FileUtils.copyFile(image,new File(path));
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
}