package InterviewSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableRowColumn {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        getRowColNumber("Austria");
        System.out.println(getRowColNumber("Austria"));

    }

    public static boolean getRowColNumber(String name){
        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
        System.out.println(rowCount);
        System.out.println(colCount);
        boolean flag = false;
        for(int i=1;i<rowCount;i++){
            for(int j=1;j<=colCount;j++){
                String data= driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
                System.out.println(data);
                if(data.equals("Austria")) {
                    flag=true;
                    System.out.println("Austria is displayed at row and column" + i + "," + j);
                    break;
                }
            }
        }
        if(flag) {
            return true;
        }
        return flag;
    }
}
