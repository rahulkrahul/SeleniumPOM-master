package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class svg {
    public static void main(String[] args) {


    WebDriver driver;
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.flipkart.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    if(driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).isDisplayed())
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
    else
        System.out.println("x not displayed");


    driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Apple");
    //svg syntax
    driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
    //    driver.findElement(By.xpath("\n" +
      //          "//*[local-name()='svg']//*[local-name()='g' and @fill-rule='evenodd']")).click();




    }
}
