/**
 * https://www.toolsqa.com/selenium-webdriver/keyboard-events-in-selenium/
 */
package Samples;


import static junit.framework.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsKeyboardCopyPaste {

    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables
        //WebDriver driver=new ChromeDriver();

 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");

        //Create object of the Actions class
        Actions actions = new Actions(driver);

        /*
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("a");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();

        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("c");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();


        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        //Press the TAB Key to Switch Focus to Permanent Address
        //currentAddress.sendKeys(Keys.TAB);

        //Paste the Address in the Permanent Address field
        //WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));

        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("v");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();

*/

        // Select the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        // Copy the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        //Paste the Address in the Permanent Address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));

        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));

        driver.close();

    }
}