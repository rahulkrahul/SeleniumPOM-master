package Samples;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.interactions.Actions;

public class ActionsDoubleClick {

    public static void main(String[] args) {

        //Note: Following statement is required since Selenium 3.0,
        //optional till Selenium 2.0
        //Set system properties for geckodriver
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Toolsqa\\lib\\geckodriver.exe");

        // Create a new instance of the Firefox driver
        //WebDriver driver = new FirefoxDriver();

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        // Launch the URL
        driver.get("https://demoqa.com/buttons");
        System.out.println("Demoqa Web Page Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform double click WebElement
        WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

        //Double Click the button
        actions.doubleClick(btnElement).perform();

        System.out.println("Button is double clicked");

        //Following code just click on OK button on alert , this differs
        //depending upon application(under test) specific test case
        // Accept the Alert
        driver.switchTo().alert().accept();
        System.out.println("Double click Alert Accepted");

        //Close the main window
        driver.close();
    }
}