package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        //It is used to set the driver
                             //the name of driver         //the path of the driver
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        //This is Polymorphism
        //Creating obj by using sub child

        //Interview Question
        // !!! How you used Polymorphism in your project? ==> Creating the instance -object of driver
        WebDriver driver =new ChromeDriver();

        driver.get("https://www.google.com/");

    }
}
