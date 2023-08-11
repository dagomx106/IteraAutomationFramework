package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TestItera {
    
    @Test
    void test() throws InterruptedException, MalformedURLException {
        //WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.215.2:4444"),chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions ac = new Actions(driver);
        WebElement drop = driver.findElement(By.xpath("//select[@class='custom-select']"));

        //js.executeScript("arguments[0].scrollIntoView();",drop);
        ac.scrollToElement(drop);
        //drop.click();
        Thread.sleep(4000);

        Select select = new Select(drop);
        select.selectByValue("8");
        Thread.sleep(4000);
        select.selectByVisibleText("Spain");
        Thread.sleep(4000);
        select.selectByIndex(5);
        Thread.sleep(4000);

        List<WebElement> options = select.getOptions();
        for (WebElement e:options){
            System.out.println(e.getText());
        }
        Thread.sleep(2000);


        //Scroll down till the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//label[@for='4years']")).click();
        ////label[contains(@for,"4years")]
        //label[contains(@for,"selenium")]
        Thread.sleep(2000);




        driver.quit();

    }
    
    
}