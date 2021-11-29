//https://www.softwaretestingmaterial.com/highlight-element-using-selenium/

package Samples;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.Test;

public class HighlightTest {
    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver", "D:\\Selenium Environment\\Drivers\\geckodriver.exe");
        //Instantiating driver object
        //WebDriver driver = new FirefoxDriver();

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //To launch gmail.com
        driver.get("https://www.gmail.com");
        //Collects the webelement
        WebElement ele = driver.findElement(By.xpath("//*[@id='identifierId']"));
        //Create object of a JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
    }
}
