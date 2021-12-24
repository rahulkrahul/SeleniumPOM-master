package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StaleElmnt{
        public static void main(String[] args) {

            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //System.setProperty("webdriver.chrome.driver",
                //    "C:\\Users\\ghs6kor\\Desktop\\Java\\chromedriver.exe");
            //WebDriver driver = new ChromeDriver();

           // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
            // identify element
            WebElement l = driver.findElement(By.id("gsc−i−id1"));
            l.sendKeys("Selenium");
            //refresh page
            driver.navigate().refresh();
            l.sendKeys("Selenium");
            driver.quit();
        }
    }