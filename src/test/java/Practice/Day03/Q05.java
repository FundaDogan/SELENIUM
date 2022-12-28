package Practice.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q05 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        /*
    Given
        Go to http://webdriveruniversity.com/To-Do-List/index.html
    When
        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
    And
        Strikethrough all todos.
    And
        Delete all todos.
    Then
        Assert that all todos deleted.
        */

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        WebElement addToDo= driver.findElement(By.xpath("//input[@type='text']"));
        addToDo.sendKeys("Prepare breakfast"+ Keys.ENTER);
        addToDo.sendKeys("Wash the dishes"+ Keys.ENTER);
        addToDo.sendKeys("Take care of baby"+ Keys.ENTER);
        addToDo.sendKeys("Help your kid's homework"+ Keys.ENTER);
        addToDo.sendKeys("Study Selenium"+ Keys.ENTER);
        addToDo.sendKeys("Sleep"+ Keys.ENTER);

        Thread.sleep(3000);

        /*
        //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)

        List<String> todosToAdd = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        WebElement addTodo = driver.findElement(By.xpath("//input[@type='text']"));

        Actions actions = new Actions(driver);
        for (String w : todosToAdd) {
            actions.
                    click(addTodo).
                    sendKeys(w).
                    sendKeys(Keys.ENTER).
                    perform();


        //Strikethrough all todos

        Thread.sleep(2000);
        List<WebElement> allTodos = driver.findElements(By.xpath("//li"));
        for (WebElement w : allTodos) {
            w.click();
        }

         */

        List<WebElement> toDos= driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        for (WebElement w:toDos){
            w.click();
        }

        Thread.sleep(2000);
        List<WebElement> allTodosAfterDelete =  driver.findElements(By.xpath("//li"));
        Assert.assertEquals(0, allTodosAfterDelete.size());

    }
}
