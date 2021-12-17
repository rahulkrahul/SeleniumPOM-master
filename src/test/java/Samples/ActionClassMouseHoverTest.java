package Samples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassMouseHoverTest {

        @Test
        public void actionsClass() throws InterruptedException{
            //System.setProperty("webdriver.chrome.driver", "D:\\Selenium Environment\\Drivers\\chromedriver.exe");
            //creating an object 'driver'
            //WebDriver driver = new ChromeDriver();

            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.softwaretestingmaterial.com");

            //Main Menu
            WebElement mainMenu = driver.findElement(By.linkText("Tutorials"));
        //Create object 'action' of an Actions class
                    Actions actions = new Actions(driver);
        //To mouseover on main menu
                    actions.moveToElement(mainMenu);

        //Sub Menu
                    WebElement subMenu = driver.findElement(By.linkText("Postman"));
        //To mouseover on sub menu
                    actions.moveToElement(subMenu);
        //build() method is used to compile all the actions into a single step
                    actions.click().build().perform();
        }
    }