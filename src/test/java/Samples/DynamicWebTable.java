/***
 * https://www.youtube.com/watch?v=x0ofFlFbYxM
 * Handle dynamic webtables
 *  System.out.println("==============Interview question: check box Selenium===========");
 *
 *         driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input")).click();
 *
 *         Thread.sleep(5000);
 *         System.out.println("==============Interview question: click on Know more link for OLA===========");
 *         driver.findElement(By.xpath("//td[text()='Ola']//following-sibling::td[3]//a")).click();
 */
package Samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable {

    @Test
    public void verifyTableHeaders() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='customers']//th"));

        System.out.println(allHeaders.size());  // Get Headers

        Assert.assertEquals(allHeaders.size(),5,"Column count is not same");

        Boolean status=false;

        //Normal for loop
        for(int i=0;i<allHeaders.size();i++){
            WebElement element= allHeaders.get(i);
            String value= element.getText();
            if(value.contains("Company")){
                status=true;
                break;
            }
        }
        Assert.assertTrue(status,"Header is not present");

        //for each loop
        for(WebElement ele:allHeaders){
            String value = ele.getText();
            System.out.println(value);
            if(value.contains("Company")){
                status=true;
                break;
            }
        }
        Assert.assertTrue(status,"Header is not present");

        System.out.println("==============TR: ROWS===========");
        //Get rows
        List<WebElement> allrows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        System.out.println("All rows:"+ allrows);
        Assert.assertEquals(allrows.size(),7,"Row count not matching");

        System.out.println("==============TD: DATA===========");

        //Get rows
        List<WebElement> allcols = driver.findElements(By.xpath("//table[@id='customers']//td"));
        System.out.println("All cols:"+ allcols);
      //  Assert.assertEquals(allcols.size(),5,"Column count not matching");

        Boolean dataStatus=false;

        for(WebElement ele:allcols){
            String value =ele.getText();
            if(value.contains("Ola")){
                dataStatus=true;
                break;
            }
        }
        Assert.assertTrue(dataStatus,"Data not displayed");

        System.out.println("==============TD: DATA second column===========");

        //Get rows
        List<WebElement> companyNames = driver.findElements(By.xpath("//table[contains(@id,'customers')]//tr//td[2]"));
        System.out.println("companyNames:"+ companyNames);
        //  Assert.assertEquals(allcols.size(),5,"Column count not matching");

        Boolean dataStat=false;

        for(WebElement ele:companyNames){
            String value =ele.getText();
            if(value.contains("Ola")){
                dataStat=true;
                break;
            }
        }
        Assert.assertTrue(dataStat,"company Name/record not not displayed");

        System.out.println("==============Interview question: check box Selenium===========");

        driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input")).click();

        Thread.sleep(5000);
        System.out.println("==============Interview question: click on Know more link for OLA===========");
        driver.findElement(By.xpath("//td[text()='Ola']//following-sibling::td[3]//a")).click();

        //driver.quit();

    }
}
