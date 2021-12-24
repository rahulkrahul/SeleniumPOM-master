/***
 * https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
 * A window is a webpage that will open when a user hits a URL. There are two types of windows in the Selenium - parent window and its child windows.
 * The window handle is a unique identifier that stores the values of windows opened on a webpage and helps in window handling in Selenium.
 * getWindowHandles( ) and getWindowHandles( ) handle windows in Selenium.
 * The user has to switch from the parent window to the child window to work on them using switchTo( ) method.
 * To close windows two methods exist driver.close( ) and driver.quit( ).
 */
package Samples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.util.Iterator;
        import java.util.Set;

public class switchbackParentWinow {
    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
        //WebDriver driver = new ChromeDriver();
         Logger logger = LogManager.getLogger(switchbackParentWinow.class);

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("windowButton")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();


        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
    }
}
