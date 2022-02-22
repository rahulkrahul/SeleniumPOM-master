//https://www.youtube.com/watch?v=Gqc8Rq3KdPM
//https://github.com/naveenanimation20/ShadowDOMHandle/blob/master/src/main/java/GoogleDownloadSearch.java
//shadow dom can be automated with Javscript executor and css
//shadow root element should be open
//Right click copy element - JS script another way
//Manual process: console: document.querySelector

package Samples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleDownloadSearch {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("chrome://downloads/");

        JavascriptExecutor jse = (JavascriptExecutor)driver; //convert the driver to JavascriptExecutor
        //convert the jse to WebElement and pass the js path
        WebElement search =  (WebElement) jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar#toolbar').shadowRoot.querySelector('cr-toolbar#toolbar').shadowRoot.querySelector('cr-toolbar-search-field#search').shadowRoot.querySelector('div#searchTerm > input#searchInput')");

        String js = "arguments[0].setAttribute('value', 'NaveenAutomationLabs')"; //set the attribute value and pass to execute the script
        ((JavascriptExecutor)driver).executeScript(js, search);

    }

}