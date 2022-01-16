package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day09_ScreenshotSel4 extends TestBase {
    /*
   In selenium 4 we can take screenshot of specific web element
    */
    @Test
    public void takeScreenShot() throws IOException, IOException {
        driver.get("https://www.google.com");
        WebElement button =driver.findElement(By.id("L2AGLb"));
        button.click();
        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File googleLogoImage = googleLogo.getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // Where you store the images
        // test-output/Screenshots.png;
        String path =  System.getProperty("user.dir")+ "/test-output/ScreenshotsForSel4/"+currentTime+".png";
        File finalPath = new File(path);
        FileUtils.copyFile(googleLogoImage,finalPath);

    }

}
