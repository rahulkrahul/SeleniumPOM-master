/**
 * https://www.youtube.com/watch?v=55ZxPTqscxI
 * Part21-Selenium with Java Tutorial | Practical Interview Questions and Answers | Dynamic Web Table
 */
package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicWebTablePagination {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        WebElement username =driver.findElement(By.id("input-username"));
        WebElement password = driver.findElement(By.id("input-password"));
        username.clear();
        password.clear();
        username.sendKeys("demo");
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Sales - Order
        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

        //Table:find total number of pages
        String pageCount= driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        System.out.println(pageCount);

        int total_pages = Integer.valueOf(pageCount.substring(pageCount.indexOf("(")+1,pageCount.indexOf("Pages")-1));
        System.out.println("Total number of pages: "+total_pages);

       // for(int i =0;i<=total_pages;i++){ //it takes time to iterate 500 pages
        for(int i =1;i<=3;i++){ //hard coding to 3 for faster execution

                WebElement active = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
                System.out.println("Active page:"+active.getText());
                active.click();

                int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
                System.out.println("Number of rows:"+ rows);

                //Read all the pages data
                for(int r=1;r<=rows;r++){
                    String orderId= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody  /tr["+r+"]//td[2]")).getText();
                    String customer= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]//td[3]")).getText();
                    String status= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();

                    if(status.contains("Pending"))
                        System.out.println(orderId+"    "+customer+"      "+status);

                }

                //Click on next page number - convert page number to string and pass in xpath.
                String pageno=Integer.toString(i+1);
                // driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='2']")).click();  //hard coding page number
                driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+pageno+"']")).click();

            }
        }
}

