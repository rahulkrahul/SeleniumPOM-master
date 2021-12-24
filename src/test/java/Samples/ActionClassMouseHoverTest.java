package Samples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionClassMouseHoverTest {

    @Test
    public void actionsClassMouseHover(){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Launch the URL
        driver.get("https://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Adding wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //a[normalize-space()='Main Item 2']

        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

        //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
        WebElement subMenuOption = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
        //Mouse hover menuOption 'Rock'
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'SUB SUB LIST »' from Menu");

        //Now , finally, it displays the desired menu list from which required option needs to be selected
        //Now Select 'Alternative' from sub menu which has got displayed on mouse hover of 'Rock'
        WebElement selectMenuOption = driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 1']"));
        selectMenuOption.click();
        System.out.println("Selected 'Sub Sub Item 1' from Menu");

        // Close the main window
        driver.close();

    }
        @Test(enabled = false)
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