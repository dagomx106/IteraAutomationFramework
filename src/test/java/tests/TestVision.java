package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class TestVision
{
    WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    //        chromeOptions.setCapability("se:recordVideo", true);
//        chromeOptions.setCapability("se:screenResolution", "1920x1080");
    EdgeOptions edgeOptions = new EdgeOptions();

    FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Test
    void test1() throws InterruptedException, IOException {

        String browser = Config.browser;

        if(browser.contains("chrome")) {
            chromeOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(new URL(Config.hub), chromeOptions);
            Set<String> opsC = chromeOptions.getCapabilityNames();
            for (String p : opsC) {
                System.out.println(p);
            }
        }
            //driver = new ChromeDriver();
        else if (browser.contains("edge")) {
             edgeOptions.setCapability("browserName","MicrosoftEdge");
            driver = new RemoteWebDriver(new URL(Config.hub), edgeOptions);
            Set<String> opsE = edgeOptions.getCapabilityNames();
            for (String p : opsE) {
                System.out.println(p);
            }
        } //driver = new EdgeDriver();
        else {
            firefoxOptions.setCapability("browserName","firefox");

            driver = new RemoteWebDriver(new URL(Config.hub), firefoxOptions);
            Set<String> opsF = firefoxOptions.getCapabilityNames();
            for (String p : opsF) {
                System.out.println(p);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get(Config.url);

        Actions actions = new Actions(driver);

        WebElement frm = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frm);

        driver.findElement(By.name("mytext1")).sendKeys("Test frame1");
        Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frm2);

        driver.findElement(By.name("mytext2")).sendKeys("Test frame2");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(frm4);

        driver.findElement(By.name("mytext4")).sendKeys("Test frame4");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frm3);
        driver.findElement(By.name("mytext3")).sendKeys("Frame 3 test");
        Shot.take(driver);
        Thread.sleep(2000);

        WebElement frm6 = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        driver.switchTo().frame(frm6);

        System.out.println(driver.findElement(By.xpath("//div[@class='cBGGJ OIC90c']")).getText());

        driver.findElement(By.xpath("//span[@class='aDTYNe snByac OvPDhc OIC90c']")).click();
        //Shot.take(driver);
        Thread.sleep(2000);

        WebElement plan_check = driver.findElement(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
        actions.scrollToElement(plan_check);
        plan_check.click();
        //Shot.take(driver);
        Thread.sleep(2000);


        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='BDhuSb']")));
        driver.findElement(By.xpath("//div[@jsname='wQNmvb']")).click();

        driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).click();
        //driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).sendKeys(Keys.ENTER);
        //Shot.take(driver);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac']")).click();
        //Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frm5);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());


//        WebElement text5 = driver.findElement(By.name("mytext5"));
//        actions.scrollToElement(text5).click(text5);
//        Thread.sleep(1000);
//        text5.sendKeys("Test frame5");
//        Thread.sleep(2000);
        driver.quit();


    }

    @Test
    void test2() throws InterruptedException, IOException {
        chromeOptions.addArguments("--headless=new");
        String browser = Config.browser;

        if(browser.contains("chrome"))

            driver = new RemoteWebDriver(new URL(Config.hub),chromeOptions);

            //driver = new ChromeDriver();
        else if (browser.contains("edge"))

            driver = new RemoteWebDriver(new URL(Config.hub), edgeOptions);
            //driver = new EdgeDriver();
        else
            driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get(Config.url);

        Actions actions = new Actions(driver);

        WebElement frm = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frm);

        driver.findElement(By.name("mytext1")).sendKeys("Test frame1");
        Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frm2);

        driver.findElement(By.name("mytext2")).sendKeys("Test frame2");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(frm4);

        driver.findElement(By.name("mytext4")).sendKeys("Test frame4");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frm3);
        driver.findElement(By.name("mytext3")).sendKeys("Frame 3 test");
        Shot.take(driver);
        Thread.sleep(2000);

        WebElement frm6 = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        driver.switchTo().frame(frm6);

        System.out.println(driver.findElement(By.xpath("//div[@class='cBGGJ OIC90c']")).getText());

        driver.findElement(By.xpath("//span[@class='aDTYNe snByac OvPDhc OIC90c']")).click();
        Shot.take(driver);
        Thread.sleep(2000);

        WebElement plan_check = driver.findElement(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
        actions.scrollToElement(plan_check);
        plan_check.click();
        Shot.take(driver);
        Thread.sleep(2000);


        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='BDhuSb']")));
        driver.findElement(By.xpath("//div[@jsname='wQNmvb']")).click();

        driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).click();
        //driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).sendKeys(Keys.ENTER);
        Shot.take(driver);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac']")).click();
        Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frm5);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());


//        WebElement text5 = driver.findElement(By.name("mytext5"));
//        actions.scrollToElement(text5).click(text5);
//        Thread.sleep(1000);
//        text5.sendKeys("Test frame5");
//        Thread.sleep(2000);
        driver.quit();


    }

    @Test
    void test3() throws InterruptedException, IOException {
        chromeOptions.addArguments("--headless=new");
        String browser = Config.browser;

        if(browser.contains("chrome"))

            driver = new RemoteWebDriver(new URL(Config.hub),chromeOptions);

            //driver = new ChromeDriver();
        else if (browser.contains("edge"))

            driver = new RemoteWebDriver(new URL(Config.hub), edgeOptions);
            //driver = new EdgeDriver();
        else
            driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get(Config.url);

        Actions actions = new Actions(driver);

        WebElement frm = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frm);

        driver.findElement(By.name("mytext1")).sendKeys("Test frame1");
        Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frm2);

        driver.findElement(By.name("mytext2")).sendKeys("Test frame2");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(frm4);

        driver.findElement(By.name("mytext4")).sendKeys("Test frame4");
        Shot.take(driver);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frm3);
        driver.findElement(By.name("mytext3")).sendKeys("Frame 3 test");
        Shot.take(driver);
        Thread.sleep(2000);

        WebElement frm6 = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        driver.switchTo().frame(frm6);

        System.out.println(driver.findElement(By.xpath("//div[@class='cBGGJ OIC90c']")).getText());

        driver.findElement(By.xpath("//span[@class='aDTYNe snByac OvPDhc OIC90c']")).click();
        Shot.take(driver);
        Thread.sleep(2000);

        WebElement plan_check = driver.findElement(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
        actions.scrollToElement(plan_check);
        plan_check.click();
        Shot.take(driver);
        Thread.sleep(2000);


        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='BDhuSb']")));
        driver.findElement(By.xpath("//div[@jsname='wQNmvb']")).click();

        driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).click();
        //driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).sendKeys(Keys.ENTER);
        Shot.take(driver);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac']")).click();
        Shot.take(driver);

        driver.switchTo().defaultContent();

        WebElement frm5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frm5);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());


//        WebElement text5 = driver.findElement(By.name("mytext5"));
//        actions.scrollToElement(text5).click(text5);
//        Thread.sleep(1000);
//        text5.sendKeys("Test frame5");
//        Thread.sleep(2000);
        driver.quit();


    }


}

