/**
 * https://www.toolsqa.com/selenium-webdriver/drag-and-drop-in-selenium/
 */
package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class ActionClassDragDropTest {

    @Test
    public void actionDragAndDrop() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Note: Following statement is required since Selenium 3.0,
        //optional till Selenium 2.0
        //Set system properties for geckodriver
        // System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Toolsqa\\lib\\geckodriver.exe");

        // WebDriver driver = new FirefoxDriver();

        String URL = "https://demoqa.com/droppable/";

        driver.get(URL);

        // It is always advisable to Maximize the window before performing DragNDrop action
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();
    }

    @Test
    public void actionsClass() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:\\Selenium Environment\\Drivers\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Create an object 'action'
        Actions action = new Actions(driver);
        //navigate to the required url where we could do drag and drop action
        driver.get("http://jqueryui.com/droppable/");
        //WebdriverWait is used to wait for a frame to be available. Once it is availble we switch to the frame to achieve our task
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
        //To get source locator
        WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
        //To get target locator
        WebElement targetLocator = driver.findElement(By.cssSelector("#droppable"));
        //dragAndDrop(source, target) method accepts two parameters source and locator.
        //used dragAndDrop method to drag and drop the source locator to target locator
        action.dragAndDrop(sourceLocator, targetLocator).build().perform();
    }


}

