package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) throws InterruptedException {
        //Set Path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        //Creating driver object(instance)
        WebDriver driver =new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //open google home page
        driver.get("https://www.google.com");

        //This is kind of wait
        //In automation waits are used widely.
        Thread.sleep( 5000);

        //Navigate to amazon home page https://www.amazon.com
       // driver.get("https://www.amazon.com");

        //Navigate.to() is also go to a webpage
        driver.navigate().to( "https://www.amazon.com");
        Thread.sleep( 5000);

        //Navigate back to google
        driver.navigate().back();
        Thread.sleep( 5000);

        // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep( 5000);

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep( 5000);

        //Close/Quit the browser
        //driver.close(); // Close only current one
       driver.quit(); // Quit closes all the browsers



        /*

        We learned :
        Get and Navigate methods
        What are the differences  between get() and navigate()
        1. get() is easier and faster  , but navigate() has some other functions like (back, forward and refresh)
        2. navigate() uses both string and URL data type url, but get only uses string Url.

         */




    }
    /*
    Create a new class under : BasicNavigations Create main method
 Set Path
 Create chrome driver
Maximize the window
 Open google home page https://www.google.com/.
 On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
 Navigate forward to amazon
 Refresh the page
 Close/Quit the browser
     */



}
