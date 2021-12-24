package Samples;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class FullPageScreenshot {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
       // WebDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.softwaretestingmaterial.com/category/tutorial/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void captureFullPageScreenshot() throws IOException {
        File src = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("FullPageScreenshot.png"));
    }

    @Test
    public void capturePageScreenshot() throws IOException {
        /*TakesScreenshot interface enables the Selenium WebDriver to take a screenshot and store it in different ways. "getScreenshotAs()" method captures the screenshot and store it in the specified location.*/
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("PageScreenshot.png"));
    }
}
