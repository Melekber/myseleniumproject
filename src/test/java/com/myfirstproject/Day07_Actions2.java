package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Day07_Actions2 extends TestBase {

    @Test
    public void hoverOver() throws InterruptedException {
//        Create a class: Actions2
//        Create test method : hoverOver() and test the following scenario:
//        Given user is on the https://www.amazon.com/
//        When use click on “Account” link
//        Then verify the page title contains “Your Account”
        driver.get("https://www.amazon.com");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));

//       try{
        // IF NO THANKS IS VISIBLE, IT CLICKS
//    OTHERWISE, WE WILL CATCH THE EXCELTIP IN CATCH BLOCK
//    CODE WILL CONTINUE TO EXECUTE
//           driver.findElement(By.xpath("No Thanks")).click();
//
//       }catch(Exception e){
//           e.getMessage();
//
//       }

        //1. Create actions class
        Actions actions = new Actions(driver);
        //2. Use proper actions method
        //Move the mouse over account list element
        actions.moveToElement(accountList).perform();
        Thread.sleep(5000);
        //Then click on Account option
        driver.findElement(By.linkText("Account")).click();

        //
        Assert.assertEquals("Your Account", driver.getTitle());


    }
}
