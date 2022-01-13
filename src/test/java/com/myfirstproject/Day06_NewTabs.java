package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Day06_NewTabs {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void newTabs() throws InterruptedException {

        // WINDOW HANDLE : getWindowHandle(): return the window handle of the current window.
       String window1Handle =  driver.getWindowHandle();
        System.out.println(window1Handle);
       /*
       Given user is on the https://the-internet.herokuapp.com/windows
    Then user verifies the text : “Opening a new window”
    Then user verifies the title of the page is “The Internet”
    When user clicks on the “Click Here” button
    Then user verifies the new window title is “New Window”
    Then user verifies the text: “New Window”
    When user goes back to the previous window and then verifies the title : “The Internet”
        */

       String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

        driver.findElement(By.linkText("Click Here")).click();

        //NOTE : When we click the link new tab open.THEN we must switch to the new tab !
       Set <String> allWindowHandles =  driver.getWindowHandles();

       //Switching to the second widow
        // Logic is switch if driver is not on the window1
       for(String eachWindowHandle : allWindowHandles){
           if(!eachWindowHandle.equals(window1Handle)){
               driver.switchTo().window(eachWindowHandle);
               break;

           }
       }


        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);

        String window2Handle = driver.getWindowHandle();
        System.out.println(window2Handle);

       String window2Text = driver.findElement(By.xpath("//h3")).getText();
       Assert.assertEquals("New Window", window2Text);
       Thread.sleep(5000);

       //Switching back to window 1
       driver.switchTo().window(window1Handle);
       Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Switching back to window 2
        driver.switchTo().window(window2Handle);
        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //Switching back to window 1
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
