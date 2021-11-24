//download WebDriverManager from https://jar-download.com/artifacts/io.github.bonigarcia/webdrivermanager
//download the WebDriverMangager and unzip right click on Project->open module->libraries->attach the libraries
/***
 *automates the management of WebDriver binaries.
 *         downloads the appropriate driver binaries, if not already present, into the local cache.
 *         downloads the latest version of the browser binary, unless otherwise specified.
 *       22  Eliminates the need to store driver binaries locally. We also need not maintain various versions of the binary driver files for different browsers.
 */


package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pagelinks {
    public static void main(String[] args) {
        try {


            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://www.amazon.com/");
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            for (int i = 0; i < links.size(); i++) {
                System.out.println(links.get(i).getText());
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Amazon Prime")));
                if (links.get(i).getText().equals("Amazon Prime")) {
                    links.get(i).click();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
package samples;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class TestingPortal {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            driver.get("https://pro-qa.opensalon.co/#/");
            driver.findElement(By.id("userName")).sendKeys("regis.1");
            driver.findElement(By.id("userPassword")).sendKeys("athena");
            driver.findElement(By.id("btnLogin")).click();
            // WebElement title=driver.findElement(By.)
            // driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            //WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            // System.out.println(firstResult.getAttribute("textContent"));
        } finally {
            //  driver.quit();
        }
    }
}

 */

