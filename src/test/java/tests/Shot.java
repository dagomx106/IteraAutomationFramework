package tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Shot {
    @Test
    static void take(WebDriver driver) throws IOException {
        Date current = new Date();
        System.out.println(current);

        String screenshotName = current.toString().replace(" ","-").replace(":","-");

        System.out.println(screenshotName);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(screenshotName+".png"));

        //TakesScreenshot
    }
}
