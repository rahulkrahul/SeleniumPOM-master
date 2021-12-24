/***
 * https://www.toolsqa.com/selenium-webdriver/actions-class-in-selenium/
 * Methods Available in Selenium Actions Class:
 * Keyboard Events Using Selenium Actions Class API:
 *
 * The Keyboard interface has the below mentioned methods:
 *
 * sendKeys(keysToSend) : sends a series of keystrokes onto the element
 * keyDown(theKey) : Sends a key press without release it. Subsequent actions may assume it as pressed. (example: Keys.ALT, Keys.SHIFT, or Keys.CONTROL)
 * keyUp(theKey): Performs a key release
 *
 * Mouse Events Using Selenium Actions Class API:
 * click (): Simply click on element
 * doubleClick (): Double clicks onElement
 * contextClick() : Performs a context-click (right click) on an element
 * clickAndHold(): Clicks at the present mouse location (without releasing)
 * dragAndDrop(source, target): Invokes click-and-hold at the source location and moves to the location of the target element before releasing the mouse. source – element to grab, target – element to release
 * dragAndDropBy(source, xOffset, yOffset) : Performs click-and-hold at the source location, shifts by a given offset, then frees the mouse. xOffset – to shift horizontally, yOffset – to shift vertically
 * moveByOffset(x-offset, y-offset): Shifts the mouse from its current position (or 0,0) by the given offset. x-offset – Sets the horizontal offset (negative value – shifting the mouse to the left), y-offset – Sets the vertical offset (negative value – shifting the mouse to the up)
 * moveToElement(toElement): It shifts the mouse to the center of the element
 * release(): Releases the depressed left mouse button at the existing mouse location
 */
package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass {

    @Test
    public void doubleClick() throws InterruptedException{

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        //Open the required URL where you could do double click action
        driver.get("http://api.jquery.com/dblclick/");
        //Maximize the browser
        driver.manage().window().maximize();
        //As per the above URL we need to switch to frame. The targeted element is in the frame
        driver.switchTo().frame(0);
        //Create the object 'action'
        Actions action = new Actions(driver);
        //Find the targeted element
        WebElement ele = driver.findElement(By.cssSelector("html>body>div"));
        //Here I used JavascriptExecutor interface to scroll down to the targeted element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
        //used doubleClick(element) method to do double click action
        action.doubleClick(ele).build().perform();
        //Once clicked on the element, the color of element is changed to yellow color from blue color
        //driver.close();
    }
}
