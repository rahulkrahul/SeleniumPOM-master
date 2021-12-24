/***
 * https://www.toolsqa.com/selenium-webdriver/alerts-in-selenium/
 * Alerts are small popup windows that display the message/notifications and notify the user with some information or may ask for permission on certain kinds of operation.
 * There are two types of alerts: Web/Javascript/browser-based alerts and Windows/OS-based alerts in Selenium. Web-based alerts can further bifurcate into Simple alerts, Prompt alerts, and confirmation alerts.
 * These alerts are significantly visible in online application forms, banking websites, and social networking/Email service provider websites like Gmail. Every QA must have encountered such alerts while automating the application under test.
 */
package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class alerts {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","./src/resources/chromedriver");
        Logger logger = LogManager.getLogger(alerts.class);

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);


        try {
            driver.findElement(By.id("timerAlertButton")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        driver.quit();
     /***
        // This step will result in an alert on screen

        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();
      */
    }
}

