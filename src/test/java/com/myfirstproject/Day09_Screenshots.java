package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Day09_Screenshots extends TestBase {
    /*
What is javascript executor
It is an interface. A selenium api that is used to handle some actions.
Click and scrolling actions can be handled with is easier.
It is more powerful than selenium clicks.
It can communicate with web pages better.
I use it for the elements that can't be clicked with Selenium methods.
I use it to handle scrolling issues like scroll until an element and scroll to the bottom.
I create an object to use it from JavaScriptExecutor class

 */

    /*
    How do you take screenshot? How you automated taking screenshot in your current project?
    - There is an interface called TakesScreenshot
    I use getScreenshotAs methods.
    I have a utilities package and reusable methods class and i have a takeScreenshot method.I use that method


    When do you take screenshot?
    If my test scenario fails. To open a bug ticket we need some proves.
    If you find the bug with automation then there should be a method to provide a proof
     */


    public void takeScreenShot()  {

        //1. TakesScreenshot is used to take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // getScreenShotAs method to take a screenshot the type is File
        File image = ts.getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // Where you store the images
        // test-output/Screenshots.png;
        String path =  System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+".png";
        File finalPath = new File(path);
        try {
            FileUtils.copyFile(image,finalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getScreenShot() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement button =driver.findElement(By.id("L2AGLb"));
        button.click();
        takeScreenShot();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Iphone X Prices"+ Keys.ENTER);
        takeScreenShot();

    }
}
