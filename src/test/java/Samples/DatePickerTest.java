package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class DatePickerTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.redbus.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //date picker
        driver.manage().window().maximize();

        String year = "2022";
        String month="Dec";
        String date="20";

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

        while(true) {
            String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
            System.out.println(monthYear);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            System.out.println(mon);
            System.out.println(yr);

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
                break;
            else
                driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
        }

           //Date selection

            List<WebElement> allElements = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

           for(WebElement ele: allElements)
           {
               String dt = ele.getText();
               System.out.println(dt);
               if(dt.equalsIgnoreCase(date))
               {
                   ele.click();
                   break;
               }
           }
    }
}
